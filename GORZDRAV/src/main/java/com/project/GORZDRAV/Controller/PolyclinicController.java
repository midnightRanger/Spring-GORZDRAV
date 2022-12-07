package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.*;
import com.project.GORZDRAV.Models.Record;
import com.project.GORZDRAV.Services.AddressService;
import com.project.GORZDRAV.Services.PolyclinicService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/polyclinic")
@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
public class PolyclinicController {

    public final PolyclinicService polyclinicService;
    public final AddressService addressService;

    public PolyclinicController(PolyclinicService polyclinicService, AddressService addressService) {
        this.polyclinicService = polyclinicService;
        this.addressService = addressService;
    }

    @GetMapping("/")
    public String getPolyclinic(@RequestParam(required = false) String keyword, Model model) {

        if (keyword == "" || keyword==null) {
            Iterable<Polyclinic> polyclinicIterable = polyclinicService.findAll();
            model.addAttribute("polycliniclist", polyclinicIterable);
        }

        else {
            List<Polyclinic> polyclinicIterable = polyclinicService.findByNameContains(keyword);
            model.addAttribute("polycliniclist", polyclinicIterable);
        }
        return "/polyclinic/polyclinic";
    }

    @GetMapping("/add")
    public String addPolyclinicView(Polyclinic polyclinic, Model model) {
        model.addAttribute("types", Type.values());
        return "polyclinic/polyclinic-add";
    }

    @PostMapping("/add")
    public String postPolyclinic(@RequestParam(name="types[]", required = false) String[] selectedTypes, @Valid Polyclinic polyclinic, @Valid Address address,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "polyclinic/polyclinic-add";

        for (String type:
                selectedTypes) {
            polyclinic.getTypes().add(Type.valueOf(type));
        }

        addressService.save(address);

        polyclinic.setAddress(address);
        polyclinicService.save(polyclinic);
        return "redirect:/polyclinic/";
    }

    @GetMapping("/polyclinic-info/{id}")
    public String detailPolyclinic(
            @PathVariable Long id,
            Model model
    )
    {
        Polyclinic polyclinic = polyclinicService.findById(id).orElseThrow();
        model.addAttribute("polyclinic", polyclinic);
        return "polyclinic/polyclinic-info";
    }

    @GetMapping("/polyclinic-info/{id}/del")
    public String deletePolyclinic(@PathVariable Long id) {
        Polyclinic polyclinic = polyclinicService.findById(id).orElseThrow();
        polyclinicService.delete(polyclinic);
        return "redirect:/polyclinic/";
    }

    @GetMapping("/polyclinic-info/{id}/upd")
    public String updPolyclinicGet(@PathVariable Long id, Model model)
    {


        Polyclinic polyclinic = polyclinicService.findById(id).orElseThrow();
        Address address = addressService.findById(polyclinic.getAddress().getUID()).orElseThrow();

        model.addAttribute("polyclinic", polyclinic);
        model.addAttribute("address", address);
        model.addAttribute("types", Type.values());
        return "polyclinic/polyclinic-upd";
    }

    @PostMapping("/polyclinic-info/{id}/upd" )
    public String updPolyclinicPost(@RequestParam(name="types[]", required = false) String[] selectedTypes, @PathVariable Long id, @Valid Polyclinic polyclinic, @Valid Address address,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "polyclinic/polyclinic-add";

        Polyclinic polyclinic2 = polyclinicService.findById(id).orElseThrow();

        for (String type:
                selectedTypes) {
            polyclinic.getTypes().add(Type.valueOf(type));
        }

        polyclinic.setUID(polyclinic2.getUID());
        address.setUID(polyclinic2.getAddress().getUID());
        addressService.save(address);

        polyclinic.setAddress(address);
        polyclinicService.save(polyclinic);
        return "redirect:/polyclinic/";
    }
}
