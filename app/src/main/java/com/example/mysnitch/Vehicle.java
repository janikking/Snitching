package com.example.mysnitch;

public class Vehicle {
    private String licensePlate;
    private int timesReported;
    private String vehicleDescription;

    public Vehicle(String licensePlate)
    {
        this.setLicensePlate(licensePlate);
        timesReported = 1;
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
}
