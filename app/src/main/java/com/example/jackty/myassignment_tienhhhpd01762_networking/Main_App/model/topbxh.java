package com.example.jackty.myassignment_tienhhhpd01762_networking.Main_App.model;

/**
 * Created by jackty on 11/08/2017.
 */

public class topbxh {
    String name;
    String score;
    String email;

    public topbxh() {
    }

    public topbxh(String name, String score, String email) {
        this.name = name;
        this.score = score;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "topbxh{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
