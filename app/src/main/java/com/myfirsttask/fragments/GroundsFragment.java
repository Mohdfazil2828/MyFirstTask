package com.myfirsttask.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.myfirsttask.Model.Record;
import com.myfirsttask.R;
import com.myfirsttask.SharePref.Utils;
import com.myfirsttask.UserApi.RetrofitClient;
import com.myfirsttask.adapter.GroundRecyeclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GroundsFragment extends Fragment {

    @BindView(R.id.recyeclerview)
    RecyclerView recyclerView;


    private GroundRecyeclerAdapter mAdapter;
    private ArrayList<GroundResponse> groundResponses = new ArrayList<GroundResponse>();
    private ArrayList<Record> records = new ArrayList<Record>();


    public GroundsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grounds, container, false);
        ButterKnife.bind(GroundsFragment.this, view);

        setUpRecyclerView();
        addValuesArrayList();

        getGroundList();

        return view;
    }

    private void getGroundList() {

        Call<GroundResponse> call = RetrofitClient
                .getInstance().getApi().ground();

        call.enqueue(new Callback<GroundResponse>() {
            @Override
            public void onResponse(Call<GroundResponse> call, Response<GroundResponse> response) {
                GroundResponse groundResponse = response.body();

                if (groundResponse.getSuccess() == 1) {


                } else {
                }
            }

            @Override
            public void onFailure(Call<GroundResponse> call, Throwable t) {

            }
        });
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

    private void addValuesArrayList() {
        mAdapter.updateData(groundResponses);
    }

    private void setUpRecyclerView() {
        mAdapter = new GroundRecyeclerAdapter(GroundsFragment.this, groundResponses);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
