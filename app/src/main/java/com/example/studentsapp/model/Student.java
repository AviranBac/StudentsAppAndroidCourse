package com.example.studentsapp.model;

public class Student {
    private String name;
    private String id;
    private String phone;
    private String address;
    private Boolean checked;

    public Student(String name, String id, String phone, String address, Boolean checked) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getChecked() {
        return this.checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
