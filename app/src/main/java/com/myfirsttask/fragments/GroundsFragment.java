package com.myfirsttask.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myfirsttask.Activities.DashboardActivity;
import com.myfirsttask.Activities.MainActivity;
import com.myfirsttask.Model.GroundResponse;
import com.myfirsttask.Model.LoginResponse;
import com.myfirsttask.R;
import com.myfirsttask.SharePref.Utils;
import com.myfirsttask.UserApi.RetrofitClient;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;


public class GroundsFragment extends Fragment {


    public GroundsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grounds, container, false);
        ButterKnife.bind(GroundsFragment.this, view);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    Call<GroundResponse> call = RetrofitClient
            .getInstance().getApi().ground();

            call.enqueue(new Callback<GroundResponse>() {
        @Override
        public void onResponse(Call<GroundResponse> call, Response<GroundResponse> response) {
            GroundResponse loginResponse = response.body();

            if (loginResponse.getSuccess() == 1) {


            } else {
                Snackbar.make(layoutLinear, loginResponse.getMessage(), Snackbar.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {

        }
    });



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
