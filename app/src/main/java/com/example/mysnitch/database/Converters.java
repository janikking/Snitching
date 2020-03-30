package com.example.mysnitch.database;

import android.location.Location;

import androidx.room.TypeConverter;

import com.example.mysnitch.Media;
import com.example.mysnitch.User;
import com.example.mysnitch.Vehicle;

import java.util.Date;


/*
    Dit werkt niet, is om unconventional objects op te slana zoals Date, Location.
    Ik heb voor nu @Ignore toegevoegd aan alles wat niet zomaar opgeslagen kan worden in Report.class
 */

public class Converters {

    @TypeConverter
    public static String fromTimestamp(Date date){
        if (date == null) return null; else return date.toString();
    }

    @TypeConverter
    public static String userToString(User user){
        if (user == null) return null; else return user.toString();
    }

    @TypeConverter
    public static String mediaToString(Media media){
        if (media == null) return null; else return media.toString();
    }

    @TypeConverter
    public static String vehicleToString(Vehicle vehicle){
        if (vehicle == null) return null; else return vehicle.getLicensePlate();
    }

    @TypeConverter
    public static String locationToString(Location location){
        if (location == null) return null; else return location.toString();
    }
}
