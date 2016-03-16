package com.example.student2student.query_task;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class import_list extends AsyncTask<String,String,ArrayList<String>> {

    private final Activity activity;
    private final Context context;
    private int brenchid;
    public String query;
    ArrayList<String> listOfCourses;

    private ArraylistQueryInterface queryInterface;

    String DB_URL = "jdbc:mysql://a757fb85-09c9-49bc-8772-a58f008e58f6.mysql.sequelizer.com:3306/dba757fb8509c949bc8772a58f008e58f6";
    String USER = "bjqdlncpsginpfvs";
    String PASS = "BJeASLFDyGpkwA5dzbmJkWFsfwvF7KVGngwtuUhzXiS2q3oqspfHbpFMcUvuqaEW";

    public import_list(Activity activity, Context context, int brenchid)
    {

        this.activity = activity;
        this.context = context;
        this.brenchid = brenchid;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public void setInterface(ArraylistQueryInterface queryInterface){
        this.queryInterface = queryInterface;
    }



    @Override
    protected ArrayList<String> doInBackground(String... params) {

        listOfCourses = new ArrayList<String>();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            String result = "\n Database connection succes\n";

            Statement st = con.createStatement();

            if(st != null)
            {
                Log.i("good", " statement " + con);
                Log.i("good"," statement " +st);

            }
            query = "SELECT * FROM coursesByOcc";

            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                listOfCourses.add(rs.getString(2));
            }
            con.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return listOfCourses;
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);

        if (strings == null) {
            queryInterface.onError();
        }else {
            queryInterface.onSuccess(strings);
        }
    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);

        Log.i("TAG6", "ist fine!!");
    }

//    public void setCallback(ArraylistQueryInterface callback) {
//        queryInterface = callback;
//    }

}
