package com.example.demo.service;

import com.example.demo.entity.Job;

import java.util.List;

public interface JobService {
    public Job saveJob(Job job);

    public List<Job> fetchAllJobs(int pageNo);

    public Job fetchJobById(Long id);

    public void deleteJobById(Long id);

    public List<Job> getJobsByName(String name, int pageNo);

    public List<Job> getFeaturedJobs();

    public List<Job> getJobsByCategory(String category);
}
