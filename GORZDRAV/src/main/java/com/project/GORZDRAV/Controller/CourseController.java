package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.Course;
import com.project.GORZDRAV.Models.Pill;
import com.project.GORZDRAV.Services.CourseService;
import com.project.GORZDRAV.Services.PillService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/course")
@PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR')")
public class CourseController {

    public final CourseService courseService;
    public final PillService pillService;

    public CourseController(CourseService courseService, PillService pillService) {
        this.courseService = courseService;
        this.pillService = pillService;
    }

    @GetMapping("/")
    public String getCourses(@RequestParam(required = false) String keyword, Model model) {
        if (keyword == "" || keyword==null) {
            Iterable<Course> courseIterable = courseService.findAll();
            model.addAttribute("courselist", courseIterable);
        }

        else {
            List<Course> courseIterable = courseService.findByExpectedResultContains(keyword);
            model.addAttribute("courselist", courseIterable);
        }
        return "/course/course";
    }

    @GetMapping("/add")
    public String addCourseView(Course course, Model model) {
        model.addAttribute("pillslist", pillService.findAll());
        return "course/course-add";
    }

    @PostMapping("/add")
    public String postCourse(@Valid Course course, @RequestParam(name="pillslist[]", required = false) String[] selectedPills,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "course/course-add";

        ArrayList<Pill> pillsList = new ArrayList<Pill>();
        for (String pills : selectedPills) {
            pillsList.add(pillService.findByName(pills));
        }
        course.setPills(pillsList);
        courseService.save(course);

        return "redirect:/course/";
    }

    @GetMapping("/course-info/{id}")
    public String detailCourse(
            @PathVariable Long id,
            Model model
    )
    {
        Course course = courseService.findById(id).orElseThrow();
        model.addAttribute("course", course);
        return "course/course-info";
    }

    @GetMapping("/course-info/{id}/del")
    public String deleteCourse(@PathVariable Long id) {
        Course course = courseService.findById(id).orElseThrow();
        courseService.delete(course);
        return "redirect:/course/";
    }

    @GetMapping("/course-info/{id}/upd")
    public String updCourseGet(@PathVariable Long id, Model model)
    {
        model.addAttribute("pillslist", pillService.findAll());
        model.addAttribute("course", courseService.findById(id));
        return "course/course-upd";
    }

    @PostMapping("/course-info/{id}/upd")
    public String updCoursePost(@PathVariable Long id,
                                @Valid Course course,
                                @RequestParam(name="pillslist[]", required = false) String[] selectedPills,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "course/course-add";

        ArrayList<Pill> pillsList = new ArrayList<Pill>();
        for (String pills : selectedPills) {
            pillsList.add(pillService.findByName(pills));
        }
        course.setPills(pillsList);

        course.setUID(id);
        courseService.save(course);
        return "redirect:/course/";
    }
}
