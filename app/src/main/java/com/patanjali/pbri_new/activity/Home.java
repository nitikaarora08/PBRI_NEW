package com.patanjali.pbri_new.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.fragments.CropDiseasesFragment;
import com.patanjali.pbri_new.fragments.CropPestFragment;
import com.patanjali.pbri_new.fragments.MainCrops;
import com.patanjali.pbri_new.fragments.OthersFragment;
import com.patanjali.pbri_new.fragments.SubCropsFragment;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.LanguageResponse;
import com.patanjali.pbri_new.model1.LabListGetResponse;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.fragments.AboutFarmer;
import com.patanjali.pbri_new.fragments.CostBenefits;
import com.patanjali.pbri_new.fragments.CropInfoFragment;
import com.patanjali.pbri_new.fragments.CropsList;
import com.patanjali.pbri_new.fragments.FarmDetailsFragment;
import com.patanjali.pbri_new.fragments.FarmLabFragment;
import com.patanjali.pbri_new.fragments.FarmLabHome;
import com.patanjali.pbri_new.fragments.Gallery;
import com.patanjali.pbri_new.fragments.Help;
import com.patanjali.pbri_new.fragments.HomeFragment;
import com.patanjali.pbri_new.fragments.ProfileDetails;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.fragments.FarmLabHome.lab_type;
import static com.patanjali.pbri_new.fragments.FarmLabHome.lab_type_pbri;

public class Home extends AppCompatActivity implements View.OnClickListener , FarmLabFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener,CostBenefits.OnFragmentInteractionListener,CropsList.OnFragmentInteractionListener,
        FarmDetailsFragment.OnFragmentInteractionListener, Help.OnFragmentInteractionListener, CropInfoFragment.OnFragmentInteractionListener,
 FarmLabHome.OnFragmentInteractionListener , AboutFarmer.OnFragmentInteractionListener, Gallery.OnFragmentInteractionListener,
        ProfileDetails.OnFragmentInteractionListener , MainCrops.OnFragmentInteractionListener
, OthersFragment.OnFragmentInteractionListener,
        SubCropsFragment.OnFragmentInteractionListener, CropDiseasesFragment.OnFragmentInteractionListener ,
        CropPestFragment.OnFragmentInteractionListener  {
    LinearLayout btnHelp, btnHome, btnAnalysis, btnFarmLab, btnCostBenefits, btnFarmDetails;
    Activity activity;
    Button btnHindi, btnEnglish, btnLanguage;
    RelativeLayout rel_layout_Lang;
    Context context;
    SharedPrefrenceUtil sharedPrefrenceUtil;
    Toolbar toolbar;
    Button btnSetting;
    DrawerLayout drawer;
    Spinner SpinnerSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = Home.this;

        sharedPrefrenceUtil = new SharedPrefrenceUtil(Home.this);
        rel_layout_Lang = findViewById(R.id.rel_layout_Lang);
        btnLanguage = findViewById(R.id.btnLanguage);
        btnHindi = findViewById(R.id.btnHindi);
        btnEnglish = findViewById(R.id.btnEnglish);
        SpinnerSetting = findViewById(R.id.SpinnerSetting);
        btnSetting = findViewById(R.id.btnSetting);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpinnerSetting.performClick();
            }
        });

        rel_layout_Lang.setVisibility(View.GONE);

        ArrayAdapter mAdapter = new ArrayAdapter<String>(context,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.setting)){
            public View getView(int position, View convertView, ViewGroup parent) {
                // Cast the spinner collapsed item (non-popup item) as a text view
                TextView tv = (TextView) super.getView(position, convertView, parent);

                // Set the text color of spinner item
                tv.setTextColor(Color.GRAY);

                // Return the view
                return tv;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                // Cast the drop down items (popup items) as text view
                TextView tv = (TextView) super.getDropDownView(position,convertView,parent);

                // Set the text color of drop down items
                tv.setTextColor(Color.BLACK);

                // If this item is selected item
                if(position == 0){
                    // Set spinner selected popup item's text color
                    tv.setTextColor(Color.GRAY);
                }

                // Return the modified view
                return tv;
            }
        };

        //Setting the ArrayAdapter data on the Spinner
        SpinnerSetting.setAdapter(mAdapter);


        SpinnerSetting.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {

             String  selecteditem = getResources().getStringArray(R.array.setting)[po];
//                Toast.makeText(context,selecteditem,Toast.LENGTH_SHORT).show();
                if (selecteditem.equalsIgnoreCase("language")
                || selecteditem.equalsIgnoreCase("भाषा")){
                    rel_layout_Lang.setVisibility(View.VISIBLE);
                }else if (selecteditem.equalsIgnoreCase("Logout") ||
                        selecteditem.equalsIgnoreCase("लोग आउट")){
                    SharedPreferences preferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
                    Config.Intent(context,LanguageActivity.class);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        btnHelp = findViewById(R.id.btnHelp);
        btnHome = findViewById(R.id.btnHome);
//        btnAnalysis = findViewById(R.id.btnAnalysis);
        btnFarmDetails = findViewById(R.id.btnFarmDetails);
        btnFarmLab = findViewById(R.id.btnFarmLab);
        btnCostBenefits = findViewById(R.id.btnCostBenefits);
        btnHome.setOnClickListener(this);
        btnFarmLab.setOnClickListener(this);
        btnFarmDetails.setOnClickListener(this);
        btnCostBenefits.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
//        btnLanguage.setText(sharedPrefrenceUtil.getLang());



        String lang= new SharedPrefrenceUtil(Home.this).getLang();
        if (lang.equalsIgnoreCase("हिंदी")||lang.equalsIgnoreCase("hi")||lang.equalsIgnoreCase("hindi"))    {
            Locale  locale = new Locale("hi", "IN");
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = locale;
            res.updateConfiguration(conf, dm);

        }


//        btnLanguage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rel_layout_Lang.setVisibility(View.VISIBLE);
//            }
//        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SharedPrefrenceUtil(Home.this).setLang("English");
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(Home.this, getResources().getString(R.string.farmername), Toast.LENGTH_SHORT).show();
                rel_layout_Lang.setVisibility(View.GONE);
                new SharedPrefrenceUtil(Home.this).setLang("English");
                new SharedPrefrenceUtil(Home.this).setLangApi("English");

                postEnglishLanguage();

                btnLanguage.setText(R.string.english);
                Intent intent = new Intent(Home.this,Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();


                //                changeLocale(Home.this,"en");
            }
        });

        btnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharedPrefrenceUtil(Home.this).setLang("हिंदी");
                Locale  locale = new Locale("hi", "IN");
                Resources res = getResources();
                DisplayMetrics dm = res.getDisplayMetrics();
                Configuration conf = res.getConfiguration();
                conf.locale = locale;
                res.updateConfiguration(conf, dm);
                new SharedPrefrenceUtil(Home.this).setLang("हिंदी");
                new SharedPrefrenceUtil(Home.this).setLangApi("हिंदी");

                postHindiLanguage();


                Toast.makeText(Home.this, getResources().getString(R.string.farmername), Toast.LENGTH_SHORT).show();
                rel_layout_Lang.setVisibility(View.GONE);
                btnLanguage.setText(R.string.hindi);
//                changeLocale(Home.this, "hi");
                Intent intent = new Intent(Home.this,Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                        Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_NO_ANIMATION
                );
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                finish();
            }
        });

//        postFarmLabDataServer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnHome:
//                Config.CallFragment(context, new HomeFragment());
                Config.Intent(context,FarmerProfile.class);
                break;
            case R.id.btnFarmDetails:
                Config.CallFragment(context, new FarmDetailsFragment());
                break;
                case R.id.btnFarmLab:
//                    if (sharedPrefrenceUtil.getTotalFarmlabs()>0) {
                        Config.CallFragment1(context, new FarmLabHome());
//                    }else{
//                        Config.CallFragment(context, new FarmLabFragment());
//                    }

                break;
      case R.id.btnCostBenefits:
                Config.CallFragment(context, new CostBenefits());
                break;
   case R.id.btnHelp:
                Config.CallFragment(context, new Help());
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.container);
        Fragment f1 = getSupportFragmentManager().findFragmentById(R.id.container1);
        Fragment f2 = getSupportFragmentManager().findFragmentById(R.id.container2);
        Fragment f3 = getSupportFragmentManager().findFragmentById(R.id.container3);
        Fragment f4 = getSupportFragmentManager().findFragmentById(R.id.container4);
        Fragment f5 = getSupportFragmentManager().findFragmentById(R.id.container5);

         if (f instanceof Help) {
            getSupportFragmentManager().beginTransaction().remove(f).commit();
        }
else if (f4 instanceof MainCrops) {

            if (f5 instanceof SubCropsFragment) {
                if (SubCropsFragment.frame_layout_others.getVisibility()==View.VISIBLE)
                    SubCropsFragment.frame_layout_others.setVisibility(View.GONE);
                else
                    getSupportFragmentManager().beginTransaction().remove(f5).commit();
            }
            else
            getSupportFragmentManager().beginTransaction().remove(f4).commit();
        }
        else if (f4 instanceof CropDiseasesFragment) {
            if (CropDiseasesFragment.frame_layout_others.getVisibility()==View.VISIBLE)
                CropDiseasesFragment.frame_layout_others.setVisibility(View.GONE);
            else
            getSupportFragmentManager().beginTransaction().remove(f4).commit();
        }
        else if (f4 instanceof CropPestFragment) {
            if (CropPestFragment.frame_layout_others.getVisibility()==View.VISIBLE)
                CropPestFragment.frame_layout_others.setVisibility(View.GONE);
            else
            getSupportFragmentManager().beginTransaction().remove(f4).commit();
        }else if (f2 instanceof CropInfoFragment) {
            if (CropInfoFragment.frame_layout_others.getVisibility()==View.VISIBLE)
                CropInfoFragment.frame_layout_others.setVisibility(View.GONE);
            else
            getSupportFragmentManager().beginTransaction().remove(f2).commit();
        }else  if (f3 instanceof CropsList) {
            getSupportFragmentManager().beginTransaction().remove(f3).commit();
        }

        else if (f instanceof HomeFragment) {
            getSupportFragmentManager().beginTransaction().remove(f).commit();
        } else if (rel_layout_Lang.getVisibility() == View.VISIBLE) {
            rel_layout_Lang.setVisibility(View.GONE);
        }

        else if (f instanceof FarmDetailsFragment) {

            if (FarmDetailsFragment.agriculture1.getVisibility()==View.VISIBLE)
                FarmDetailsFragment.agriculture1.setVisibility(View.GONE);

            else if (FarmDetailsFragment.livestock1.getVisibility()==View.VISIBLE)
                FarmDetailsFragment.livestock1.setVisibility(View.GONE);
            else if (FarmDetailsFragment.aquaculture1.getVisibility()==View.VISIBLE)
                FarmDetailsFragment.aquaculture1.setVisibility(View.GONE);
            else if (FarmDetailsFragment.farm_income1.getVisibility()==View.VISIBLE)
                FarmDetailsFragment.farm_income1.setVisibility(View.GONE);
            else
            getSupportFragmentManager().beginTransaction().remove(f).commit();

        }


else if (f instanceof FarmLabFragment) {
             if (f4 instanceof CostBenefits) {
                 if (CostBenefits.income1.getVisibility()==View.VISIBLE)
                     CostBenefits.income1.setVisibility(View.GONE);
                 else if (CostBenefits.expenses1.getVisibility()==View.VISIBLE)
                     CostBenefits.expenses1.setVisibility(View.GONE);
                 else
                     getSupportFragmentManager().beginTransaction().remove(f4).commit();
             }

else if (FarmLabFragment.rel_layout_Lang.getVisibility()==View.VISIBLE){
        FarmLabFragment.rel_layout_Lang.setVisibility(View.GONE);
    } else if  (FarmLabFragment.rel_layout_Lang.getVisibility()==View.VISIBLE){
                FarmLabFragment.rel_layout_Lang.setVisibility(View.GONE);
            }else if (FarmLabFragment.location1.getVisibility()==View.VISIBLE){
        FarmLabFragment.location1.setVisibility(View.GONE);
    }else if (FarmLabFragment.frame_layout_others.getVisibility()==View.VISIBLE){
                FarmLabFragment.frame_layout_others.setVisibility(View.GONE);
            }else if (FarmLabFragment.soiltest1.getVisibility()==View.VISIBLE){
        FarmLabFragment.soiltest1.setVisibility(View.GONE);
    }else if (FarmLabFragment.RLaddBook.getVisibility()==View.VISIBLE){
        FarmLabFragment.RLaddBook.setVisibility(View.GONE);
    }else if (FarmLabFragment.farm_lab_book1.getVisibility()==View.VISIBLE){
        FarmLabFragment.farm_lab_book1.setVisibility(View.GONE);
    }

            else
            getSupportFragmentManager().beginTransaction().remove(f).commit();
        }

        else if (f1 instanceof FarmLabHome) {
            getSupportFragmentManager().beginTransaction().remove(f1).commit();
        }


        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.drawable.warning);
            builder.setMessage("Do you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            finish();

                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();

        }

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // refresh your views here
        super.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


//    public void postFarmLabDataServer() {
//
//
//        String id= sharedPrefrenceUtil.getResponseId();
//              ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//         SoilRequest cropinformation = new SoilRequest(id);
//
//        Call<LabListGetResponse> call = mapiClinet.getLabList(cropinformation);
//        call.enqueue(new Callback<LabListGetResponse>() {
//
//            @Override
//            public void onResponse(Call<LabListGetResponse> call, Response<LabListGetResponse> response) {
//                if (response.body() != null) {
//                    Boolean errCode = response.body().getStatus();
//
//                    if (errCode.equals(true)) {
//                        LabListGetResponse labListResponse=response.body();
//                        String s=labListResponse.getMessage();
//                        List<com.patanjali.pbri_new.model1.List> labList=new ArrayList<>();
//                                labList=labListResponse.getList();
//                        int labSize=labList.size();
//                        sharedPrefrenceUtil.setTotalFarmlabs(labSize);
//                        Config.toast(Home.this,"labsize "+labSize);
//
//
//
////                        Toast.makeText(getApplicationContext(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
//
//                        //list.setAdapter(customAdatorr
//                        // Toast.makeText(
//                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
////                        Log.e("response", "" + response.body());
//
//                    } else {
//
////                        Toast.makeText(getApplicationContext(),  "No Data Found", Toast.LENGTH_LONG).show();
//                    }
//
//                } else {
////                    Toast.makeText(getApplicationContext(),  "No Data Found", Toast.LENGTH_LONG).show();
//                }
//                //  showTaost(msg);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<LabListGetResponse> call, Throwable t) {
//                //  progressDoalog.dismiss();
//
//                Toast.makeText(Home.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//


    private void postEnglishLanguage() {

        String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest(id,"eng");
        Call<LanguageResponse> call = mapiClinet.dolanguage(machineryrequest);
        call.enqueue(new Callback<LanguageResponse>() {

            @Override
            public void onResponse(Call<LanguageResponse> call, Response<LanguageResponse> response) {


                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();


                    if (errCode.equals(true)) {

                        Toast.makeText(Home.this, "You have Choosen English Language.Please Wait..........", Toast.LENGTH_LONG).show();
                        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(Home.this);
                        sharedPrefrenceUtil.setEnglishLanguageLoginStatus(true);


                    } else {
                    }

                } else {
                    Toast.makeText(Home.this,  "No Data Found", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<LanguageResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                Toast.makeText(Home.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void postHindiLanguage() {

        String id= sharedPrefrenceUtil.getResponseId();

        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();

        LanguageRequest machineryrequest = new LanguageRequest(id,"hindi");

        Call<LanguageResponse> call = mapiClinet.dolanguage(machineryrequest);

        call.enqueue(new Callback<LanguageResponse>() {

            @Override
            public void onResponse(Call<LanguageResponse> call, Response<LanguageResponse> response) {

                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        Toast.makeText(Home.this, "You have Choosen Hindi Language.Please Wait..........", Toast.LENGTH_LONG).show();
                        // hideLoading();

                        SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(Home.this);
                        sharedPrefrenceUtil.setHindiLanguageLoginStatus(true);

                    }

                    else

                    {

                    }

                } else {
//                    Toast.makeText(LoginActivity.this, "Something Went Wrong!....Please Try Later", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<LanguageResponse> call, Throwable t) {
                //  progressDoalog.dismiss();

                Toast.makeText(Home.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                rel_layout_Lang.setVisibility(View.VISIBLE);
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.activity_main_drawer, menu);
//        return true;
//    }
}
