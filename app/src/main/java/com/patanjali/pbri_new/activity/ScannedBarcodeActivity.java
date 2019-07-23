package com.patanjali.pbri_new.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.fragments.HomeFragment;
import com.patanjali.pbri_new.model.DistrictList;
import com.patanjali.pbri_new.model.StateList;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ScannedBarcodeActivity extends AppCompatActivity {


    SurfaceView surfaceView;
    TextView txtBarcodeValue;
    private BarcodeDetector barcodeDetector;
    private CameraSource cameraSource;
    private static final int REQUEST_CAMERA_PERMISSION = 201;
    Button btnAction;
    String intentData = "";
    boolean isEmail = false;
    ImageView imgScan;
    EditText etEnterPin;
    String token, result, line;
    InputStream inpts;
    int responseCodeChangePin;
    Context context;
    String city="" ,fathername="", village="",po="",dist="",state="",pin="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_barcode);
        context = ScannedBarcodeActivity.this;


        txtBarcodeValue = findViewById(R.id.txtBarcodeValue);
        surfaceView = findViewById(R.id.surfaceView);
        //  btnAction = findViewById(R.id.btnAction);
        etEnterPin = findViewById(R.id.etEnterPin);


        initialiseDetectorsAndSources();

    }


    private void initialiseDetectorsAndSources() {

        Toast.makeText(getApplicationContext(), "Barcode scanner started", Toast.LENGTH_SHORT).show();

        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1920, 1080)
                .setAutoFocusEnabled(true) //you should add this feature
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(ScannedBarcodeActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                        cameraSource.start(surfaceView.getHolder());
                    } else {
                        ActivityCompat.requestPermissions(ScannedBarcodeActivity.this, new
                                String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
                Toast.makeText(getApplicationContext(), "To prevent memory leaks barcode scanner has been stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                if (barcodes.size() != 0) {


                    txtBarcodeValue.post(new Runnable() {

                        @Override
                        public void run() {

                            isEmail = false;
                            intentData = barcodes.valueAt(0).displayValue;

                            String sStringToParse;
                            try {
// put your XML value into the sStringToParse variable
                            sStringToParse = new String(intentData);

                            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                            dbf.setValidating(false);
                            DocumentBuilder db = null;

                                db = dbf.newDocumentBuilder();

                            Document doc = db.parse(new ByteArrayInputStream(sStringToParse.getBytes("utf-8")));
                            NodeList nlRecords = doc.getElementsByTagName("PrintLetterBarcodeData");

                            int num = nlRecords.getLength();

                            for (int i = 0; i < num; i++) {
                                Element node = (Element) nlRecords.item(i);

                                System.out.println("ListFarmBook attributes for node: " + node.getNodeName());

                                // get a map containing the attributes of this node
                                NamedNodeMap attributes = node.getAttributes();

                                // get the number of nodes in this map
                                int numAttrs = attributes.getLength();

                                SharedPrefrenceUtil sharedPrefrenceUtil= new SharedPrefrenceUtil(getApplicationContext());
                                for (int j = 0; j < numAttrs; j++) {
                                    Attr attr = (Attr) attributes.item(j);

                                    String attrName = attr.getNodeName();
                                    String attrValue = attr.getNodeValue();

                                    if (attrName.equalsIgnoreCase("uid")){
                                        HomeFragment.adhar_number.setText(attrValue);
                                        sharedPrefrenceUtil.setAdharNumber(attrValue);
                                    }

       if (attrName.equalsIgnoreCase("name")){
                                        HomeFragment.farmername.setText(attrValue);
           sharedPrefrenceUtil.setName(attrValue);
       }

       if (attrName.equalsIgnoreCase("dob")){

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String currentDateandTime = sdf.format(new Date(attrValue));

           HomeFragment.farmer_dob.setText(currentDateandTime);
           sharedPrefrenceUtil.setDob(currentDateandTime);
       }

       if (attrName.equalsIgnoreCase("pc")){
                                        HomeFragment.farmer_pincode.setText(attrValue);
           sharedPrefrenceUtil.setPinCode(attrValue);
       }

 if (attrName.equalsIgnoreCase("yob")){
     int age= Integer.parseInt(Config.getAge(Integer.parseInt(attrValue),1,1));
           sharedPrefrenceUtil.setFramerAge(age+"");
           HomeFragment.farmer_age.setText(age+" ");
       }


       if (attrName.equalsIgnoreCase("loc")){
            city=attrValue;
            HomeFragment.farmer_landmark.setText(city);
           sharedPrefrenceUtil.setLandMarkMark(city);

       }
if (attrName.equalsIgnoreCase("vtc")){
            village=attrValue;
    HomeFragment.farmer_village.setText(village);
    sharedPrefrenceUtil.setVilalgeName(village);

}

if (attrName.equalsIgnoreCase("po")){
            po=attrValue;
    HomeFragment.farmer_mandal.setText(attrValue);
    sharedPrefrenceUtil.setMandalName(attrValue);

}

if (attrName.equalsIgnoreCase("state")){
    state=attrValue;
    sharedPrefrenceUtil.setstateselectedIten(state);
    sharedPrefrenceUtil.setstateitem(state);

  try{
      for (int k = 0; k < HomeFragment.statelist.size(); k++) {

          StateList data = HomeFragment.statelist.get(k);

          if (state.equalsIgnoreCase(data.getStateName())) {
              HomeFragment.spinner_state.setSelection(k);
              break;
          }
      }

  }catch (Exception e){}

}

  if (attrName.equalsIgnoreCase("dist")) {

      dist = attrValue;
      sharedPrefrenceUtil.setcityitem(dist);

      try {


          for (int l = 0; l < HomeFragment.citylist.size(); l++) {

              DistrictList data = HomeFragment.citylist.get(l);

              if (dist.equalsIgnoreCase(data.getDistrictName())) {
                  HomeFragment.spinner_city.setSelection(l);
                  break;
              }
          }



      }catch (Exception e){}
                                    }


if (attrName.equalsIgnoreCase("pc")){
    pin=attrValue;
    sharedPrefrenceUtil.setPinCode(pin);
}
if (attrName.equalsIgnoreCase("co")){
    fathername=attrValue;
}

//String address=fathername+","+village+","+city+"\n City: "+po+"\n District: "+dist+"\n State : "+state;
String address=fathername+" , "+village+" City: "+city;
                                        HomeFragment.farmer_address.setText(address);
                                    sharedPrefrenceUtil.setFramerAddress(address);

//                                    if (sharedPrefrenceUtil.getEnglishLanguageLoginStatus()&&sharedPrefrenceUtil.getLoginStatus())
//                                    {
                                        if (attrName.equalsIgnoreCase("gender"))
                                        {
                                            if (attrValue.contains("F")){
                                                HomeFragment.spinner_gender.setSelection(2);
                                                sharedPrefrenceUtil.setGenderItemSelected("F");

                                            }else if (attrValue.contains("M")){
                                                HomeFragment.spinner_gender.setSelection(1);
                                                sharedPrefrenceUtil.setGenderItemSelected("M");

                                            }

                                        }
//                                    }

//  if (sharedPrefrenceUtil.getHindiLanguageLoginStatus()&&sharedPrefrenceUtil.getLoginStatus())
//                                    {
//                                        if (attrName.equalsIgnoreCase("gender"))
//                                        {
//                                            if (attrValue.equalsIgnoreCase("F")){
//                                                HomeFragment.spinner_gender.setSelection(1);
//
//                                            }else if (attrValue.equalsIgnoreCase("M")){
//                                                HomeFragment.spinner_gender.setSelection(0);
//
//                                            }
//                                        }
//                                        sharedPrefrenceUtil.setGenderItemSelected(attrValue);
//                                    }






//       <?xml version="1.0" encoding="UTF-8"?>
//<PrintLetterBarcodeData uid="380723721252" name="Pramila" gender="F" yob="1995" co="D/O Prahlad Singh" loc="Guptakashi" vtc="Rudrpur"
//                                po="Guptkashi" dist="Rudraprayag" state="Uttarakhand" pc="246439"
//                                dob="10/02/1995"/>                             // Do your stuff here
                                    System.out.println("Found attribute: " + attrName + " with value: " + attrValue);

                                }

                            }


                                HomeFragment.rel_layout_details2.setVisibility(View.VISIBLE);
                                HomeFragment.click1=false;
//                                txtBarcodeValue.setText(intentData);
                            Log.e("intentData ",intentData);
                            finish();
                            } catch (ParserConfigurationException e) {
                                e.printStackTrace();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (SAXException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }
        });
    }




}