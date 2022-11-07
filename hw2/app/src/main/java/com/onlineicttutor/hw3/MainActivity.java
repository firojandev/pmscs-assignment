package com.onlineicttutor.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] divisions = {"Dhaka", "Rajshahi", "Khulna", "Sylhet", "Rangpur", "Barishal", "Chattrogram", "Mymensingh"};
    String[] districts = {
            " Dhaka \n Faridpur \n Gazipur \n Gopalganj \n Kishoreganj \n Madaripur \n Manikganj \n Narayanganj \n Narsingdi \n Rajbari \n Shariatpur \n Tangail",
            " Natore \n Rajshahi \n Sirajganj \n Pabna, \n Bogura \n Chapainawabganj \n Naogaon \n Joypurhat",
            " Khulna \n Bagherhat \n Sathkhira \n Jessore \n Magura \n Jhenaidah \n Narail \n Kushtia \n Chuadanga \n Meherpur",
            " Habiganj \n Moulvibazar \n Sunamganj \n Sylhet",
            " Dinajpur \n Kurigram \n Gaibandha \n Lalmonirhat \n Nilphamari \n Panchagarh \n Rangpur \n Thakurgaon",
            " Barisal \n Barguna \n Bhola \n Jhalokati \n Pirojpur \n Patuakhali",
            " Brahmanbaria \n Comilla \n Chandpur \n Lakshmipur v Noakhali \n Feni \n Khagrachhari  \n Rangamati \n Bandarban \n Chattogram \n Cox's Bazar",
            " Mymensingh \n Kishoreganj \n Netrakona \n Jamalpur \n Tangail \n Sherpur"
    };

    AppCompatSpinner spinner;
    MaterialButton btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setSpinner();

        handleClickEvent();

    }

    public void initView() {
        spinner = findViewById(R.id.spMainArray);
        btnView = findViewById(R.id.btnView);
    }

    public void setSpinner() {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, divisions);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void handleClickEvent() {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = spinner.getSelectedItemPosition();
                //tvResults.setText(districts[position]);
                Intent myIntent = new Intent(MainActivity.this, ViewActivity.class);
                myIntent.putExtra("districts", districts[position]);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}