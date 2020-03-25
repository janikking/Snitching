package com.example.mysnitch;

import android.location.Location;

import java.util.Date;

public class Report {

    private User user;
    private Media media;
    private Vehicle vehicle;

    private String title;
    private String description;
    private Date date;
    private Location location;

    public Report(User user, Media media, Vehicle vehicle, String title, String description, Date date, Location location){
        this.setUser(user);
        this.setMedia(media);
        this.setVehicle(vehicle);
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
        this.setLocation(location);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
