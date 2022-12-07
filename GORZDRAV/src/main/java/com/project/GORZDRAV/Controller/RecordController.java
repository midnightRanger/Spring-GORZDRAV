package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.*;
import com.project.GORZDRAV.Models.Record;
import com.project.GORZDRAV.Services.MedicalCardService;
import com.project.GORZDRAV.Services.ProcedureService;
import com.project.GORZDRAV.Services.RecordService;
import com.project.GORZDRAV.Services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/record")
public class RecordController {

    public final RecordService recordService;
    public final UserService userService;
    public final ProcedureService procedureService;
    public final MedicalCardService medicalCardService;

    public RecordController(RecordService recordService, UserService userService, ProcedureService procedureService, MedicalCardService medicalCardService) {
        this.recordService = recordService;
        this.userService = userService;
        this.procedureService = procedureService;
        this.medicalCardService = medicalCardService;
    }

    @GetMapping("/")
    public String getRecords(@RequestParam(required = false) String keyword, Model model,
                             Authentication authentication, Principal principal) {

        Iterable<Record> recortIterable = recordService.findAll();

        ArrayList<Record> userRecords = new ArrayList<Record>();
        if (keyword == "" || keyword == null) {

            if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
                for (var record : recortIterable) {
                    if (record.getPatient().getUsername().equals(principal.getName())) {
                        userRecords.add(record);
                    }
                }
                model.addAttribute("recordlist", userRecords);
            }
            else
            model.addAttribute("recordlist", recortIterable);
        }

        else {
            List<Record> recordIterable = recordService.findByComplaintContains(keyword);
            model.addAttribute("recordlist", recordIterable);
        }
        return "/record/record";
    }

    @GetMapping("/add")
    public String addRecordView(Record record, Authentication authentication, Principal principal, Model model) {

        Iterable<User> users = userService.findAll();
        Iterable<MedicalProcedure> procedures = procedureService.findAll();
        ArrayList<User> patientList = new ArrayList<>();
        ArrayList<User> doctorList = new ArrayList<>();

        for(User user: users) {
            if(user.getRoles() != null) {
                for (var role : user.getRoles()) {
                    if (role == Role.DOCTOR) {
                        doctorList.add(user);
                    }
                    else patientList.add(user);
                }
            }
        }

        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
            patientList.clear();
            patientList.add(userService.findByUsername(principal.getName()));
        }


        model.addAttribute("patientlist", patientList);
        model.addAttribute("doctorlist", doctorList);
        model.addAttribute("procedurelist", procedures);

        return "record/record-add";
    }

    @PostMapping("/add")
    public String postRecord(@Valid Record record,
                             @RequestParam String patientselect,
                             @RequestParam String doctorselect,
                             @RequestParam String procedureselect,
                             BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "record/record-add";

        User doctorObj = userService.findByUsername(doctorselect);
        User patientObj = userService.findByUsername(patientselect);
        MedicalProcedure medicalProcedureObj = procedureService.findByName(procedureselect);

        record.setDoctor(doctorObj);
        record.setPatient(patientObj);
        record.setMedicalCard(patientObj.getMedicalCard());
        record.setProcedure(medicalProcedureObj);
        record.setOpened(true);
        recordService.save(record);
        return "redirect:/record/";
    }

    @GetMapping("/record-info/{id}")
    public String detailRecord(
            @PathVariable Long id,
            Model model
    )
    {
        Record record = recordService.findById(id).orElseThrow();
        model.addAttribute("record", record);
        return "record/record-info";
    }

    @GetMapping("/record-info/{id}/del")
    public String deleteRecordGet(@PathVariable Long id) {
        Record recordObj = recordService.findById(id).orElseThrow();
        recordService.delete(recordObj);
        return "redirect:/record/";
    }

    @GetMapping("/record-info/{id}/upd")
    public String updRecordGet(@PathVariable Long id, Model model)
    {
        Iterable<User> users = userService.findAll();
        Iterable<MedicalProcedure> procedures = procedureService.findAll();
        ArrayList<User> patientList = new ArrayList<>();
        ArrayList<User> doctorList = new ArrayList<>();

        for(User user: users) {
            if(user.getRoles() != null) {
                for (var role : user.getRoles()) {
                    if (role == Role.DOCTOR) {
                        doctorList.add(user);
                    }
                    else patientList.add(user);
                }
            }
        }
        model.addAttribute("patientlist", patientList);
        model.addAttribute("doctorlist", doctorList);
        model.addAttribute("procedurelist", procedures);

        model.addAttribute("record", recordService.findById(id).orElseThrow());
        return "record/record-upd";
    }

    @PostMapping("/record-info/{id}/upd" )
    public String updRecordPost(@PathVariable Long id,
                                @Valid Record record,
                                @RequestParam String patientselect,
                                @RequestParam String doctorselect,
                                @RequestParam String procedureselect,
                                Model model,
                                BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "record/record-upd";

        User doctorObj = userService.findByUsername(doctorselect);
        User patientObj = userService.findByUsername(patientselect);
        MedicalCard medicalCard = medicalCardService.findBySnils(patientObj.getMedicalCard().getSnils());
        MedicalProcedure medicalProcedureObj = procedureService.findByName(procedureselect);

        record.setUID(id);
        record.setProcedure(medicalProcedureObj);
        record.setPatient(patientObj);
        record.setDoctor(doctorObj);
        record.setMedicalCard(medicalCard);
        recordService.save(record);
        return "redirect:/record/";
    }
}
