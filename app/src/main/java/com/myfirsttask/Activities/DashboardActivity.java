package com.myfirsttask.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.myfirsttask.R;
import com.myfirsttask.SharePref.Utils;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Utils.setIsLoggedIn(DashboardActivity.this, "1");
    }
}
