package com.project.GORZDRAV.Controller;

import com.project.GORZDRAV.Models.*;
import com.project.GORZDRAV.Models.Record;
import com.project.GORZDRAV.Services.CourseService;
import com.project.GORZDRAV.Services.RecordService;
import com.project.GORZDRAV.Services.ResultService;
import com.project.GORZDRAV.Services.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultController {
    public final ResultService resultService;
    public final RecordService recordService;
    public final CourseService courseService;
    public final StatusService statusService;

    public ResultController(ResultService resultService, RecordService recordService, CourseService courseService, StatusService statusService) {
        this.resultService = resultService;
        this.recordService = recordService;
        this.courseService = courseService;
        this.statusService = statusService;
    }

    @GetMapping("/")
    public String getResults(@RequestParam(required = false) String keyword, Model model) {

        if (keyword == "" || keyword==null) {
            Iterable<Result> resultIterable = resultService.findAll();
            model.addAttribute("resultlist", resultIterable);
        }

        else {
            List<Result> resultIterable = resultService.findByAnamnesisContains(keyword);
            model.addAttribute("resultlist", resultIterable);
        }
        return "/result/result";
    }

    @GetMapping("/add")
    public String addResultView(Result result, Model model) {
        Iterable<Record> records = recordService.findAll();
        Iterable<Course> courses = courseService.findAll();

        ArrayList<Record> recordList = new ArrayList<>();

        for(Record record: records) {
            if(record.isOpened()) {
                recordList.add(record);
                }
            }

        model.addAttribute("recordlist", recordList);
        model.addAttribute("courselist", courses);
        return "result/result-add";
    }

    @PostMapping("/add")
    public String postResult(@Valid Result result, @Valid Status status,
                             @RequestParam String recordselect,
                             @RequestParam String courseselect,
                             BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "result/result-add";

        Course courseObj = courseService.findByExpectedResult(courseselect);
        Record recordObj = recordService.findByComplaint(recordselect);

        result.setCourse(courseObj);
        result.setRecord(recordObj);

        statusService.save(status);
        result.setStatus(status);

        resultService.save(result);
        return "redirect:/result/";
    }

    @GetMapping("/result-info/{id}")
    public String detailResult(
            @PathVariable Long id,
            Model model
    )
    {
        Result result = resultService.findById(id).orElseThrow();
        model.addAttribute("result", result);
        return "result/result-info";
    }

    @GetMapping("/result-info/{id}/del")
    public String deleteResult(@PathVariable Long id) {
        Result result = resultService.findById(id).orElseThrow();
        resultService.delete(result);
        return "redirect:/result/";
    }

    @GetMapping("/result-info/{id}/upd")
    public String updResultGet(@PathVariable Long id, Model model)
    {
        Iterable<Record> records = recordService.findAll();
        Iterable<Course> courses = courseService.findAll();

        ArrayList<Record> recordList = new ArrayList<>();

        for(Record record: records) {
            if(record.isOpened()) {
                recordList.add(record);
            }
        }

        model.addAttribute("recordlist", recordList);
        model.addAttribute("courselist", courses);

        model.addAttribute("result", resultService.findById(id).orElseThrow());
        return "result/result-add";
    }

    @PostMapping("/record-info/{id}/upd" )
    public String updResultPost(@PathVariable Long id,
                                @Valid Result result,
                                @Valid Status status,
                                @RequestParam String recordselect,
                                @RequestParam String courseselect,
                                BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "result/result-add";

        Course courseObj = courseService.findByExpectedResult(courseselect);
        Record recordObj = recordService.findByComplaint(recordselect);

        result.setUID(id);
        result.setCourse(courseObj);
        result.setRecord(recordObj);
        result.setStatus(status);

        resultService.save(result);
        return "redirect:/result/";
    }
}
