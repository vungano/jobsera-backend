package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class JobController {

    public static final String DEFAULT_PAGE_NUMBER = "0";
    public  static final String DEFAULT_PAGE_SIZE = "12";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "desc";


    @Autowired
    private JobService jobService;

    @PostMapping("/jobs")
    public Job saveJob(@Valid @RequestBody Job job){
        return jobService.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> fetchAllJobs(@RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo){
        return  jobService.fetchAllJobs(pageNo);
    }

    @GetMapping("/jobs/{id}")
    public Job fetchJobById(@PathVariable("id") Long id){
        return jobService.fetchJobById(id);
    }

    @DeleteMapping("jobs/{id}")
    public String deleteJobById(@PathVariable("id") Long id){
        jobService.deleteJobById(id);
        return "Job Deleted Successfully";
    }

    @GetMapping("/jobs/search")
    public List<Job> getJobsByName(@RequestParam(value = "query", defaultValue = "", required = true) String name,
                                   @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo){
        return jobService.getJobsByName(name, pageNo);
    }

    @GetMapping("/jobs/get_featured")
    public List<Job> getFeaturedJobs(){
        return jobService.getFeaturedJobs();
    }

    @GetMapping("jobs/category/{category}")
    public List<Job> getJobsByCategory(@PathVariable("category") String category){ return jobService.getJobsByCategory(category);}
}
