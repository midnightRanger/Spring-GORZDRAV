package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.Passport;
import com.project.GORZDRAV.Models.User;
import com.project.GORZDRAV.Services.PassportService;
import com.project.GORZDRAV.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/passport")
public class PassportController {

    final PassportService passportService;
    final UserService userService;

    public PassportController(PassportService passportService, UserService userService) {
        this.passportService = passportService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getPassports(@RequestParam(defaultValue = "") String keyword, Model model) {

        if (keyword == "") {
            Iterable<Passport> passportIterable = passportService.findAll();
            model.addAttribute("passportlist", passportIterable);
        }

        else {
            List<Passport> passportIterable = passportService.findBySeriesContains(keyword);
            model.addAttribute("passportlist", passportIterable);
        }
        return "/passport/passport";
    }

    @GetMapping("/add")
    public String postPassportView(Passport passport, Model model) {

        Iterable<User> users = userService.findAll();
        ArrayList<User> userList = new ArrayList<>();

        for(User user: users) {
            if(user.getPassport() == null) {
                userList.add(user);
            }
        }
        model.addAttribute("userlist", userList);

        return "passport/passport-add";
    }

    @PostMapping("/add")
    public String postPassport(@Valid Passport passport, @RequestParam String username, BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "passport/passport-add";

        User owner = userService.findByUsername(username);
        passport.setPassportOwner(owner);
        passportService.save(passport);
        return "redirect:/passport/";
    }

    @GetMapping("/passport-info/{id}")
    public String detailPassport(
            @PathVariable Long id,
            Model model
    )
    {
        Passport passportObj = passportService.findById(id).orElseThrow();
        model.addAttribute("passport", passportObj);
        return "passport/passport-info";
    }

    @GetMapping("/passport-info/{id}/del")
    public String deletePassportGet(@PathVariable Long id) {
        Passport passportObj = passportService.findById(id).orElseThrow();
        passportService.delete(passportObj);
        return "redirect:/passport/";
    }

    @GetMapping("/passport-info/{id}/upd")
    public String updPassportGet(@PathVariable Long id, Model model)
    {
        model.addAttribute("passport", passportService.findById(id).orElseThrow());
        return "passport/passport-upd";
    }

    @PostMapping("/passport-info/{id}/upd" )
    public String updPassportPost(@PathVariable Long id, @Valid Passport passport, Model model, BindingResult bindingResult) {


        if(bindingResult.hasErrors())
            return "passport/passport-upd";

        Passport updPassport = passportService.findById(id).orElseThrow();

        updPassport.setPassportOwner(passport.getPassportOwner());
        updPassport.setGiven(passport.getGiven());
        updPassport.setNumber(passport.getNumber());
        updPassport.setSeries(passport.getSeries());


        passportService.save(updPassport);
        return "redirect:/passport/";
    }
}
