package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please add job title")
    private String title;
    private String company;
    private String date;
    @Column(length=1000000)
    private String summary;
    @Column(length=1000000)
    private List<String> duties;
    @Column(length=1000000)
    private List<String> qualifications;
    @Column(length=1000000)
    private List<String> applyInstructions;
    private String applyLink;
    private List<String> tags;
    private boolean featured;
    private String category;
}
