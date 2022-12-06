package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.*;
import com.project.GORZDRAV.Models.Record;
import com.project.GORZDRAV.Services.ProcedureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/procedure")
public class ProcedureController {
    public final ProcedureService procedureService;

    public ProcedureController(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @GetMapping("/")
    public String getProcedure(@RequestParam(required = false) String keyword, Model model) {
        if (keyword == "" || keyword==null) {
            Iterable<MedicalProcedure> procedureIterable = procedureService.findAll();
            model.addAttribute("procedurelist", procedureIterable);
        }

        else {
            List<MedicalProcedure> procedureIterable = procedureService.findByNameContains(keyword);
            model.addAttribute("procedurelist", procedureIterable);
        }
        return "/procedure/procedure";
    }

    @GetMapping("/add")
    public String addProcedureView(MedicalProcedure procedure) {
        return "procedure/procedure-add";
    }

    @PostMapping("/add")
    public String postResult(@Valid MedicalProcedure procedure,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "procedure/procedure-add";
        procedureService.save(procedure);

        return "redirect:/procedure/";
    }

    @GetMapping("/procedure-info/{id}")
    public String detailProcedure(
            @PathVariable Long id,
            Model model
    )
    {
        MedicalProcedure procedure = procedureService.findById(id).orElseThrow();
        model.addAttribute("procedure", procedure);
        return "procedure/procedure-info";
    }

    @GetMapping("/procedure-info/{id}/del")
    public String deleteProcedure(@PathVariable Long id) {
        MedicalProcedure procedure = procedureService.findById(id).orElseThrow();
        procedureService.delete(procedure);
        return "redirect:/procedure/";
    }

    @GetMapping("/procedure-info/{id}/upd")
    public String updProcedureGet(@PathVariable Long id, Model model)
    {
        model.addAttribute("medicalProcedure", procedureService.findById(id));
        return "procedure/procedure-upd";
    }

    @PostMapping("/procedure-info/{id}/upd")
    public String updResultPost(@PathVariable Long id,
                                @Valid MedicalProcedure medicalprocedure, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "procedure/procedure-add";
        medicalprocedure.setUID(id);
        procedureService.save(medicalprocedure);
        return "redirect:/procedure/";
    }
}

