package com.example.student2student.query_task;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete_learn_to_student extends AsyncTask<String,Integer,String> {
    private final Context context;
    private int brenchid;
    public String query;

    String DB_URL = "jdbc:mysql://a757fb85-09c9-49bc-8772-a58f008e58f6.mysql.sequelizer.com:3306/dba757fb8509c949bc8772a58f008e58f6?useUnicode=yes&characterEncoding=UTF-8";
    String USER = "bjqdlncpsginpfvs";
    String PASS = "BJeASLFDyGpkwA5dzbmJkWFsfwvF7KVGngwtuUhzXiS2q3oqspfHbpFMcUvuqaEW";

    public delete_learn_to_student (Context context, int brenchid) {
        this.context = context;
        this.brenchid = brenchid;
    }

    @Override
    protected String doInBackground(String... params) {

        String response = "";

        try {
            boolean running = true;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

            String result = "\n Database connection succes\n";

            Statement st = con.createStatement();

            String id = params[0];

            query = "update students set learn=null where studentID ='"+id+"'";
//            update students set teach='שדגדשגשדגשדג' where studentID ='123'

            st.executeUpdate(query);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
