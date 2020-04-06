package com.example.mysnitch;

import android.location.Location;
import android.location.LocationProvider;

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
    @Ignore
    private static ArrayList<Report> reports = new ArrayList<>();

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private  String location;
    private User user;

    @Ignore
    private Media media;

    private Vehicle vehicle;
    private Date date;

    @Ignore
    private String licensePlate;

    // Licensplate constructor weggehaald, zorgde voor confusion in Android Room
    // In AppRepository wordt nu een Vehicle gemaakt van de licenseplate als die nog niet bestond
    public Report(String title, String description, Vehicle vehicle, String longitude, String latitude )
    {
        this.setId(id);
        this.setLicensePlate(licensePlate);
        this.setTitle(title);
        this.setDescription(description);

        if( !Vehicle.licensePlateExists( licensePlate.toUpperCase() ) )
            Vehicle.addVehicle( licensePlate.toUpperCase() );

        this.vehicle = Vehicle.getVehicleByLicensePlate( licensePlate.toUpperCase() );
        vehicle.setTimesReported(vehicle.getTimesReported() + 1);

        user = User.getLoggedInUser();
        date = new Date();

        User.getLoggedInUser().setSnitchScore( User.getLoggedInUser().getSnitchScore() + 1 );

        // TODO get the current location and put it in location
        location = location + longitude + "" + latitude;
    }


    public Report(String title, String description, User user, Media media, Vehicle vehicle, Date date, String location){
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
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

    public static ArrayList<Report> getReports() {
        return reports;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}
