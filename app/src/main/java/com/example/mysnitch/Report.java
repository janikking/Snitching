package com.example.mysnitch;

import android.location.Location;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import java.io.Serializable;
import java.util.Date;


@Entity
public class Report implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;

    @Ignore
    private User user;
    @Ignore
    private Media media;
    @Ignore
    private Vehicle vehicle;
    @Ignore
    private Date date;
    @Ignore
    private Location location;


    public Report(String title, String description){
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
    }


    public Report(int id, String title, String description, User user, Media media, Vehicle vehicle, Date date, Location location){
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
