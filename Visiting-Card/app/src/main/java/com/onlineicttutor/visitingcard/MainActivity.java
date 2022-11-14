package com.onlineicttutor.visitingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llPhone,llEmail, llAddress;
    private RelativeLayout rlMyProfile;
    private TextView tvWebsiteURL;
    private ImageView silLogo,imgSquareLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        init();
        clickListener();
    }

    public void init(){
        llPhone = findViewById(R.id.llPhone);
        llEmail = findViewById(R.id.llEmail);
        llAddress = findViewById(R.id.llAddress);
        tvWebsiteURL = findViewById(R.id.tvWebsiteURL);
        silLogo = findViewById(R.id.silLogo);
        imgSquareLogo = findViewById(R.id.imgSquareLogo);
        rlMyProfile = findViewById(R.id.rlMyProfile);
    }

    public void clickListener(){
        llPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:"+Uri.encode("01738244446")));
                dialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialIntent);
            }
        });
        llEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "altaf@squaregroup.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Visiting Card");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"");
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Choose"));
            }
        });
        llAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(mapIntent);
            }
        });
        silLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWebsite("https://www.e-home2u.com");
            }
        });

        tvWebsiteURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWebsite("https://squaregroup.com");
            }
        });
        imgSquareLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWebsite("https://squaregroup.com");
            }
        });

        rlMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWebsite("https://m.facebook.com/eva.firoj");
            }
        });
    }

    public void goToWebsite(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}