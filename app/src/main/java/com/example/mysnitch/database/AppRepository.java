package com.example.mysnitch.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.mysnitch.Report;

import java.util.List;

public class AppRepository {

    private String DB_NAME = "db_app";
    private AppDatabase appDatabase;

    public AppRepository(Context context){
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }


    // Creates new report to be sent to insertReport which stores it in database
    public void insertReport(String title, String description, String licensePlate){
        Report report = new Report(title, description, licensePlate);
        insertReport(report);
    }


    // Adds the created report inside the actual database
    public void insertReport(final Report report){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.reportDao().insertReport(report);
                return null;
            }
        }.execute();
    }


    // Updates report
    public void updateReport(final Report report){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.reportDao().updateReport(report);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final Report report){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.reportDao().deleteReport(report);
                return null;
            }
        }.execute();
    }

    public List<Report> getReports(){
        return appDatabase.reportDao().getAllReports();
    }

    public List<Report> getReportById(int id){
        return appDatabase.reportDao().getReportById(id);
    }
}
