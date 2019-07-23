package com.patanjali.pbri_new.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.PagerFragmentListener;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.fragments.AboutFarmer;
import com.patanjali.pbri_new.fragments.Gallery;
import com.patanjali.pbri_new.fragments.HomeFragment;
import com.patanjali.pbri_new.fragments.ProfileDetails;
import com.patanjali.pbri_new.model.ProfilePicResponse;
import com.patanjali.pbri_new.model.ResponseUpdateFarmBook;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FarmerProfile extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, AboutFarmer.OnFragmentInteractionListener,ProfileDetails.OnFragmentInteractionListener,
Gallery.OnFragmentInteractionListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static final int CAMERA_REQUEST = 1;

    public static final int PICK_IMAGE = 1;
    SharedPrefrenceUtil sharedPrefrenceUtil;
    public  static CircleImageView imgUpload;
    Button btnCall,btnMessage;
   public static RelativeLayout rl,gif;
   public static TextView txtName,txtCity;
   Context context;
    Bitmap bitmap;
    File mImageFile;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_profile);
        btnCall=findViewById(R.id.btnCall);
        btnMessage=findViewById(R.id.btnMessage);
        txtName=findViewById(R.id.txtName);
        txtCity=findViewById(R.id.txtCity);
        gif=findViewById(R.id.imgGif);
        context=FarmerProfile.this;
        imgUpload=findViewById(R.id.imgUpload);
        rl=findViewById(R.id.rl);
       progressDialog=new ProgressDialog(context);

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeFragment.farmer_mobileno.getText().toString().length() > 0) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:" + HomeFragment.farmer_mobileno.getText()));//change the number
                    startActivity(callIntent);
                }
            }
        });
 btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HomeFragment.farmer_emailid.getText().toString().length() > 0) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto",sharedPrefrenceUtil.getEmail(), null));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "hi");
                    intent.putExtra(Intent.EXTRA_TEXT, "hi");
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                }
            }
        });

        sharedPrefrenceUtil=new SharedPrefrenceUtil(FarmerProfile.this);

       try{
           if (sharedPrefrenceUtil.getProfilePic().exists()) {

               Bitmap myBitmap = BitmapFactory.decodeFile(sharedPrefrenceUtil.getProfilePic().getAbsolutePath());
               imgUpload.setImageBitmap(myBitmap);
           }else if (sharedPrefrenceUtil.getProfilepicName()!=null ||!sharedPrefrenceUtil.getProfilepicName().equals("")){
               Picasso.with(FarmerProfile.this)
                       .load(sharedPrefrenceUtil.getProfilepicName())
                       .into( imgUpload);
           }else{
               imgUpload.setImageResource(R.drawable.profile);
           }
       }
       catch (Exception e){}

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i==1) {
                    PagerFragmentListener fragmentListener=(PagerFragmentListener)mSectionsPagerAdapter.getItem(1);
                    try {
                        String email=sharedPrefrenceUtil.getemailAbout();
                        String address=sharedPrefrenceUtil.getAddressAbout();
                        String mob=sharedPrefrenceUtil.getMobileAbout();

//                        Log.e("email: "+email," address "+address+" mob "+mob);
                        if (sharedPrefrenceUtil.getemailAbout()!=null) {
                            fragmentListener.setEmail(sharedPrefrenceUtil.getemailAbout());
                            if (AboutFarmer.farmer_emailid!=null)
                                AboutFarmer.farmer_emailid.setText(email);
                        }
                          if (sharedPrefrenceUtil.getMobileAbout()!=null) {
                            fragmentListener.setPhone(sharedPrefrenceUtil.getMobileAbout());
                              if (AboutFarmer.farmer_mobileno!=null)
                                  AboutFarmer.farmer_mobileno.setText(mob);

                          }
                          if (sharedPrefrenceUtil.getAddressAbout()!=null) {
                            fragmentListener.setAddress(sharedPrefrenceUtil.getAddressAbout());
                              if (AboutFarmer.farmer_address!=null) {
                                  if (address.contains("null"))
                                  AboutFarmer.farmer_address.setText(address.replace("null","-"));
                              }
                          }

                    }
                    catch (Exception e){}

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_farmer_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_farmer_profile, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
//            return PlaceholderFragment.newInstance(position + 1);

            switch (position){
                case 0:
                    HomeFragment home = new HomeFragment();
                    return home;
                case 1:
                    AboutFarmer about = new AboutFarmer();
                    return about;
                case 2:
                    Gallery contact = new Gallery();
                    return contact;
                default:
                    AboutFarmer about1 = new AboutFarmer();
                    return about1;
            }

        }

        @Override
        public int getItemPosition(@NonNull Object object) {
                return POSITION_NONE;

//            return super.getItemPosition(object);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }


    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (getContentResolver() != null) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {


        if (requestCode == PICK_IMAGE) {

            try {
                Uri filePath = data.getData();
                  bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteFormat = stream.toByteArray();
                // get the base 64 string
              String  encodeToStringGallary = Base64.encodeToString(byteFormat, Base64.NO_WRAP);
                Uri tempUri = getImageUri(FarmerProfile.this, bitmap);

                // CALL THIS METHOD TO GET THE ACTUAL PATH
                mImageFile = new File(getRealPathFromURI(tempUri));
//                Log.e("path ",mImageFile.getAbsolutePath()+" file "+mImageFile +" uri "+tempUri);

//                sharedPrefrenceUtil.setProfilePic(mImageFile);
                UpdateProfilePic();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        }

//



    public  void UpdateProfilePic(){
//        gif.setVisibility(View.VISIBLE);
        progressDialog.show();
        try {
            RequestBody id1 = RequestBody.create(MediaType.parse("text/plain"), sharedPrefrenceUtil.getResponseId());
            RequestBody requestBodyProfile = RequestBody.create(MediaType.parse("multipart/form-data"),mImageFile);
            MultipartBody.Part profile_img = MultipartBody.Part.createFormData("profile_pic",
                    mImageFile.getName(), requestBodyProfile);
//            Toast.makeText(FarmerProfile.this, "id " + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID(), Toast.LENGTH_LONG).show();

//            Log.e("id ", "" + id +" and farmlab id : "+sharedPrefrenceUtil.getFarmLabID());
            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            mapiClinet.postProfilePic(id1,profile_img).enqueue(new Callback<ProfilePicResponse>() {
                @Override
                public void onResponse(Call<ProfilePicResponse> call, Response<ProfilePicResponse> response) {

//                    Log.e("response", "" + response.body());
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();
                        if (errCode.equals(true)) {
                            Toast.makeText(FarmerProfile.this, "Profile pic updated", Toast.LENGTH_LONG).show();
//                            Log.e("response", "" + response.body());
                            imgUpload.setImageBitmap(bitmap);
//                            sharedPrefrenceUtil.setProfilePic(mImageFile);
                            new AsyncTaskLoadImage( imgUpload).execute(response.body().getProfilePath());

                        }
                        else
                            progressDialog.dismiss();
                    }
                    else
                    progressDialog.dismiss();
//                    gif.setVisibility(View.GONE);

                }

                @Override
                public void onFailure(Call<ProfilePicResponse> call, Throwable t) {
//                    gif.setVisibility(View.GONE);
                    progressDialog.dismiss();
                    Toast.makeText(FarmerProfile.this, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                }
            });


        }catch (Exception e){ progressDialog.dismiss(); }
    }


    public class AsyncTaskLoadImage  extends AsyncTask<String, String, Bitmap> {
        private ImageView imageView;

        public AsyncTaskLoadImage(ImageView imageView) {
            this.imageView = imageView;
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL(params[0]);
                bitmap = BitmapFactory.decodeStream((InputStream)url.getContent());
                Uri tempUri = getImageUri(context, bitmap);
                sharedPrefrenceUtil.setProfilePic(new File(getRealPathFromURI(tempUri)));
            } catch (IOException e) {
                progressDialog.dismiss();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
//            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
//            gif.setVisibility(View.GONE);
        }
    }
    
}
