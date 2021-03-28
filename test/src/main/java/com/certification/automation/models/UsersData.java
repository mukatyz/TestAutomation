package com.certification.automation.models;

public class UsersData {
    private String name;
    private String job;
    private String id;

    public UsersData() {
    }

    public UsersData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getId() {
        return id;
    }
}
