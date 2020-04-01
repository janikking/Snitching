package com.example.mysnitch.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.mysnitch.Media;
import com.example.mysnitch.Report;
import com.example.mysnitch.User;
import com.example.mysnitch.Vehicle;
import com.example.mysnitch.DiscussionThread;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppRepository {

    private String DB_NAME = "db_app";
    private AppDatabase appDatabase;
    // myExecutor zorgt zorgt voor ez functies op een aparte thread laten runnen
    // Android room wil niet dat je db operaties op de main Thread uitvoert
    private final ExecutorService myExecutor = Executors.newSingleThreadExecutor();
    public AppRepository(Context context){
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }



    /*
        REPORT FUNCTIONS
     */

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

    public List<Report> getReports() throws ExecutionException, InterruptedException{
        Future<List<Report>> reports = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                return appDatabase.reportDao().getAllReports();
            }
        });
       return reports.get();
    }

    public Report getReportById(final int id) throws ExecutionException, InterruptedException{
        Future<Report> report = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                return appDatabase.reportDao().getReportById(id);
            }
        });
        return report.get();
    }


     /*
        USER FUNCTIONS
     */

    public void insertUser(String username, String password, String mailAddress){
        User user = new User(username, password, mailAddress);
        insertUser(user);
    }

    public void insertUser(final User user){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.userDao().insertUser(user);
                return null;
            }
        }.execute();
    }

    public void updateUser(final User user){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.userDao().updateUser(user);
                return null;
            }
        }.execute();
    }

    public void deleteUser(final User user){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.userDao().deleteUser(user);
                return null;
            }
        }.execute();
    }

    public List<User> getAllUsers() throws  ExecutionException, InterruptedException {
        Future<List<User>> user = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                return appDatabase.userDao().getAllUsers();
            }
        });
        return user.get();

    }

    public User getUserById(final int id) throws ExecutionException, InterruptedException {
        Future<User> user = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                return appDatabase.userDao().getUserById(id);
            }
        });
        return user.get();
    }



    public User getUserByName(final String name) throws ExecutionException, InterruptedException {
        Future<User> user = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                return appDatabase.userDao().getUserByName(name);
            }
        });
        return user.get();
    }

    public Boolean userExists(final String name) throws ExecutionException, InterruptedException {
        Future<Boolean> exists = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                if(appDatabase.userDao().doesUserExist(name) == 0){
                    return false;
                }
                else{
                    return true;
                }
            }
        });
        return exists.get();

    }


    /*
        THREAD FUNCTIONS
     */

    public void insertThread(User user, String title, String content, Media media){
        DiscussionThread discussionThread = new DiscussionThread(user, title, content, media);
        insertThread(discussionThread);
    }

    public void insertThread(final DiscussionThread discussionThread){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.threadDao().insertThread(discussionThread);
                return null;
            }
        }.execute();
    }

    public void deleteThread(final DiscussionThread discussionThread){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.threadDao().deleteThread(discussionThread);
                return null;
            }
        }.execute();
    }

    public void updateThread(final DiscussionThread discussionThread){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids)    {
                appDatabase.threadDao().updateThread(discussionThread);
                return null;
            }
        }.execute();
    }

    public List<DiscussionThread> getAllThreads() throws ExecutionException, InterruptedException{
        Future<List<DiscussionThread>> discussionThread = myExecutor.submit(new Callable(){
            public Object call() throws Exception{
                return appDatabase.threadDao().getAllThreads();
            }
        });
        return discussionThread.get();
    }
}
