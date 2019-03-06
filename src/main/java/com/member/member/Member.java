package com.member.member;

public class Member {
    private String id;
    private String email;
    private String password;
    private String name;
    private String address;

    public Member(){

    }

    public Member(String id, String email, String password, String name, String address){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
