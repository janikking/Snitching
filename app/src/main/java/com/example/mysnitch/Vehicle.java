package com.example.mysnitch;

import java.util.ArrayList;

public class Vehicle {
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    private String licensePlate;
    private int timesReported;
    private String vehicleDescription;

    public Vehicle(String licensePlate)
    {
        this.setLicensePlate(licensePlate);
        timesReported = 0;
    }

    public static boolean licensePlateExists( String licensePlate )
    {
        for( Vehicle vehicle : vehicles )
        {
            if( vehicle.getLicensePlate().equals( licensePlate ) )
                return true;
        }
        return false;
    }

    public static Vehicle getVehicleByLicensePlate( String licensePlate )
    {
        for( Vehicle vehicle : vehicles )
        {
            if( vehicle.getLicensePlate().equals( licensePlate ) )
                return vehicle;
        }
        return null;
    }

    public static void addVehicle( String licensePlate )
    {
        vehicles.add( new Vehicle( licensePlate ) );
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getTimesReported() {
        return timesReported;
    }

    public void setTimesReported(int timesReported) {
        this.timesReported = timesReported;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
