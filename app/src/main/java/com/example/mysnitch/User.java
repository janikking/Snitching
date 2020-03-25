package com.example.mysnitch;

import java.util.ArrayList;

public class User {
    private static ArrayList<User> users;

    private String username;
    private String password;
    private String mailAddress;
    private int snitchScore;
    private int leaderboardPosition;

    private ArrayList<Report> madeReports;
    private ArrayList<Thread> madeThreads;

    public User(String username, String password, String mailAddress){
        this.setUsername(username);
        this.setPassword(password);
        this.setMailAddress(mailAddress);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public int getSnitchScore() {
        return snitchScore;
    }

    public void setSnitchScore(int snitchScore) {
        this.snitchScore = snitchScore;
    }

    public int getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(int leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }

    public ArrayList<Report> getMadeReports() {
        return madeReports;
    }

    public void setMadeReports(ArrayList<Report> madeReports) {
        this.madeReports = madeReports;
    }

    public ArrayList<Thread> getMadeThreads() {
        return madeThreads;
    }

    public void setMadeThreads(ArrayList<Thread> madeThreads) {
        this.madeThreads = madeThreads;
    }
}
