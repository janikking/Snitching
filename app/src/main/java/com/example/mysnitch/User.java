package com.example.mysnitch;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private String password;
    private String mailAddress;
    private int snitchScore;
    private int leaderboardPosition;




    @Ignore
    private static ArrayList<User> users = new ArrayList<>();
    @Ignore
    private static User loggedInUser;
    @Ignore
    private ArrayList<Report> madeReports;
    @Ignore
    private ArrayList<DiscussionThread> madeDiscussionThreads;

    public User(String username, String password, String mailAddress)
    {
        this.setUsername(username);
        this.setPassword(password);

        if( mailAddress == null )
            mailAddress = "";
        this.setMailAddress(mailAddress);
    }

    public static boolean userExists( String username )
    {
        for( User user : users )
        {
            if( user.getUsername().equals( username ) )
                return true;
        }
        return false;
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

    public ArrayList<DiscussionThread> getMadeDiscussionThreads() {
        return madeDiscussionThreads;
    }

    public void setMadeDiscussionThreads(ArrayList<DiscussionThread> madeDiscussionThreads) {
        this.madeDiscussionThreads = madeDiscussionThreads;
    }

    public static User getUser( String username )
    {
        for( User user : users )
        {
            if( user.getUsername().equals(username) )
            {
                return user;
            }
        }
        return null;
    }

    public static void addUser( User user )
    {
        users.add(user);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
