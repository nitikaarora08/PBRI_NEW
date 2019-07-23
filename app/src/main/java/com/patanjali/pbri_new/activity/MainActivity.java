package com.patanjali.pbri_new.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;

import java.util.Locale;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(MainActivity.this);
      final  boolean status=sharedPrefrenceUtil.getLoginStatus();
      final  String status1=sharedPrefrenceUtil.getLogin();

        String lang= new SharedPrefrenceUtil(MainActivity.this).getLang();
//        if (lang.equalsIgnoreCase("english")) {
//            Locale locale = new Locale("en");
//            Locale.setDefault(locale);
//            Configuration config = new Configuration();
//            config.locale = locale;
//            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
//
//        }else
        if (lang.equalsIgnoreCase("हिंदी")||lang.equalsIgnoreCase("hi")||lang.equalsIgnoreCase("hindi"))    {
//            Locale locale = new Locale("hi");
//            Locale.setDefault(locale);
//            Configuration config = new Configuration();
//            config.locale = locale;
//            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

//            setLocale("hi");
//            String language = "hi";
//            String country = "IN";
//            Locale locale = new Locale(language , country);
//            Locale.setDefault(locale); //            setLocale("hi");
          Locale  locale = new Locale("hi", "IN");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);

        }
//Config.toast(getApplicationContext(),sharedPrefrenceUtil.getLang());

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            Log.e("login status",status+"");
            if (status1.equalsIgnoreCase("true")) {
                Config.Intent(MainActivity.this,Home.class);
            }else {
                Config.Intent(MainActivity.this,LanguageActivity.class);
            }

            finish();

        }
    }, 3000);


}
    public static boolean Connetion(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        else
            return false;
    }


//    public void setLocale(String lang) {
//
//// Change locale settings in the app.
//        Resources res = this.getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            conf.setLocale(new Locale(lang));
//        }
//// API 17+ only.
//// Use conf.locale = new Locale(...) if targeting lower versions
//        res.updateConfiguration(conf, dm);
//
//    }
//

}
