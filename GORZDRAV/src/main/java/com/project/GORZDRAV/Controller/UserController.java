package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.Passport;
import com.project.GORZDRAV.Models.User;
import com.project.GORZDRAV.Services.PassportService;
import com.project.GORZDRAV.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserController {
    final UserService userService;
    final PassportService passportService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PassportService passportService) {
        this.userService = userService;
        this.passportService = passportService;
    }

    @GetMapping("/")
    public String userView(User user, @RequestParam(defaultValue = "") String keyword, Model model) {

        if (keyword == "") {
            Iterable<User> userIterable = userService.findAll();
            model.addAttribute("userlist", userIterable);

        }
        else {
            List<User> userList = userService.findByUsernameContains(keyword);
            model.addAttribute("userlist", userList);
        }
        return "/user/user";
    }

    @GetMapping("/add")
    public String addUserView(  User user) {
        return "user/user-add";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, @Valid Passport passport, BindingResult bindingResult) {
        if(user.getUsername().equals("Nigger"))
            bindingResult.addError(new FieldError("user", "name",
                    "Недопустимое выражение!"));
        if(bindingResult.hasErrors())
            return "user/user-add";
        passportService.save(passport);
        user.setPassport(passport);
        userService.save(user);
        return "redirect:/admin/";
    }

    @GetMapping("/user-info/{id}")
    public String detailUser(
            @PathVariable Long id,
            Model model
    )
    {
        User userObj = userService.findById(id).orElseThrow();
        model.addAttribute("oneUser", userObj);
        return "user/user-info";
    }

    @GetMapping("/user-info/{id}/del")
    public String deluser(@PathVariable Long id) {
        User userObj = userService.findById(id).orElseThrow();
        userService.delete(userObj);
        return "redirect:/admin/";
    }


    @GetMapping("/user-info/{id}/upd")
    public String updUser(@PathVariable Long id, Model model)
    {
        model.addAttribute("user", userService.findById(id).orElseThrow());
        return "user/user-upd";
    }

    @PostMapping("/user-info/{id}/upd" )
    public String updUserPost(@PathVariable Long id, @Valid User user, Model model, BindingResult bindingResult, String[] roles)
    {
        if(user.getUsername().equals("Nigger"))
            bindingResult.addError(new FieldError("user", "name",
                    "Недопустимое выражение!"));
        if(bindingResult.hasErrors())
            return "user/user-upd";

        User updUser = userService.findById(id).orElseThrow();

        updUser.setUsername(user.getUsername());

        updUser.setUsername(user.getUsername());
        updUser.setSurname(user.getSurname());
        updUser.setPassword(passwordEncoder.encode(user.getPassword()));
        updUser.setMiddlename(user.getMiddlename());
        userService.save(updUser);
        return "redirect:/user/";
    }


}
