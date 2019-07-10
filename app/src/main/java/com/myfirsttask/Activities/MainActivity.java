package com.myfirsttask.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.myfirsttask.Model.LoginResponse;
import com.myfirsttask.Model.User;
import com.myfirsttask.R;
import com.myfirsttask.SharePref.Utils;
import com.myfirsttask.UserApi.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String CHANNEL_ID = "myFirst_Task";
    private static final String CHANNEL_NAME = "myFirstTask";
    private static final String CHANNEL_DESC = "myFirstTask Notifications";

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    private EditText useremail;
    private EditText userpassword;
    private Button btnlogin;
    private LinearLayout layoutLinear;


    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        useremail = findViewById(R.id.useremail);
        userpassword = findViewById(R.id.userpassword);
        btnlogin = findViewById(R.id.btnlogin);
        layoutLinear = findViewById(R.id.layoutLinear);

        findViewById(R.id.btnlogin).setOnClickListener(this);

        /*if (Utils.getIsLoggedIn(MainActivity.this).equals("0")) {
            Intent i = new Intent(MainActivity.this, DashboardActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }*/


    }

    private void displayNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.backfourvendor)
                .setContentTitle("Hey It's Working...")
                .setContentText("My First Notification")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());


    }

    private void userLogin() {

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(btnlogin.getWindowToken(), 0);

        String email = useremail.getText().toString().trim();
        final String password = userpassword.getText().toString().trim();


        if (!useremail.getText().toString().matches(emailPattern)) {
            Snackbar.make(layoutLinear, "Enter a Valid Email", Snackbar.LENGTH_LONG).show();
            return;
        }

        if (userpassword.getText().toString().equals("")) {
            Snackbar.make(layoutLinear, "Enter password", Snackbar.LENGTH_LONG).show();
            return;
        }

        if ((userpassword.getText().toString().length() < 8 || (userpassword.getText().toString().length() > 16))) {
            Snackbar.make(layoutLinear, "Password must be greater than 8 and less than 16", Snackbar.LENGTH_LONG).show();
            return;
        }

        if (haveNetworkConnection()) {

        } else {
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }


        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(email, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (loginResponse.getSuccess() == 1) {
                    displayNotification();
                    Toast.makeText(getApplicationContext(), loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    Snackbar.make(layoutLinear, loginResponse.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                userLogin();
                break;
        }
    }
}
