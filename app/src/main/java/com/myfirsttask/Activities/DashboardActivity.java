package com.myfirsttask.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.myfirsttask.R;
import com.myfirsttask.SharePref.Utils;
import com.myfirsttask.fragments.GroundsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.my_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));


        Utils.setIsLoggedIn(DashboardActivity.this, "1");

        BottomNavigationView navigation = findViewById(R.id.user_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        switchFragment(new GroundsFragment());
    }

    private void switchFragment(GroundsFragment groundsFragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, groundsFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.grounds:
                switchFragment(new GroundsFragment());
                toolbar.setTitle("Grounds");
                break;

            case R.id.logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Alert");
                builder.setMessage("Do you really want to logout?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(DashboardActivity.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        Utils.setIsLoggedIn(DashboardActivity.this, "0");



                    }

                })
                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton("No", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;

        }


        return true;
    }
}
