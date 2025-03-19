package com.example.demo.model;

public class Job {
    private Integer id;
    private String title;
    private String company;
    private String description;

    public Job() {}

    public Job(int id, String title, String company, String description) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
