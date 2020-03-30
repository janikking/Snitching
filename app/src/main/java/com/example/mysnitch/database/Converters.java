package com.example.mysnitch.database;

import android.location.Location;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
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
    public static String userToString(User user){
        return new Gson().toJson(user);
    }

    @TypeConverter
    public static User stringToUser(String string){
        return new Gson().fromJson(string, User.class);
    }

    @TypeConverter
    public static String toTimestamp(Date date){
        return date.toString();
    }

    @TypeConverter
    public static Date fromTimeStamp(String string){
        return new Date(string);
    }

    @TypeConverter
    public static String vehicleToString(Vehicle vehicle){
        return new Gson().toJson(vehicle);
    }

    @TypeConverter
    public static Vehicle stringToVehicle(String string){
        return new Gson().fromJson(string, Vehicle.class);
    }

    @TypeConverter
    public static Media stringToMedia(String string){
        return new Gson().fromJson(string, Media.class);
    }

    @TypeConverter
    public static String mediaToString(Media media){
        return new Gson().toJson(media);
    }

    @TypeConverter
    public static Location stringToLocation(String string){
        return new Location(string);
    }

    @TypeConverter
    public static String locationToString(Location location){
        return location.getProvider();
    }



/*
    @TypeConverter
    public static String mediaToString(Media media){
        if (media == null) return null; else return media.toString();
    }



    @TypeConverter
    public static String locationToString(Location location){
        if (location == null) return null; else return location.toString();
    }

     */
}
