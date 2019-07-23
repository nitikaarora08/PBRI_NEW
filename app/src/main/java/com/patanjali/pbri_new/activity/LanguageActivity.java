package com.patanjali.pbri_new.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;

import java.util.Locale;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.BROADCAST_SMS;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class LanguageActivity extends AppCompatActivity {
Button btnEng,btnHindi,btnNext;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{RECEIVE_SMS,SEND_SMS,BROADCAST_SMS,CAMERA,ACCESS_COARSE_LOCATION,
                WRITE_EXTERNAL_STORAGE,CALL_PHONE,READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        btnEng=findViewById(R.id.btnEng);
        btnHindi=findViewById(R.id.btnHindi);
        btnNext=findViewById(R.id.btnNext);
        requestPermission();
        btnEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPrefrenceUtil(LanguageActivity.this).setLang("English");
                new SharedPrefrenceUtil(LanguageActivity.this).setLangApi("English");
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                btnEng.setBackgroundResource(R.drawable.checked_lang);
                btnHindi.setBackgroundResource(R.drawable.unchecked_lang);
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
//                Toast.makeText(LanguageActivity.this, getResources().getString(R.string.farmername), Toast.LENGTH_SHORT).show();
            }
        });
        btnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPrefrenceUtil(LanguageActivity.this).setLang("हिंदी");
                new SharedPrefrenceUtil(LanguageActivity.this).setLangApi("हिंदी");
                Locale locale = new Locale("hi");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                btnEng.setBackgroundResource(R.drawable.unchecked_lang);
                btnHindi.setBackgroundResource(R.drawable.checked_lang);
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
//                Toast.makeText(LanguageActivity.this, getResources().getString(R.string.farmername), Toast.LENGTH_SHORT).show();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LanguageActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            }
        });

    }







    
}
