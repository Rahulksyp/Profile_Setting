package com.example.profilesetting.model;

public class DummyDataModel {
    String userName;
    String jobTitle;
    String location;
    String description;

    public DummyDataModel(String userName, String jobTitle, String location, String description) {
        this.userName = userName;
        this.jobTitle = jobTitle;
        this.location = location;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
