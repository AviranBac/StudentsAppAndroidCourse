package com.example.studentsapp.model;

public class Student {
    private String name;
    private String id;
    private String avatarUrl;
    private Boolean checked;

    public Student(String name, String id, String avatarUrl, Boolean checked) {
        this.name = name;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.checked = checked;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getChecked() {
        return this.checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
