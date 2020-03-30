package com.example.mysnitch;

import android.location.Location;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.mysnitch.database.Converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


@Entity
@TypeConverters(Converters.class)
public class Report implements Serializable {

    private static ArrayList<Report> reports = new ArrayList<>();

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private User user;

    private Media media;

    private Vehicle vehicle;

    private Date date;
    private Location location;


    public Report(String title, String description, String licensePlate )
    {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);

        if( !Vehicle.licensePlateExists( licensePlate ) )
            Vehicle.addVehicle( licensePlate );

        this.vehicle = Vehicle.getVehicleByLicensePlate( licensePlate );

        user = User.getLoggedInUser();
        date = new Date();

        // TODO get the current location and put it in location
    }

    public Report(int id, String title, String description, User user, Media media, Vehicle vehicle, Date date, Location location){
        this.setId(id);
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

    public static void addReport( Report report )
    {
        reports.add( report );
    }
}
