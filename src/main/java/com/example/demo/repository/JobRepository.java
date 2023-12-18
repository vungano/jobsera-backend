package com.example.demo.repository;

import com.example.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query(value = "SELECT * FROM job j where LOWER(j.title) LIKE concat('%', LOWER(?1), '%') OR LOWER(j.tags) LIKE concat('%', LOWER(?1), '%') ORDER BY id DESC ", nativeQuery = true)
    public List<Job> findAllByName(String name);

    @Query(value = "SELECT * FROM job j where j.featured = true ORDER BY id DESC LIMIT 6", nativeQuery = true)
    public List<Job> getFeaturedJobs();

    @Query(value = "SELECT * FROM job j where j.category LIKE ?1 ORDER BY id DESC", nativeQuery = true)
    List<Job> findJobsByCategory(String category);
}
