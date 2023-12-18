package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImplementation implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> fetchAllJobs(int pageNo) {


        Sort sort =  Sort.by("id").descending();

        Pageable firstPageWithTwoElements = PageRequest.of(pageNo, 4,sort);

        Page<Job> posts = jobRepository.findAll(firstPageWithTwoElements);
        List<Job> listOfPosts = posts.getContent();
        return listOfPosts;
    }

    @Override
    public Job fetchJobById(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<Job> getJobsByName(String name, int pageNo) {

        return jobRepository.findAllByName(name);
    }

    @Override
    public List<Job> getFeaturedJobs() {
        return jobRepository.getFeaturedJobs();
    }

    @Override
    public List<Job> getJobsByCategory(String category) {
        return jobRepository.findJobsByCategory(category);
    }
}
