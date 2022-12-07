package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.MedicalCard;
import com.project.GORZDRAV.Models.Polyclinic;
import com.project.GORZDRAV.Models.User;
import com.project.GORZDRAV.Services.MedicalCardService;
import com.project.GORZDRAV.Services.PolyclinicService;
import com.project.GORZDRAV.Services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/medicalcard")
@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
public class MedicalCardController {

    final MedicalCardService medicalCardService;
    final UserService userService;
    final PolyclinicService polyclinicService;

    public MedicalCardController(MedicalCardService medicalCardService, UserService userService, PolyclinicService polyclinicService) {
        this.medicalCardService = medicalCardService;
        this.userService = userService;
        this.polyclinicService = polyclinicService;
    }

    @GetMapping("/")
    public String getMedicalCard(@RequestParam(required = false) String keyword, Model model) {

        if (keyword == "" || keyword == null) {
            Iterable<MedicalCard> medicalCardIterable = medicalCardService.findAll();
            model.addAttribute("medicalcardlist", medicalCardIterable);
        }

        else {
            List<MedicalCard> medicalCardIterable = medicalCardService.findBySnilsContains(keyword);
            model.addAttribute("medicalcardlist", medicalCardIterable);
        }
        return "/medicalcard/medicalcard";
    }

    @GetMapping("/add")
    public String getMedicalCardAdd(MedicalCard medicalCard, Model model) {

        Iterable<User> users = userService.findAll();
        Iterable<Polyclinic> polyclinics = polyclinicService.findAll();
        ArrayList<User> userList = new ArrayList<>();
        for(User user: users) {
            if(user.getMedicalCard() == null) {
                userList.add(user);
            }
        }
        model.addAttribute("userlist", userList);
        model.addAttribute("polycliniclist", polyclinics);

        return "medicalcard/medicalcard-add";
    }

    @PostMapping("/add")
    public String postMedicalCard(@Valid MedicalCard medicalCard, @RequestParam String username,
                                  @RequestParam(required = false) String polyclinicname,  BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "medicalcard/medicalcard-add";

        User owner = userService.findByUsername(username);
        Polyclinic polyclinic = polyclinicService.findByName(polyclinicname);
        medicalCard.setPolyclinic(polyclinic);
        medicalCard.setUser(owner);
        medicalCardService.save(medicalCard);
        return "redirect:/medicalcard/";
    }

    @GetMapping("/medicalcard-info/{id}")
    public String detailMedicalCard(
            @PathVariable Long id,
            Model model
    )
    {
        MedicalCard medicalCard = medicalCardService.findById(id).orElseThrow();
        model.addAttribute("medicalcard", medicalCard);
        return "medicalcard/medicalcard-info";
    }

    @GetMapping("/medicalcard-info/{id}/del")
    public String deleteMedicalCard(@PathVariable Long id) {
        MedicalCard medicalCard = medicalCardService.findById(id).orElseThrow();
        medicalCardService.delete(medicalCard);
        return "redirect:/medicalcard/";
    }

    @GetMapping("/medicalcard-info/{id}/upd")
    public String updMedicalCardGet(@PathVariable Long id, Model model)
    {

        Iterable<User> users = userService.findAll();
        Iterable<Polyclinic> polyclinics = polyclinicService.findAll();
        ArrayList<User> userList = new ArrayList<>();
        for(User user: users) {
            if(user.getMedicalCard() == null) {
                userList.add(user);
            }
        }
        model.addAttribute("userlist", userList);
        model.addAttribute("polycliniclist", polyclinics);

        model.addAttribute("medicalCard", medicalCardService.findById(id).orElseThrow());
        return "medicalcard/medicalcard-upd";
    }

    @PostMapping("/medicalcard-info/{id}/upd" )
    public String updMedicalCardPost(@PathVariable Long id, @Valid MedicalCard medicalCard,
                                     @RequestParam String username,
                                     @RequestParam(required = false) String polyclinicname,
                                     Model model, BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "medicalcard/medicalcard-upd";

        MedicalCard updMedicalCard = medicalCardService.findById(id).orElseThrow();
        User owner = userService.findByUsername(username);
        if (owner != null)
            updMedicalCard.setUser(owner);
        updMedicalCard.setHeight(medicalCard.getHeight());
        updMedicalCard.setPolyclinic(polyclinicService.findByName(polyclinicname));
        updMedicalCard.setWeight(medicalCard.getWeight());
        updMedicalCard.setDateOfTheBirth(medicalCard.getDateOfTheBirth());
        updMedicalCard.setSnils(medicalCard.getSnils());




        medicalCardService.save(updMedicalCard);
        return "redirect:/medicalcard/";
    }
}
