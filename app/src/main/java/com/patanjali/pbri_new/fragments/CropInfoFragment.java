package com.patanjali.pbri_new.fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.patanjali.pbri_new.Config;
import com.patanjali.pbri_new.Function;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.activity.MainActivity;
import com.patanjali.pbri_new.adapter.FertilizerListAdapter;
import com.patanjali.pbri_new.adapter.PestisidesListAdapter;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;
import com.patanjali.pbri_new.model.DataCollectionRequest;
import com.patanjali.pbri_new.model.DataCollectionResponse;
import com.patanjali.pbri_new.model.Datacollectionlist;
import com.patanjali.pbri_new.model.LanguageRequest;
import com.patanjali.pbri_new.model.MachinaryList;
import com.patanjali.pbri_new.model.MachineryResponse;
import com.patanjali.pbri_new.model.RequestDataCollection;
import com.patanjali.pbri_new.model.ResponseDataCollection;
import com.patanjali.pbri_new.model.SaveMachineData;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.model1.CropInfoRequest;
import com.patanjali.pbri_new.model1.CropInfoResponse;
import com.patanjali.pbri_new.model1.CropStatusList;
import com.patanjali.pbri_new.model1.CropStatusListResponse;
import com.patanjali.pbri_new.model1.CropsInfo_1Crop;
import com.patanjali.pbri_new.model1.FertilizerList;
import com.patanjali.pbri_new.model1.FertilizerResponse;
import com.patanjali.pbri_new.model1.GetCropInfoRequest;
import com.patanjali.pbri_new.model1.GetCropInfoResponse;
import com.patanjali.pbri_new.model1.OthersPestisidesRequest;
import com.patanjali.pbri_new.model1.PesticidesNameList;
import com.patanjali.pbri_new.model1.PestisidesListResponse;
import com.patanjali.pbri_new.model1.RecommendCropRequest;
import com.patanjali.pbri_new.model1.RecommendCropResponse;
import com.patanjali.pbri_new.model1.OthersFertilizerRequest;
import com.patanjali.pbri_new.model1.OthersFertilizerResponse;
import com.patanjali.pbri_new.model1.SoilRecommended;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;
import com.patanjali.pbri_new.service.SingletonClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patanjali.pbri_new.fragments.FarmLabHome.lab_type;
import static com.patanjali.pbri_new.fragments.FarmLabHome.lab_type_pbri;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CropInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CropInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CropInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CropInfoFragment() {
        // Required empty public constructor
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CropInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CropInfoFragment newInstance(String param1, String param2) {
        CropInfoFragment fragment = new CropInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    List<MachinaryList> messagess = new ArrayList<>();
    EditText plantheight,productive_tillers,panicle,fruitsplant,harvestingdate,grainweight
            ,grainyield,grainyieldplot,straw_yield, by_product,rainfall,et_annual_rainfall,
            et_min_temp,et_max_temp,et_Relative_Humidity, et_Sunshine_humidity;
    Spinner selectrainfall,selectgeneralinfo,selectcropcondition;
    String rainfallselecteditem, selectedcropitem, selectgeneralinfoitem;
    RelativeLayout cropInfo,farm_lab_book,data_collection,cropInfo1;
    LinearLayout farm_lab_book1,data_collection1;
    String[] rainfall_values = {"वर्षा का वितरण", "सामान्य", "असमान"};
    String[] generalobservation_values = {"सामान्य अवलोकन", "सामान्य", "भारी"};
    String[] cropcondition_values = {"फसल की स्थिति", "बहुत अच्छा", "अच्छा", "सामान्य", "खराब"};
    EditText  varietyname,etArea,land_preparation_date,
            dateofsowing,input_planting_date,firtdiseasedate,secondapplications,
            irrigation_type,weed_notice,first_weeddate,
            secondweeddate,firtdiseasedatePest,secondapplicationsPest;
   public static TextView txtCropStatus,spinnerName;
    public static String from="";
   Button btnAddEdit;
    Spinner   spinnerFertilizer;
   public static CheckBox cbFertilizer,diseaseobserverd,pest_observed,chk_virus,cbpestisides,chk_nemotodes;
    Double lat,lang;
    Button btnCancelCrop,btnSaveCrop,btnCropinfo,btnDataCollection;
    LinearLayout cropinfo2;
    LinearLayout llCropInfo,llDataColl;
    Button btnSaveDataCollection,btnCancelDataColl;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    SharedPrefrenceUtil sharedPrefrenceUtil;
    ImageView imgDatac,imgCrop;
    TextView txtDatac,txtCrop;
Spinner spinner_pestisides;
String id;
RecyclerView recyclerView;
View view;
    List<PesticidesNameList> pestisidesNameList;
    List<FertilizerList> fertilizerList ;
    public static ArrayList<String> diseaseArray = new ArrayList<>();
    public static ArrayList<String> pest = new ArrayList<>();
    public static ArrayList<String> fertilizerArray = new ArrayList<>();
    public static ArrayList<String> pestisides_array = new ArrayList<>();
    List<PesticidesNameList> statelist = new ArrayList<>();
    List<FertilizerList> fertilizerLists = new ArrayList<>();
    TextView txtRecommend_calculator,txtHeading;
    LinearLayout linearLayoutCalculator;
    String npk_value="";
    Typeface weatherFont;
    String city = "Noida, IN";
    /* Please Put your API KEY here */
    String OPEN_WEATHER_MAP_API = "dc2522c3426d32f53ae6e86ea87134d1";
    /* Please Put your API KEY here */
    ArrayList<EditText> etArray;
    LinearLayout llHeight;
    TextView txtGreenManu,txtBioF,txtProm,txtJivamrit,txtOilCake,txtFYM;
     EditText myEditText;
     EditText edHeight1,edHeight2,edHeight3,edHeight4,edHeight5;
    StringBuffer sb;


    Button btnAddYield;
    LinearLayout llYeild;
    EditText edYeild1,edYeild2,edYeild3,edYeild4,edYeild5;
    Button btnAddWeight;
    LinearLayout llWeight;
    EditText edWeight1,edWeight2,edWeight3,edWeight4,edWeight5;
    Button btnAddTiller;
    LinearLayout llTiller;
    EditText edTiller1,edTiller2,edTiller3,edTiller4,edTiller5;
    Button btnAddFruits;
    LinearLayout llFruits;
    EditText edFruits1,edFruits2,edFruits3,edFruits4,edFruits5;
    Button btnAddPanicle;
    LinearLayout llPanicle;
    TextView txtCityName,txtTitle;
    EditText edPanicle1,edPanicle2,edPanicle3,edPanicle4,edPanicle5;
    ArrayList<EditText> etArrayPanicle,etArrayYeild,etArrayTiller,etArrayWeight,etArrayFruits;
    java.util.List<CropStatusList> labList;
    Button btnMinusFruits,btnminusEdit,btnMinusPanicle,btnMinusTiller,btnMinusWeight,btnMinusYield;
    RelativeLayout rlWeather;
    LinearLayout llWeather1;
    Context context;
    public static RelativeLayout frame_layout_others;
    public static  AlertDialog alertDialog;
    EditText edOthers;
    Button btnSaveOthers;
    ImageView imgClose;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view=   inflater.inflate(R.layout.fragment_crop_info, container, false);
        sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
        id= sharedPrefrenceUtil.getResponseId();
        context=getActivity();


        btnSaveOthers=view.findViewById(R.id.btnSaveOthers);
        edOthers=view.findViewById(R.id.edOthers);
        frame_layout_others=view.findViewById(R.id.frame_layout_others);
        rlWeather=view.findViewById(R.id.rlWeather);
        llWeather1=view.findViewById(R.id.llWeather1);
        txtCityName=view.findViewById(R.id.txtCityName);
        linearLayoutCalculator=view.findViewById(R.id.linearLayoutCalculator);
        imgDatac=view.findViewById(R.id.imgDatac);
        imgCrop=view.findViewById(R.id.imgCrop);
        txtCrop=view.findViewById(R.id.txtCrop);
        txtDatac=view.findViewById(R.id.txtDatac);
        txtGreenManu=view.findViewById(R.id.txtGreenManu);
        txtBioF=view.findViewById(R.id.txtBioF);
        txtProm=view.findViewById(R.id.txtProm);
        txtJivamrit=view.findViewById(R.id.txtJivamrit);
        txtOilCake=view.findViewById(R.id.txtOilCake);
        txtFYM=view.findViewById(R.id.txtFYM);
        btnminusEdit=view.findViewById(R.id.btnminusEdit);
        btnMinusFruits=view.findViewById(R.id.btnMinusFruits);
        btnMinusPanicle=view.findViewById(R.id.btnMinusPanicle);
        btnMinusTiller=view.findViewById(R.id.btnMinusTiller);
        btnMinusWeight=view.findViewById(R.id.btnMinusWeight);
        btnMinusYield=view.findViewById(R.id.btnMinusYield);
        txtTitle=view.findViewById(R.id.txtTitle);
        imgClose=view.findViewById(R.id.imgClose);

        newDeclaration();


        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frame_layout_others.getVisibility()==View.VISIBLE) {
                    frame_layout_others.setVisibility(View.GONE);
                }
            }
        });

        btnSaveOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtTitle.getText().toString().contains("lizer")) {
                    if (edOthers.getText().toString().equals("")) {
                        Config.toast(context, "Please enter fertilizer name");
                    } else {
                        SaveOtherFertilizer();
                        frame_layout_others.setVisibility(View.GONE);
                    }

                }else{
                    if (edOthers.getText().toString().equals("")) {
                        Config.toast(context, "Please enter pesticide name");
                    } else {
                        SaveOtherPesticide();
                        frame_layout_others.setVisibility(View.GONE);
                    }
                }
            }
        });

        rlWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    llWeather1.setVisibility((llWeather1.getVisibility() == View.VISIBLE)
                            ? View.GONE : View.VISIBLE);


            }
        });



        txtRecommend_calculator=view.findViewById(R.id.txtRecommend_calculator);

               declaration_crop_info();
        declaration_Data_Collection();
        GetCropInfo();
        getSelectedSpinnerValue();
        getMachinary();
        getpestisides();
        getFertilizer();
        alertClickListner();
        getDataCollection();
        getMainCrop();

        try {

            txtCityName.setText(FarmLabFragment.name+","+FarmLabFragment.Country );
            et_min_temp.setText(FarmLabFragment.minTemp);
            et_max_temp.setText(FarmLabFragment.MaxTemp);
            et_Relative_Humidity.setText(FarmLabFragment.humidity);
//            et_Sunshine_humidity.setText(FarmLabFragment.humidity);


            String nit = sharedPrefrenceUtil.getNitrogen();
            String pot = sharedPrefrenceUtil.getPotassium();
            String phos = sharedPrefrenceUtil.getPhosphorous();

            String s1 = nit.substring(0, 1);
            String s2 = pot.substring(0, 1);
            String s3 = phos.substring(0, 1);

            if (s1.equals("क"))
                s1 = "L";
            if (s1.equals("म"))
                s1 = "M";
            if (s1.equals("उ"))
                s1 = "H";

            if (s2.equals("क"))
                s2 = "L";
            if (s2.equals("म"))
                s2 = "M";
            if (s2.equals("उ"))
                s2 = "H";

            if (s3.equals("क"))
                s3 = "L";
            if (s3.equals("म"))
                s3 = "M";
            if (s3.equals("उ"))
                s3 = "H";

            npk_value = s1 + s2 + s3;
//            if (context != null)
//                Config.toast(context.getApplicationContext(), npk_value);
            if (npk_value.equalsIgnoreCase("LLL") || npk_value.equalsIgnoreCase("LLM") ||
                    npk_value.equalsIgnoreCase("LMM") || npk_value.equalsIgnoreCase("LMH") ||
                    npk_value.equalsIgnoreCase("MLH") ||
                    npk_value.equalsIgnoreCase("MLM") || npk_value.equalsIgnoreCase("MLH") ||
                    npk_value.equalsIgnoreCase("MMH") || npk_value.equalsIgnoreCase("MMM")

            ) {
                postFarmLabDataServer();
            } else {
                linearLayoutCalculator.setVisibility(View.GONE);
            }
        }catch (Exception e){}




        btnSaveDataCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPrefrenceUtil.getCropInfoID() == 0) {
                    Config.toast(context, "Please Save Crop Info");
                }
                else {
                        updateDataCollection();
                }
            }
        });


        harvestingdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                if (context != null) {
                    DatePickerDialog picker = new DatePickerDialog(context,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    harvestingdate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                                }
                            }, year, month, day);
                    picker.show();
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void getTextWatcher(){


        plantheight.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setPlantHeight(plantheight.getText().toString());
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) { }

        });
        productive_tillers.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setNoProductivityTiller(productive_tillers.getText().toString());
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) { }

        });
        panicle.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setPanicleSize(panicle.getText().toString());
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });
        fruitsplant.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setNoOfFruit(fruitsplant.getText().toString());
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });
        harvestingdate.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setDateOfHarvesting(harvestingdate.getText().toString());
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });
        grainweight.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setgrainweight(grainweight.getText().toString());
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });
        grainyield.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setgrainYieldPlant(grainyield.getText().toString());
            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });


        grainyieldplot.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setgrainYieldPlot(grainyieldplot.getText().toString());
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

        rainfall.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setNoOfRainyDays(rainfall.getText().toString());

            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });

        et_Sunshine_humidity.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                sharedPrefrenceUtil.setSunshineHours(et_Sunshine_humidity.getText().toString());

            }


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                //Toast.makeText(context, "aaaaaaaaa", Toast.LENGTH_SHORT).show();

            }

        });


    }





    public void declaration_Data_Collection(){
        data_collection1=view.findViewById(R.id.data_collection1);

        plantheight=view.findViewById(R.id.plantheight);
        productive_tillers=view.findViewById(R.id.productive_tillers);
        panicle=view.findViewById(R.id.panicle);
        fruitsplant=view.findViewById(R.id.fruitsplant);
        harvestingdate=view.findViewById(R.id.harvestingdate);
        grainweight=view.findViewById(R.id.grainweight);
        grainyield=view.findViewById(R.id.grainyield);
        grainyieldplot=view.findViewById(R.id.grainyieldplot);
        straw_yield=view.findViewById(R.id.straw_yield);
        by_product=view.findViewById(R.id.by_product);
        rainfall=view.findViewById(R.id.rainfall);
        et_annual_rainfall=view.findViewById(R.id.et_annual_rainfall);
        et_min_temp=view.findViewById(R.id.et_min_temp);
        et_max_temp=view.findViewById(R.id.et_max_temp);
        et_Relative_Humidity=view.findViewById(R.id.et_Relative_Humidity);
        et_Sunshine_humidity=view.findViewById(R.id.et_Sunshine_humidity);
        selectrainfall=view.findViewById(R.id.selectrainfall);
        selectgeneralinfo=view.findViewById(R.id.selectgeneralinfo);
        selectcropcondition=view.findViewById(R.id.selectcropcondition);

        selectrainfall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {


                // Toast.makeText(context,state_name,Toast.LENGTH_SHORT).show()
                rainfallselecteditem = getResources().getStringArray(R.array.rainfall_values)[po];
                    sharedPrefrenceUtil.setdatarecordedrainfall(rainfallselecteditem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        if (context != null) {
            ArrayAdapter rainfallvalue = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.rainfall_values)) {
                public View getView(int position, View convertView, ViewGroup parent) {
                    // Cast the spinner collapsed item (non-popup item) as a text view
                    TextView tv = (TextView) super.getView(position, convertView, parent);

                    // Set the text color of spinner item
                    tv.setTextColor(Color.GRAY);

                    // Return the view
                    return tv;
                }

                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    // Cast the drop down items (popup items) as text view
                    TextView tv = (TextView) super.getDropDownView(position, convertView, parent);

                    // Set the text color of drop down items
                    tv.setTextColor(Color.BLACK);

                    // If this item is selected item
                    if (position == 0) {
                        // Set spinner selected popup item's text color
                        tv.setTextColor(Color.GRAY);
                    }

                    // Return the modified view
                    return tv;
                }
            };
            //Setting the ArrayAdapter data on the Spinner
            selectrainfall.setAdapter(rainfallvalue);
        }

        selectcropcondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {


                // Toast.makeText(context,state_name,Toast.LENGTH_SHORT).show()
                selectedcropitem = getResources().getStringArray(R.array.cropcondition_values)[po];
                sharedPrefrenceUtil.setdatarecordedcropcond(selectedcropitem);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



        if (context != null) {

            ArrayAdapter generalobservation = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.cropcondition_values)) {
                public View getView(int position, View convertView, ViewGroup parent) {
                    // Cast the spinner collapsed item (non-popup item) as a text view
                    TextView tv = (TextView) super.getView(position, convertView, parent);

                    // Set the text color of spinner item
                    tv.setTextColor(Color.GRAY);

                    // Return the view
                    return tv;
                }

                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    // Cast the drop down items (popup items) as text view
                    TextView tv = (TextView) super.getDropDownView(position, convertView, parent);

                    // Set the text color of drop down items
                    tv.setTextColor(Color.BLACK);

                    // If this item is selected item
                    if (position == 0) {
                        // Set spinner selected popup item's text color
                        tv.setTextColor(Color.GRAY);
                    }

                    // Return the modified view
                    return tv;
                }
            };
            selectcropcondition.setAdapter(generalobservation);

        }

        selectgeneralinfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int po, long id) {


                // Toast.makeText(context,state_name,Toast.LENGTH_SHORT).show()
                selectgeneralinfoitem = getResources().getStringArray(R.array.generalobservation_values)[po];
                sharedPrefrenceUtil.setdatarecordedgeneralobs(selectedcropitem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        if (context != null) {
            ArrayAdapter maincrop = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.generalobservation_values)) {
                public View getView(int position, View convertView, ViewGroup parent) {
                    // Cast the spinner collapsed item (non-popup item) as a text view
                    TextView tv = (TextView) super.getView(position, convertView, parent);

                    // Set the text color of spinner item
                    tv.setTextColor(Color.GRAY);

                    // Return the view
                    return tv;
                }

                @Override
                public View getDropDownView(int position, View convertView, ViewGroup parent) {
                    // Cast the drop down items (popup items) as text view
                    TextView tv = (TextView) super.getDropDownView(position, convertView, parent);

                    // Set the text color of drop down items
                    tv.setTextColor(Color.BLACK);

                    // If this item is selected item
                    if (position == 0) {
                        // Set spinner selected popup item's text color
                        tv.setTextColor(Color.GRAY);
                    }

                    // Return the modified view
                    return tv;
                }
            };
            selectgeneralinfo.setAdapter(maincrop);
        }


    }



    private void getSelectedSpinnerValue() {


        if (!sharedPrefrenceUtil.getdatarecordedrainfall().isEmpty()) {
            for (int i = 0; i < rainfall_values.length; i++) {
                String rainfallselected = getResources().getStringArray(R.array.rainfall_values)[i];

                if (rainfallselected.equals(sharedPrefrenceUtil.getdatarecordedrainfall())) {
                    selectrainfall.setSelection(i);
                }
            }
        }

        if (!sharedPrefrenceUtil.getdatarecordedcropcond().isEmpty()) {
            for (int i = 0; i < getResources().getStringArray(R.array.cropcondition_values).length; i++) {
                String cropconditionitem = getResources().getStringArray(R.array.cropcondition_values)[i];

                if (cropconditionitem.equals(sharedPrefrenceUtil.getdatarecordedcropcond())) {
                    selectcropcondition.setSelection(i);
                }
            }
        }

        if (!sharedPrefrenceUtil.getdatarecordedgeneralobs().isEmpty()) {
            for (int i = 0; i < getResources().getStringArray(R.array.generalobservation_values).length; i++) {
                String generalobservation = getResources().getStringArray(R.array.generalobservation_values)[i];

                if (generalobservation.equals(sharedPrefrenceUtil.getdatarecordedgeneralobs()))

                {
                    selectgeneralinfo.setSelection(i);
                }

            }

        }
    }



    public void declaration_crop_info(){
        cropInfo1=view.findViewById(R.id.cropInfo1);

        varietyname=view.findViewById(R.id.varietyname);
        etArea=view.findViewById(R.id.etArea);
        land_preparation_date=view.findViewById(R.id.land_preparation_date);
        dateofsowing=view.findViewById(R.id.dateofsowing);
        input_planting_date=view.findViewById(R.id.input_planting_date);
        firtdiseasedate=view.findViewById(R.id.firtdiseasedate);
        secondapplications=view.findViewById(R.id.secondapplications);
        irrigation_type=view.findViewById(R.id.irrigation_type);
        weed_notice=view.findViewById(R.id.weed_notice);
        first_weeddate=view.findViewById(R.id.first_weeddate);
        secondweeddate=view.findViewById(R.id.secondweeddate);

        firtdiseasedatePest=view.findViewById(R.id.firtdiseasedatePest);
        secondapplicationsPest=view.findViewById(R.id.secondapplicationsPest);
        txtCropStatus=view.findViewById(R.id.txtCropStatus);
        spinnerName=view.findViewById(R.id.spinnerName);
        spinnerFertilizer=view.findViewById(R.id.spinnerFertilizer);
        diseaseobserverd=view.findViewById(R.id.diseaseobserverd);
        pest_observed=view.findViewById(R.id.pest_observed);
        chk_virus=view.findViewById(R.id.chk_virus);
        chk_nemotodes=view.findViewById(R.id.chk_nemotodes);
        spinner_pestisides=view.findViewById(R.id.spinner_pestisides);
        cbFertilizer=view.findViewById(R.id.cbFertilizer);
        cbpestisides=view.findViewById(R.id.cbpestisides);


        btnCancelCrop=view.findViewById(R.id.btnCancelCrop);
        btnSaveCrop=view.findViewById(R.id.btnSaveCrop);
        btnCropinfo=view.findViewById(R.id.btnCropinfo);
        btnDataCollection=view.findViewById(R.id.btnDataCollection);
        cropinfo2=view.findViewById(R.id.cropinfo2);


        llCropInfo=view.findViewById(R.id.llCropInfo);
        llDataColl=view.findViewById(R.id.llDataColl);
        llDataColl.setVisibility(View.GONE);
        btnSaveDataCollection=view.findViewById(R.id.btnSaveDataCollection);
        btnCancelDataColl=view.findViewById(R.id.btnCancelDataColl);

        btnCancelCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f2 = getFragmentManager().findFragmentById(R.id.container2);

                if (f2 instanceof CropInfoFragment) {
                    getFragmentManager().beginTransaction().remove(f2).commit();
                }           
            }
        });

        btnCancelDataColl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f2 = getFragmentManager().findFragmentById(R.id.container2);

                if (f2 instanceof CropInfoFragment) {
                    getFragmentManager().beginTransaction().remove(f2).commit();
                }
            }
        });
        btnCropinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cropinfo2.setVisibility(View.VISIBLE);
                data_collection1.setVisibility(View.GONE);
                llDataColl.setVisibility(View.GONE);
                llCropInfo.setVisibility(View.VISIBLE);

                btnCropinfo.setBackgroundColor(Color.parseColor("#0B8A05"));
                btnDataCollection.setBackgroundResource(R.drawable.white_box);
                btnDataCollection.setTextColor(Color.BLACK);
                imgDatac.setVisibility(View.GONE);
                txtDatac.setVisibility(View.GONE);
                imgCrop.setVisibility(View.VISIBLE);
                txtCrop.setVisibility(View.VISIBLE);
                btnCropinfo.setTextColor(Color.WHITE); }
        });

        btnDataCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (txtCropStatus.getText().toString().isEmpty()){
//                    Config.toast(context,"please select main crop");
//                }else if (spinnerName.getText().toString().isEmpty()){
//                    Config.toast(context,"please select sub crop");
//                }
//
//                else {
                    llDataColl.setVisibility(View.VISIBLE);
                    llCropInfo.setVisibility(View.GONE);
                    data_collection1.setVisibility(View.VISIBLE);
                    cropinfo2.setVisibility(View.GONE);
                    btnDataCollection.setBackgroundColor(Color.parseColor("#0B8A05"));
                    btnDataCollection.setTextColor(Color.WHITE);
                    btnCropinfo.setTextColor(Color.BLACK);
                    btnCropinfo.setBackgroundResource(R.drawable.white_box);
                    imgDatac.setVisibility(View.VISIBLE);
                    txtDatac.setVisibility(View.VISIBLE);
                    imgCrop.setVisibility(View.GONE);
                    txtCrop.setVisibility(View.GONE);

//                }
            }
        });


        txtCropStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from="main";
                if (labList!=null) {
                    if (labList.size() > 0) {
                        Config.CallFragment4(context, new MainCrops());
                    } else {
                        Config.toast(context, "No crop added");
                    }
                }
            }
        });

        spinnerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(labList.size()>0) {  from = "sub";
                    Config.CallFragment4(context, new MainCrops());
                }else {
                    Config.toast(context,"No crop added");
                }
            }
        });

        diseaseobserverd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtCropStatus.getText().toString().contains("("))
                    Config.toast(context,"Please select a crop");
                else    Config.CallFragment4(context,new CropDiseasesFragment());
            }
        });

  pest_observed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtCropStatus.getText().toString().contains("("))
                    Config.toast(context,"Please select a crop");
                else
                    Config.CallFragment4(context,new CropPestFragment());
            }
        });
btnSaveCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCropStatus.getText().toString().equals("") )
                    Config.toast(context,"Please select crop");
                else
               POSTCropInfo();
//                GetCropInfoSize();
            }
        });



        land_preparation_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                land_preparation_date.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth );
                            }
                        }, year, month, day);
                picker.show();
            }
        });


 dateofsowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateofsowing.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });



 dateofsowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateofsowing.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


 input_planting_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                input_planting_date.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

first_weeddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                first_weeddate.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

firtdiseasedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                firtdiseasedate.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

firtdiseasedatePest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                firtdiseasedatePest.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


secondapplications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                secondapplications.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

secondapplicationsPest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                secondapplicationsPest.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

secondweeddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date pickeroo dialog
                DatePickerDialog picker = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                secondweeddate.setText(year + "/" + (monthOfYear + 1) + "/" +dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });



    }




    private void updateDataCollection() {
        String plantHeight,numOFTrillers,panicleSize,numOfFruit,dateOfHarvesting,weightperThousands,yeildPlant,yeildPlot,
                strawYield,byProduct,rainyDays,annualRainfall,minTemp,maxTemp,RelHumidity,selectCropCondition,selectGeneralInfo,
                selectRainfall,Sunshine_humidity;

        plantHeight="";
        if (etArray.size()>0){
            sb = new StringBuffer(edHeight1.getText().toString()+","+edHeight2.getText().toString()+","
                    +edHeight3.getText().toString()+","+edHeight4.getText().toString()+","+edHeight5.getText().toString()+",");

            for (int i=0;i<etArray.size();i++) {
                if (i==etArray.size()-1)
                    sb.append(etArray.get(i).getText().toString());
                else
                    sb.append(etArray.get(i).getText().toString()+",");
//                        System.out.println(myEditText.getText().toString());
//                productive_tillers.setText(sb);
            }
            plantHeight=sb+"";
        }
        numOFTrillers="";

        if (etArrayTiller.size()>0){
            sb = new StringBuffer(edTiller1.getText().toString()+","+edTiller2.getText().toString()+","
                    +edTiller3.getText().toString()+","+edTiller4.getText().toString()+","+edTiller5.getText().toString()+",");

            for (int i=0;i<etArrayTiller.size();i++) {
                if (i==etArrayTiller.size()-1)
                    sb.append(etArrayTiller.get(i).getText().toString());
                else
                    sb.append(etArrayTiller.get(i).getText().toString()+",");
//                        System.out.println(myEditText.getText().toString());
//                productive_tillers.setText(sb);
            }
            numOFTrillers=sb+"";
        }

        panicleSize="";

        if (etArrayPanicle.size()>0){
            sb = new StringBuffer(edPanicle1.getText().toString()+","+edPanicle2.getText().toString()+","
                    +edPanicle3.getText().toString()+","+edPanicle4.getText().toString()+","+edPanicle5.getText().toString()+",");

            for (int i=0;i<etArrayPanicle.size();i++) {
                if (i==etArrayPanicle.size()-1)
                    sb.append(etArrayPanicle.get(i).getText().toString());
                else
                    sb.append(etArrayPanicle.get(i).getText().toString()+",");
//                        System.out.println(myEditText.getText().toString());
//                productive_tillers.setText(sb);
            }
            panicleSize=sb+"";
        }

        weightperThousands="";

        if (etArrayWeight.size()>0){
            sb = new StringBuffer(edWeight1.getText().toString()+","+edWeight2.getText().toString()+","
                    +edWeight3.getText().toString()+","+edWeight4.getText().toString()+","+edWeight5.getText().toString()+",");

            for (int i=0;i<etArrayWeight.size();i++) {
                if (i==etArrayWeight.size()-1)
                    sb.append(etArrayWeight.get(i).getText().toString());
                else
                    sb.append(etArrayWeight.get(i).getText().toString()+",");
//                        System.out.println(myEditText.getText().toString());
//                productive_tillers.setText(sb);
            }
            weightperThousands=sb+"";
        }

        yeildPlant="";

        if (etArrayYeild.size()>0){
            sb = new StringBuffer(edYeild1.getText().toString()+","+edYeild2.getText().toString()+","
                    +edYeild3.getText().toString()+","+edYeild4.getText().toString()+","+edYeild5.getText().toString()+",");

            for (int i=0;i<etArrayYeild.size();i++) {
                if (i==etArrayYeild.size()-1)
                    sb.append(etArrayYeild.get(i).getText().toString());
                else
                    sb.append(etArrayYeild.get(i).getText().toString()+",");
//                        System.out.println(myEditText.getText().toString());
//                productive_tillers.setText(sb);
            }
            yeildPlant=sb+"";
        }

        numOfFruit="";

        if (etArrayFruits.size()>0){
            sb = new StringBuffer(edFruits1.getText().toString()+","+edFruits2.getText().toString()+","
                    +edFruits3.getText().toString()+","+edFruits4.getText().toString()+","+edFruits5.getText().toString()+",");

            for (int i=0;i<etArrayFruits.size();i++) {
                if (i==etArrayFruits.size()-1)
                    sb.append(etArrayFruits.get(i).getText().toString());
                else
                    sb.append(etArrayFruits.get(i).getText().toString()+",");
//                        System.out.println(myEditText.getText().toString());
//                productive_tillers.setText(sb);
            }
            numOfFruit=sb+"";
        }



//        numOFTrillers=productive_tillers.getText().toString();
//        panicleSize=panicle.getText().toString();
//        numOfFruit=fruitsplant.getText().toString();
        dateOfHarvesting=harvestingdate.getText().toString();
//        weightperThousands=grainweight.getText().toString();
//        yeildPlant=grainyield.getText().toString();
        yeildPlot=grainyieldplot.getText().toString();
        strawYield=straw_yield.getText().toString();
        byProduct=by_product.getText().toString();
        rainyDays=rainfall.getText().toString();
        annualRainfall=et_annual_rainfall.getText().toString();
        minTemp=et_min_temp.getText().toString();;
        maxTemp=et_max_temp.getText().toString();
        RelHumidity=et_Relative_Humidity.getText().toString();
        selectCropCondition=sharedPrefrenceUtil.getdatarecordedcropcond();
        selectGeneralInfo=sharedPrefrenceUtil.getdatarecordedgeneralobs();
        Sunshine_humidity=et_Sunshine_humidity.getText().toString();

        String  id= sharedPrefrenceUtil.getResponseId();


            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
//            RequestDataCollection machineryrequest = new RequestDataCollection(annualRainfall, byProduct, selectCropCondition, "1"
//                    , sharedPrefrenceUtil.getFarmLabID(), id, selectGeneralInfo, dateOfHarvesting, maxTemp, minTemp, numOfFruit, rainyDays, panicleSize, plantHeight,
//                    yeildPlot, numOFTrillers, sharedPrefrenceUtil.getdatarecordedrainfall(), RelHumidity, strawYield, Sunshine_humidity, weightperThousands);

        RequestDataCollection machineryrequest = new RequestDataCollection(annualRainfall,byProduct,selectCropCondition,sharedPrefrenceUtil.getCropInfoID()+""
        ,"1",sharedPrefrenceUtil.getFarmLabID(),id,selectGeneralInfo,dateOfHarvesting,maxTemp,minTemp,numOfFruit,rainyDays,panicleSize, plantHeight,
                yeildPlant,yeildPlot, numOFTrillers, sharedPrefrenceUtil.getdatarecordedrainfall(), RelHumidity, strawYield, Sunshine_humidity,
                weightperThousands);
            Call<ResponseDataCollection> call = mapiClinet.updateDataCollection(machineryrequest);
        Toast.makeText(getContext(), "crop id " + sharedPrefrenceUtil.getCropInfoID() + " and farmlab id : " + sharedPrefrenceUtil.getFarmLabID(), Toast.LENGTH_LONG).show();

        call.enqueue(new Callback<ResponseDataCollection>() {

                @Override
                public void onResponse(Call<ResponseDataCollection> call, Response<ResponseDataCollection> response) {
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();

                        if (errCode.equals(true)) {
                            Toast.makeText(getContext(), "SuccessFully Data Syc to Server", Toast.LENGTH_LONG).show();
                            Log.e("response", "" + response.body());

                        } else {

                            Toast.makeText(getContext(), "Sucessfully Data Syc to Server", Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_LONG).show();
                    }
                    //  showTaost(msg);

                }

                @Override
                public void onFailure(Call<ResponseDataCollection> call, Throwable t) {
                    //  progressDoalog.dismiss();
                    //Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }



       public void getDataCollection(){
           ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
           DataCollectionRequest machineryrequest = new DataCollectionRequest(id,sharedPrefrenceUtil.getCropInfoID()+"");
           Call<DataCollectionResponse> call = mapiClinet.getDataCollection(machineryrequest);
           call.enqueue(new Callback<DataCollectionResponse>() {

               @Override
               public void onResponse(Call<DataCollectionResponse> call, Response<DataCollectionResponse> response) {
                   if (response.body() != null) {
                       Boolean errCode = response.body().getStatus();

                       if (errCode.equals(true)) {
//                           try {
//                               Log.e("get_data_collection: ",response.body()+"");
                               DataCollectionResponse retailerBeatResponse = response.body();
                               Datacollectionlist list=retailerBeatResponse.getDatacollectionlist();

//                               Toast.makeText(context, "get data "+list.getPlantHeight(), Toast.LENGTH_LONG).show();
//                               Config.toast(context,"plant height is "+list.getPlantHeight());
//                               Log.e("list.getPlantHeight(): ",list.getPlantHeight());
//                               plantheight.setText(list.getPlantHeight());
//                               sharedPrefrenceUtil.setPlantHeight(list.getPlantHeight());

//                               productive_tillers.setText(list.getProductiveTiller());
//                               sharedPrefrenceUtil.setNoProductivityTiller(list.getProductiveTiller());

//                               panicle.setText(list.getPanicleSize());
//                               sharedPrefrenceUtil.setPanicleSize(list.getPanicleSize());

//                               fruitsplant.setText(list.getNumberFruitPlant());
//                               sharedPrefrenceUtil.setNoOfFruit(list.getNumberFruitPlant());

                               harvestingdate.setText(list.getHarvestingDate());
//                               sharedPrefrenceUtil.setDateOfHarvesting(list.getHarvestingDate());

                               grainweight.setText(list.getThousandGrainWeight()+"");
//                               sharedPrefrenceUtil.setgrainweight(list.getThousandGrainWeight()+"");

                               grainyieldplot.setText(list.getPlotYield());

                               straw_yield.setText(list.getStrawYield());

                               by_product.setText(list.getByProduct());

                               rainfall.setText(list.getRainfallDistribution());

                               et_annual_rainfall.setText(list.getAnnualRainfall());

                               et_min_temp.setText(list.getMinimumTemperature());

                               et_max_temp.setText(list.getMaximumTemperature());

                               et_Relative_Humidity.setText(list.getRelativeHumidity());

                               et_Sunshine_humidity.setText(list.getSunshineHours());


                               List<String> elephantList = Arrays.asList(list.getPlantHeight().split(","));
                               List<String> listTiller = Arrays.asList(list.getProductiveTiller().split(","));
                               List<String> listPanicle = Arrays.asList(list.getPanicleSize().split(","));
                               List<String> listWeight = Arrays.asList(list.getThousandGrainWeight().split(","));
                               List<String> listYeild = Arrays.asList(list.getPlantYield().split(","));
                               List<String> listFruits = Arrays.asList(list.getNumberFruitPlant().split(","));

//                               android.text.TextUtils.join(",", list.getPlantHeight());


                           try {
                               edHeight1.setText(elephantList.get(0));
                               edHeight2.setText(elephantList.get(1));
                               edHeight3.setText(elephantList.get(2));
                               edHeight4.setText(elephantList.get(3));
                               edHeight5.setText(elephantList.get(4));
                           }catch (Exception e){}

                           try {
                               edTiller1.setText(listTiller.get(0));
                               edTiller2.setText(listTiller.get(1));
                               edTiller3.setText(listTiller.get(2));
                               edTiller4.setText(listTiller.get(3));
                               edTiller5.setText(listTiller.get(4));
                           }catch (Exception e){}

                           try {
                               edPanicle1.setText(listPanicle.get(0));
                               edPanicle2.setText(listPanicle.get(1));
                               edPanicle3.setText(listPanicle.get(2));
                               edPanicle4.setText(listPanicle.get(3));
                               edPanicle5.setText(listPanicle.get(4));
                           }catch (Exception e){}

                           try{
                           edWeight1.setText(listWeight.get(0));
                               edWeight2.setText(listWeight.get(1));
                               edWeight3.setText(listWeight.get(2));
                               edWeight4.setText(listWeight.get(3));
                               edWeight5.setText(listWeight.get(4));
                           }catch (Exception e){}


                           try{
                           edYeild1.setText(listYeild.get(0));
                               edYeild2.setText(listYeild.get(1));
                               edYeild3.setText(listYeild.get(2));
                               edYeild4.setText(listYeild.get(3));
                               edYeild5.setText(listYeild.get(4));
                           }catch (Exception e){}


                           try{
                           edFruits1.setText(listFruits.get(0));
                               edFruits2.setText(listFruits.get(1));
                               edFruits3.setText(listFruits.get(2));
                               edFruits4.setText(listFruits.get(3));
                               edFruits5.setText(listFruits.get(4));
                           }catch (Exception e){}




                           for (int j=5;j<elephantList.size();j++) {

                                   myEditText = new EditText(context); // Pass it an Activity or Context
                                   etArray.add(etArray.size(), myEditText);
                                   if (etArray.size() == 0) {
                                       myEditText.setText(elephantList.get(5));
                                       etArray.get(5);
                                       Config.toast(context, etArray.get(5) + "");

                                   } else {
//                    etArray.get(etArray.size());
                                       myEditText.setText(elephantList.get(j));
                                       Config.toast(context, etArray.size() + "");
                                   }
//                myEditText.setTag("myEditText"+"1");
                                   myEditText.setBackgroundResource(R.drawable.white_box);
                                   ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                                   myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                                   myEditText.setGravity(Gravity.CENTER);
                                   myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                                   myEditText.setSingleLine(true);
                                   int maxLength = 3;
                                   myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                                   llHeight.addView(myEditText);


                               }

                               for (int j=5;j<listTiller.size();j++) {

                                   myEditText = new EditText(context); // Pass it an Activity or Context
                                   etArrayTiller.add(etArrayTiller.size(), myEditText);
                                   if (etArrayTiller.size() == 0) {
                                       myEditText.setText(listTiller.get(5));
                                       etArrayTiller.get(5);
                                       Config.toast(context, etArrayTiller.get(5) + "");

                                   } else {
//                    etArray.get(etArray.size());
                                       myEditText.setText(listTiller.get(j));
                                       Config.toast(context, etArrayTiller.size() + "");
                                   }
//                myEditText.setTag("myEditText"+"1");
                                   myEditText.setBackgroundResource(R.drawable.white_box);
                                   ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                                   myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                                   myEditText.setGravity(Gravity.CENTER);
                                   myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                                   myEditText.setSingleLine(true);
                                   llTiller.addView(myEditText);


                               }


                                for (int j=5;j<listPanicle.size();j++) {

                                   myEditText = new EditText(context); // Pass it an Activity or Context
                                   etArrayPanicle.add(etArrayPanicle.size(), myEditText);
                                   if (etArrayPanicle.size() == 0) {
                                       myEditText.setText(listPanicle.get(5));
                                       etArrayPanicle.get(5);
                                       Config.toast(context, etArrayPanicle.get(5) + "");

                                   } else {
//                    etArray.get(etArray.size());
                                       myEditText.setText(listPanicle.get(j));
                                       Config.toast(context, etArrayPanicle.size() + "");
                                   }
//                myEditText.setTag("myEditText"+"1");
                                   myEditText.setBackgroundResource(R.drawable.white_box);
                                   ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                                   myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                                   myEditText.setGravity(Gravity.CENTER);
                                    myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                                   myEditText.setSingleLine(true);
                                   llPanicle.addView(myEditText);


                               }


                               for (int j=5;j<listWeight.size();j++) {

                                   myEditText = new EditText(context); // Pass it an Activity or Context
                                   etArrayWeight.add(etArrayWeight.size(), myEditText);
                                   if (etArrayWeight.size() == 0) {
                                       myEditText.setText(listWeight.get(5));
                                       etArrayWeight.get(5);
                                       Config.toast(context, etArrayWeight.get(5) + "");

                                   } else {
//                    etArray.get(etArray.size());
                                       myEditText.setText(listWeight.get(j));
                                       Config.toast(context, etArrayWeight.size() + "");
                                   }
//                myEditText.setTag("myEditText"+"1");
                                   myEditText.setBackgroundResource(R.drawable.white_box);
                                   ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                                   myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                                   myEditText.setGravity(Gravity.CENTER);
                                   myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                                   myEditText.setSingleLine(true);
                                   llWeight.addView(myEditText);


                               }

                                 for (int j=5;j<listYeild.size();j++) {

                                   myEditText = new EditText(context); // Pass it an Activity or Context
                                   etArrayYeild.add(etArrayYeild.size(), myEditText);
                                   if (etArrayYeild.size() == 0) {
                                       myEditText.setText(listYeild.get(5));
                                       etArrayYeild.get(5);
                                       Config.toast(context, etArrayYeild.get(5) + "");

                                   } else {
//                    etArray.get(etArray.size());
                                       myEditText.setText(listYeild.get(j));
                                       Config.toast(context, etArrayYeild.size() + "");
                                   }
//                myEditText.setTag("myEditText"+"1");
                                   myEditText.setBackgroundResource(R.drawable.white_box);
                                   ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                                   myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                                   myEditText.setGravity(Gravity.CENTER);
                                     myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                                   myEditText.setSingleLine(true);
                                   llYeild.addView(myEditText);
                               }


                                for (int j=5;j<listFruits.size();j++) {

                                   myEditText = new EditText(context); // Pass it an Activity or Context
                                   etArrayFruits.add(etArrayFruits.size(), myEditText);
                                   if (etArrayFruits.size() == 0) {
                                       myEditText.setText(listFruits.get(5));
                                       etArrayFruits.get(5);
                                       Config.toast(context, etArrayFruits.get(5) + "");

                                   } else {
//                    etArray.get(etArray.size());
                                       myEditText.setText(listFruits.get(j));
                                       Config.toast(context, etArrayFruits.size() + "");
                                   }
//                myEditText.setTag("myEditText"+"1");
                                   myEditText.setBackgroundResource(R.drawable.white_box);
                                   ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                                   myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                                   myEditText.setGravity(Gravity.CENTER);
                                    myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                                   myEditText.setSingleLine(true);
                                   llFruits.addView(myEditText);
                               }
//                           }catch(Exception e){}

                       } else{
                       }

                   } else {
//                        Config.toast(context, "Please check your Internet Connection");
                   }
                   //  showTaost(msg);
               }

               @Override
               public void onFailure(Call<DataCollectionResponse> call, Throwable t) {
                   //  progressDoalog.dismiss();
                       Config.toast(getContext(), "Something went wrong...Please try later!");
               }
           });
       }


    public void getpestisides() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SoilRequest machineryrequest = new SoilRequest(id);
        Call<PestisidesListResponse> call = mapiClinet.getPestList(machineryrequest);
        call.enqueue(new Callback<PestisidesListResponse>() {
            @Override
            public void onResponse(Call<PestisidesListResponse> call, Response<PestisidesListResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        PestisidesListResponse retailerBeatResponse = response.body();
                         pestisidesNameList = retailerBeatResponse.getPesticidesNameList();
//                        statelist.addAll(pestisidesNameList);
                        pestisidesAdapter adapter = new pestisidesAdapter(getContext(), pestisidesNameList);
                        spinner_pestisides.setAdapter(adapter);

                    } else {
                    }

                } else {
                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<PestisidesListResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class pestisidesAdapter extends BaseAdapter implements SpinnerAdapter {
        private final Context activity;
        private List<PesticidesNameList> asr;

        public pestisidesAdapter(Context context, List<PesticidesNameList> asr) {
            this.asr = asr; activity = context;
        }
        public int getCount() {
            return asr.size();
        }
        public Object getItem(int i) {
            return asr.get(i);
        }
        public long getItemId(int i) {
            return (long) i;
        }
        @Override

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            }
            TextView textView = convertView.findViewById(R.id.text);
            textView.setText(asr.get(position).getPesticidesName());
            if (position == 0) {
                textView.setTextColor(Color.GRAY);
            } else {
                textView.setTextColor(Color.BLACK);
            }
            return convertView;
        }
        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            TextView textView = view1.findViewById(R.id.text);
            textView.setText(asr.get(i).getPesticidesName());
            textView.setTextColor(Color.GRAY);
            return view1;
        }
    }
    
public void getFertilizer() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SoilRequest machineryrequest = new SoilRequest(id);
        Call<FertilizerResponse> call = mapiClinet.getFertilizer(machineryrequest);
        call.enqueue(new Callback<FertilizerResponse>() {
            @Override
            public void onResponse(Call<FertilizerResponse> call, Response<FertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        FertilizerResponse retailerBeatResponse = response.body();
                         fertilizerList = retailerBeatResponse.getCropNameList();
//                        fertilizerLists.addAll(fertilizerList);
                        FertilizerAdapter adapter = new FertilizerAdapter(getContext(), fertilizerList);
                        spinnerFertilizer.setAdapter(adapter);

                    } else {
                    }

                } else {
                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<FertilizerResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class FertilizerAdapter extends BaseAdapter implements SpinnerAdapter {
        private final Context activity;
        private List<FertilizerList> asr;

        public FertilizerAdapter(Context context, List<FertilizerList> asr) {
            this.asr = asr; activity = context;
        }
        public int getCount() {
            return asr.size();
        }
        public Object getItem(int i) {
            return asr.get(i);
        }
        public long getItemId(int i) {
            return (long) i;
        }
        @Override

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            }
            TextView textView = convertView.findViewById(R.id.text);
            textView.setText(asr.get(position).getFertilizerName());

            if (position == 0) {
                textView.setTextColor(Color.GRAY);
            } else {
                textView.setTextColor(Color.BLACK);
            }
            return convertView;
        }
        public View getView(int i, View view, ViewGroup viewgroup) {
            View view1 = getLayoutInflater().inflate(R.layout.adapter_spinner, null);
            TextView textView = view1.findViewById(R.id.text);
            textView.setText(asr.get(i).getFertilizerName());
            textView.setTextColor(Color.GRAY);
            return view1;
        }
    }
    private void alertClickListner() {

//        diseaseobserverd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                alertDisease();
//
//
//            }
//
//
//        });
        cbpestisides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTitle.setText("Add Pesticides");
                alertpestisidesList();

            }


        });
        cbFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTitle.setText("Add Fertilizer");
                alertFertilizerList();
            }


        });
    }


//    private void alertDisease() {
//
//        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
//// ...Irrelevant code for customizing the buttons and title
//        LayoutInflater inflater = context.getLayoutInflater();
//        final View dialogView = inflater.inflate(R.layout.alert_dialog_irrigation, null);
//        dialogBuilder.setView(dialogView);
//
//
//        RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler);
//        LinearLayoutManager horizontalLayoutManagaer
//                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(horizontalLayoutManagaer);
//
//
//        DiseaseAdapterCROP adapter = new DiseaseAdapterCROP(CropInfoFragment.this, messagess);
//        recyclerView.setAdapter(adapter);
//
//        final AlertDialog alertDialog = dialogBuilder.create();
//        alertDialog.show();
//        alertDialog.setCanceledOnTouchOutside(false);
//
//        Button ok_button = dialogView.findViewById(R.id.button2);
//        //Button cancel_button = dialogView.findViewById(R.id.button3);
//        ok_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (diseaseArray.size() > 0) {
//
//                    diseaseobserverd.setChecked(true);
//
//                    SaveMachineData dataModel = new SaveMachineData();
//                    dataModel.setData(diseaseArray);
//
//                    SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
//                    sharedPrefrenceUtil.setCheckMachineItem(dataModel);
//
//                } else {
//
//                    diseaseobserverd.setChecked(false);
//                    SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
//                    sharedPrefrenceUtil.setCheckMachineItem(null);
//
//                }
//
//                alertDialog.dismiss();
//
//            }
//        });
//
//    }

    public void getMachinary() {


        id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        LanguageRequest machineryrequest = new LanguageRequest("16","eng");
        Call<MachineryResponse> call = mapiClinet.doMachinery(machineryrequest);
        call.enqueue(new Callback<MachineryResponse>() {

            @Override
            public void onResponse(Call<MachineryResponse> call, Response<MachineryResponse> response) {
                if (response.body() != null) {

                    // farmer_farmlocation.setText(SingletonClass.getInstance().getLatitude()+","+SingletonClass.getInstance().getLatitude());

                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        MachineryResponse retailerBeatResponse = response.body();
                        messagess = retailerBeatResponse.getMachinaryList();

                        sharedPrefrenceUtil.setHindiMachineryItem(retailerBeatResponse);

                        //   alertdiaolg();
                        //CleaningTypeSpinnerAdapter adapter = new CleaningTypeSpinnerAdapter(MainActivity.this, messagess);
                        //spinner_machinery.setAdapter(adapter
                        // );
                        //list.setAdapter(customAdatorr)
                        // Toast.makeText(
                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
                        Log.e("response", "" + response.body());
                        Log.e("messagess machine ", ""+messagess);


                    } else {
                    }

                } else {
                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<MachineryResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void alertpestisidesList() {
        if (getActivity() != null) {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.add_others, null);
        dialogBuilder.setView(dialogView);


         recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);


        PestisidesListAdapter adapter = new PestisidesListAdapter(CropInfoFragment.this, pestisidesNameList);
        recyclerView.setAdapter(adapter);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);


            CheckBox checkboxOthers = dialogView.findViewById(R.id.checkboxOthers);

            checkboxOthers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    frame_layout_others.setVisibility(View.VISIBLE);
                    if (pestisides_array.size() > 0) {
                        cbpestisides.setChecked(true);
                        SaveMachineData dataModel = new SaveMachineData();
                        dataModel.setData(pestisides_array);
                        new SharedPrefrenceUtil(context).setCheckMachineItem(dataModel);
                    } else {
                        cbpestisides.setChecked(false);
                        new SharedPrefrenceUtil(context).setCheckMachineItem(null);
                    }
                    alertDialog.dismiss();

                }
            });



        Button ok_button = dialogView.findViewById(R.id.button2);
        //Button cancel_button = dialogView.findViewById(R.id.button3);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pestisides_array.size() > 0) {

                    diseaseobserverd.setChecked(true);

                    SaveMachineData dataModel = new SaveMachineData();
                    dataModel.setData(pestisides_array);

                    sharedPrefrenceUtil.setCheckMachineItem(dataModel);
                } else {

                    diseaseobserverd.setChecked(false);
                    sharedPrefrenceUtil.setCheckMachineItem(null);
                }
                alertDialog.dismiss();

            }
        });

    }
    }

private void alertFertilizerList() {
    if (getActivity() != null) {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.add_others, null);
        dialogBuilder.setView(dialogView);


        RecyclerView recyclerView =  dialogView.findViewById(R.id.recycler);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);


        FertilizerListAdapter adapter = new FertilizerListAdapter(CropInfoFragment.this, fertilizerList,context);
        recyclerView.setAdapter(adapter);

       alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);

        CheckBox checkboxOthers = dialogView.findViewById(R.id.checkboxOthers);
        
        checkboxOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frame_layout_others.setVisibility(View.VISIBLE);
                if (fertilizerArray.size() > 0) {
                    cbFertilizer.setChecked(true);
                    SaveMachineData dataModel = new SaveMachineData();
                    dataModel.setData(fertilizerArray);
                    new SharedPrefrenceUtil(context).setCheckMachineItem(dataModel);
                } else {
                    cbFertilizer.setChecked(false);
                    new SharedPrefrenceUtil(context).setCheckMachineItem(null);
                }
                alertDialog.dismiss();
                
            }
        });
        
        Button ok_button = dialogView.findViewById(R.id.button2);
        //Button cancel_button = dialogView.findViewById(R.id.button3);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fertilizerArray.size() > 0) {
                    cbFertilizer.setChecked(true);
                    SaveMachineData dataModel = new SaveMachineData();
                    dataModel.setData(fertilizerArray);
                    sharedPrefrenceUtil.setCheckMachineItem(dataModel);
                } else {
                    cbFertilizer.setChecked(false);
                    sharedPrefrenceUtil.setCheckMachineItem(null);
                }

                alertDialog.dismiss();

            }
        });
    }
    }


    @Override
    public void onResume() {
        super.onResume();
    }
    
    
    
    
    public  void POSTCropInfo(){
        final   RelativeLayout gif1=view.findViewById(R.id.imgGif);
        gif1.setVisibility(View.VISIBLE);
        final String crop_info_id,farmer_id,crop_status,crop_name,variety_name,crop_Area,land_preparation_Date;
        final String showing_date ,planting_date,fertilizer_calculator,fertlizer_name,fst_application_date,
                snd_application_date, no_of_irrigation,weed_control,diseases_observed,pestiside,
                fst_pestapplication_date,snd_pestapplication_date,virus ,farm_lab_id,nematodes,others;

        crop_info_id=sharedPrefrenceUtil.getCropInfoID()+"";
        farmer_id=sharedPrefrenceUtil.getResponseId();
        crop_status=txtCropStatus.getText().toString();
        crop_name=spinnerName.getText().toString();
        variety_name=varietyname.getText().toString();
        crop_Area=etArea.getText().toString();
        land_preparation_Date=land_preparation_date.getText().toString();
        showing_date=dateofsowing.getText().toString();
        planting_date=input_planting_date.getText().toString();
        fertilizer_calculator=input_planting_date.getText().toString();
        fertlizer_name=fertilizerArray+"";
        fst_application_date=firtdiseasedate.getText().toString();
        snd_application_date=secondapplications.getText().toString();
        no_of_irrigation=irrigation_type.getText().toString();
        weed_control=weed_notice.getText().toString();
        diseases_observed=diseaseArray+"";
        pestiside=pestisides_array+"";
        fst_pestapplication_date=firtdiseasedatePest.getText().toString();
        snd_pestapplication_date=secondapplicationsPest.getText().toString();

        if (chk_virus.isChecked()) virus="1";
        else virus="0";

        farm_lab_id=sharedPrefrenceUtil.getFarmLabID();

        if (chk_nemotodes.isChecked()) nematodes="1";
        else nematodes="0";

        others="";
//        Toast.makeText(context, "old crop id: "+crop_info_id +" id"+id+" farm_lab_id"+farm_lab_id, Toast.LENGTH_LONG).show();

        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        CropInfoRequest cropInfoRequest=new CropInfoRequest(crop_Area,crop_info_id,crop_name,crop_status,diseases_observed,farm_lab_id
        ,farmer_id,fertilizer_calculator,fertlizer_name,fst_application_date,fst_pestapplication_date,land_preparation_Date,
                nematodes,no_of_irrigation,others,pestiside,planting_date,showing_date,snd_application_date,snd_pestapplication_date,
                variety_name,virus,weed_control,pest+"",first_weeddate.getText().toString(),secondweeddate.getText().toString()
        ,sharedPrefrenceUtil.getSubCropID());


        Call<CropInfoResponse> call = mapiClinet.getCropInfo(cropInfoRequest);
        call.enqueue(new Callback<CropInfoResponse>() {

            @Override
            public void onResponse(Call<CropInfoResponse> call, Response<CropInfoResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        try {
                            CropInfoResponse cropInfoResponse = response.body();
                            if (sharedPrefrenceUtil.getCropInfoID() == 0) {
                                sharedPrefrenceUtil.setCropInfoID(Integer.parseInt(cropInfoResponse.getinserted_id()));
                            }
                            if (context != null)
                                Toast.makeText(context, "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                        }

                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<CropInfoResponse> call, Throwable t) {
                gif1.setVisibility(View.GONE);
            }
        });

        
        
    }




    public  void GetCropInfo(){
        final   RelativeLayout gif1=view.findViewById(R.id.imgGif);
        gif1.setVisibility(View.VISIBLE);
        final String farmer_id;
        farmer_id=sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        GetCropInfoRequest cropInfoRequest=new GetCropInfoRequest(sharedPrefrenceUtil.getCropInfoID()+"",farmer_id)   ;

        Call<GetCropInfoResponse> call = mapiClinet.getCropInfoData(cropInfoRequest);
        call.enqueue(new Callback<GetCropInfoResponse>() {

            @Override
            public void onResponse(Call<GetCropInfoResponse> call, Response<GetCropInfoResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {

                        try {
                            GetCropInfoResponse getCropInfoResponse = response.body();
                            List<CropsInfo_1Crop> cropsInfo = getCropInfoResponse.getCropsInfo();
                            txtCropStatus.setText(cropsInfo.get(0).getCropStatus());
                            spinnerName.setText(cropsInfo.get(0).getCropName());
                            varietyname.setText(cropsInfo.get(0).getVarietyName());
                            etArea.setText(cropsInfo.get(0).getCropArea());
                            land_preparation_date.setText(cropsInfo.get(0).getLandPreparationDate());
                            dateofsowing.setText(cropsInfo.get(0).getShowingDate());
                            input_planting_date.setText(cropsInfo.get(0).getPlantingDate());
                            first_weeddate.setText(cropsInfo.get(0).getFstApplicationDate());
                            secondweeddate.setText(cropsInfo.get(0).getSndApplicationDate());
                            irrigation_type.setText(cropsInfo.get(0).getNoOfIrrigation());
                            firtdiseasedate.setText(cropsInfo.get(0).getFstPestapplicationDate());
                            secondapplicationsPest.setText(cropsInfo.get(0).getSndPestapplicationDate());
                            sharedPrefrenceUtil.setSubCropID(cropsInfo.get(0).getsub_crop_id());

//                            sharedPrefrenceUtil.setSubCropID(cropsInfo.get(0).getcr);

                            weed_notice.setText(cropsInfo.get(0).getWeedControl());

                            String virus=cropsInfo.get(0).getVirus();
                            String nematodes=cropsInfo.get(0).getNematodes();

                            if (virus.equals("1"))
                                chk_virus.setChecked(true);

                            if (nematodes.equals("1"))
                                chk_nemotodes.setChecked(true);


                            String pestObeseved=cropsInfo.get(0).getpest_observed();
                            pestObeseved = pestObeseved.replaceAll("\\[", "").replaceAll("\\]","");
                            pestObeseved = pestObeseved.replaceAll("\\s+","");
                            String diseaseObs=cropsInfo.get(0).getDiseasesObserved();
                            diseaseObs = diseaseObs.replaceAll("\\[", "").replaceAll("\\]","");
                            diseaseObs = diseaseObs.replaceAll("\\s+","");
                            String fertilizer=cropsInfo.get(0).getFertlizerName();
                            fertilizer = fertilizer.replaceAll("\\[", "").replaceAll("\\]","");
                            fertilizer = fertilizer.replaceAll("\\s+","");
                            String pestiside=cropsInfo.get(0).getPesticide();
                            pestiside = pestiside.replaceAll("\\[", "").replaceAll("\\]","");
                            pestiside = pestiside.replaceAll("\\s+","");

                            ArrayList<String> pestList = new ArrayList<String>(Arrays.asList(pestObeseved.split(",")));

                            for(int k=0;k<pestList.size();k++) {
                                String s=pestList.get(k);
                                if (!(pest + "").contains(s))
                                    pest.add(s);
                            }


                            ArrayList<String> diseaseList = new ArrayList<String>(Arrays.asList(diseaseObs.split(",")));
                            for(int k=0;k<diseaseList.size();k++) {
                                String s=diseaseList.get(k);
                                if (!(diseaseArray + "").contains(s))
                                diseaseArray.add(s);
                            }
                             ArrayList<String> fertilizerList = new ArrayList<String>(Arrays.asList(fertilizer.split(",")));
                            for(int k=0;k<fertilizerList.size();k++) {
                                String s=fertilizerList.get(k);
                                if (!(fertilizerArray + "").contains(s))
                                    fertilizerArray.add(s);
                            }
                             ArrayList<String> pestisidesList = new ArrayList<String>(Arrays.asList(pestiside.split(",")));
                            for(int k=0;k<pestisidesList.size();k++) {
                                String s=pestisidesList.get(k);
                                if (!(pestisides_array + "").contains(s)) {
                                    pestisides_array.add(s);
                                }
                            }

                            if (diseaseList.size()>0)
                                diseaseobserverd.setChecked(true);
                            if (pestList.size()>0)
                                pest_observed.setChecked(true);
                            if (fertilizerList.size()>0)
                                cbFertilizer.setChecked(true);
                            if (pestisidesList.size()>0)
                                cbpestisides.setChecked(true);
                        }catch(Exception e){}
                    }
                }
                gif1.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<GetCropInfoResponse> call, Throwable t) {
            gif1.setVisibility(View.GONE);
            }
        });




    }



    public void postFarmLabDataServer() {

        if (context != null) {

            SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(context);
            String id = sharedPrefrenceUtil.getResponseId();

            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            final RecommendCropRequest cropinformation = new RecommendCropRequest(id, npk_value);

            Call<RecommendCropResponse> call = mapiClinet.getRecommendData(cropinformation);
            call.enqueue(new Callback<RecommendCropResponse>() {

                @Override
                public void onResponse(Call<RecommendCropResponse> call, Response<RecommendCropResponse> response) {
                    if (response.body() != null) {
                        Boolean errCode = response.body().getStatus();

                        if (errCode.equals(true)) {

                            RecommendCropResponse recommendCropResponse = response.body();
                            List<SoilRecommended> mSoilRecommended = recommendCropResponse.getSoilRecommended();
//                        txtRecommend_calculator.setText(
//                                " NPK Value:   "+mSoilRecommended.get(0).getNpkValue()
//                        +"\n Recommended Combination: "+mSoilRecommended.get(0).getRecommendedCombination()
//                        +"\n Fym Ton:  "+mSoilRecommended.get(0).getFymTon()
//                        +"\n Bio Fertilizer: "+mSoilRecommended.get(0).getBioFertilizer()
//                        +" PROM:   "+mSoilRecommended.get(0).getPROM()
//                        +"\n Jivamrit:   "+mSoilRecommended.get(0).getJivamrit()
//                        +"\n Oil Cake:    "+mSoilRecommended.get(0).getOilCake()
//                        );

                            txtGreenManu.setText(mSoilRecommended.get(0).getGreenManuring());
                            txtFYM.setText(mSoilRecommended.get(0).getFymTon());
                            txtBioF.setText(mSoilRecommended.get(0).getBioFertilizer());
                            txtProm.setText(mSoilRecommended.get(0).getPROM());
                            txtJivamrit.setText(mSoilRecommended.get(0).getJivamrit());
                            txtOilCake.setText(mSoilRecommended.get(0).getOilCake());


//                            Toast.makeText(context, "Fertilize Calculator Data", Toast.LENGTH_LONG).show();

                            //list.setAdapter(customAdatorr
                            // Toast.makeText(
                            //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                            Log.e("response", "" + response.body());

                        } else {

//                            Toast.makeText(context, "Fertilize Calculator  Data not Found", Toast.LENGTH_LONG).show();
                            linearLayoutCalculator.setVisibility(View.GONE);
                        }

                    } else {
//                        Toast.makeText(context, "Fertilize Calculator  Data not Found", Toast.LENGTH_LONG).show();
                        linearLayoutCalculator.setVisibility(View.GONE);
                    }
                    //  showTaost(msg);

                }

                @Override
                public void onFailure(Call<RecommendCropResponse> call, Throwable t) {
                    //  progressDoalog.dismiss();
//                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }





void newDeclaration(){
    btnAddEdit=view.findViewById(R.id.btnAddEdit);
    llHeight=view.findViewById(R.id.llHeight);
    edHeight1=view.findViewById(R.id.edHeight1);
    edHeight2=view.findViewById(R.id.edHeight2);
    edHeight3=view.findViewById(R.id.edHeight3);
    edHeight4=view.findViewById(R.id.edHeight4);
    edHeight5=view.findViewById(R.id.edHeight5);


    btnAddPanicle=view.findViewById(R.id.btnAddPanicle);
    llPanicle=view.findViewById(R.id.llPanicle);
    edPanicle1=view.findViewById(R.id.edPanicle1);
    edPanicle2=view.findViewById(R.id.edPanicle2);
    edPanicle3=view.findViewById(R.id.edPanicle3);
    edPanicle4=view.findViewById(R.id.edPanicle4);
    edPanicle5=view.findViewById(R.id.edPanicle5);


    btnAddFruits=view.findViewById(R.id.btnAddFruits);
    llFruits=view.findViewById(R.id.llFruits);
    edFruits1=view.findViewById(R.id.edFruits1);
    edFruits2=view.findViewById(R.id.edFruits2);
    edFruits3=view.findViewById(R.id.edFruits3);
    edFruits4=view.findViewById(R.id.edFruits4);
    edFruits5=view.findViewById(R.id.edFruits5);



    btnAddTiller=view.findViewById(R.id.btnAddTiller);
    llTiller=view.findViewById(R.id.llTiller);
    edTiller1=view.findViewById(R.id.edTiller1);
    edTiller2=view.findViewById(R.id.edTiller2);
    edTiller3=view.findViewById(R.id.edTiller3);
    edTiller4=view.findViewById(R.id.edTiller4);
    edTiller5=view.findViewById(R.id.edTiller5);



    btnAddYield=view.findViewById(R.id.btnAddYield);
    llYeild=view.findViewById(R.id.llYeild);
    edYeild1=view.findViewById(R.id.edYeild1);
    edYeild2=view.findViewById(R.id.edYeild2);
    edYeild3=view.findViewById(R.id.edYeild3);
    edYeild4=view.findViewById(R.id.edYeild4);
    edYeild5=view.findViewById(R.id.edYeild5);

    btnAddWeight=view.findViewById(R.id.btnAddWeight);
    llWeight=view.findViewById(R.id.llWeight);
    edWeight1=view.findViewById(R.id.edWeight1);
    edWeight2=view.findViewById(R.id.edWeight2);
    edWeight3=view.findViewById(R.id.edWeight3);
    edWeight4=view.findViewById(R.id.edWeight4);
    edWeight5=view.findViewById(R.id.edWeight5);



    etArray = new ArrayList<>();
    etArrayPanicle = new ArrayList<>();
    etArrayYeild = new ArrayList<>();
    etArrayTiller = new ArrayList<>();
    etArrayWeight = new ArrayList<>();
    etArrayFruits = new ArrayList<>();

    btnAddEdit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                myEditText = new EditText(context); // Pass it an Activity or Context
//                String s=myEditText.getTag().toString();
//                myEditText.setId();

                etArray.add(etArray.size(), myEditText);
                if (etArray.size() == 0) {
                    etArray.get(0);
                    Config.toast(context, etArray.get(0) + "");
                } else {
//                    etArray.get(etArray.size());
                    Config.toast(context, etArray.size() + "");
                }
//                myEditText.setTag("myEditText"+"1");
                myEditText.setBackgroundResource(R.drawable.white_box);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                myEditText.setGravity(Gravity.CENTER);
                myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                int maxLength = 7;
                myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                myEditText.setSingleLine(true);
                llHeight.addView(myEditText);

            }
        }
    });


    btnminusEdit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                if (etArray.size()>0)
                    llHeight.removeView( etArray.remove(etArray.size()-1));
            }
        }
    });
 btnMinusFruits.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                if (etArrayFruits.size()>0)
                    llFruits.removeView( etArrayFruits.remove(etArrayFruits.size()-1));
            }
        }
    });
 btnMinusPanicle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                if (etArrayPanicle.size()>0)
                    llPanicle.removeView( etArrayPanicle.remove(etArrayPanicle.size()-1));
            }
        }
    });
btnMinusTiller.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                if (etArrayTiller.size()>0)
                    llTiller.removeView( etArrayTiller.remove(etArrayTiller.size()-1));
            }
        }
    });
btnMinusWeight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                if (etArrayWeight.size()>0)
                    llWeight.removeView( etArrayWeight.remove(etArrayWeight.size()-1));
            }
        }
    });
btnMinusYield.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                if (etArrayYeild.size()>0)
                    llYeild.removeView( etArrayYeild.remove(etArrayYeild.size()-1));
            }
        }
    });

    btnAddTiller.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                myEditText = new EditText(context); // Pass it an Activity or Context
//                String s=myEditText.getTag().toString();
//                myEditText.setId();

                etArrayTiller.add(etArrayTiller.size(), myEditText);
                if (etArrayTiller.size() == 0) {
                    etArrayTiller.get(0);
                    Config.toast(context, etArrayTiller.get(0) + "");
                } else {
//                    etArray.get(etArray.size());
                    Config.toast(context, etArrayTiller.size() + "");
                }
//                myEditText.setTag("myEditText"+"1");
                myEditText.setBackgroundResource(R.drawable.white_box);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                myEditText.setGravity(Gravity.CENTER);
                myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                myEditText.setSingleLine(true);
                int maxLength = 7;
                myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                llTiller.addView(myEditText);
            }
        }
    });

    btnAddFruits.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                myEditText = new EditText(context); // Pass it an Activity or Context
//                String s=myEditText.getTag().toString();
//                myEditText.setId();

                etArrayFruits.add(etArrayFruits.size(), myEditText);
                if (etArrayFruits.size() == 0) {
                    etArrayFruits.get(0);
                    Config.toast(context, etArrayFruits.get(0) + "");
                } else {
//                    etArray.get(etArray.size());
                    Config.toast(context, etArrayFruits.size() + "");
                }
//                myEditText.setTag("myEditText"+"1");
                myEditText.setBackgroundResource(R.drawable.white_box);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                myEditText.setGravity(Gravity.CENTER);
                myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                int maxLength = 7;
                myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                myEditText.setSingleLine(true);
                llFruits.addView(myEditText);
            }
        }
    });

    btnAddPanicle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                myEditText = new EditText(context); // Pass it an Activity or Context
//                String s=myEditText.getTag().toString();
//                myEditText.setId();

                etArrayPanicle.add(etArrayPanicle.size(), myEditText);
                if (etArrayPanicle.size() == 0) {
                    etArrayPanicle.get(0);
                    Config.toast(context, etArrayPanicle.get(0) + "");
                } else {
//                    etArray.get(etArray.size());
                    Config.toast(context, etArrayPanicle.size() + "");
                }
//                myEditText.setTag("myEditText"+"1");
                myEditText.setBackgroundResource(R.drawable.white_box);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                myEditText.setGravity(Gravity.CENTER);
                myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                int maxLength = 7;
                myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                myEditText.setSingleLine(true);
                llPanicle.addView(myEditText);
            }
        }
    });

    btnAddWeight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                myEditText = new EditText(context); // Pass it an Activity or Context
//                String s=myEditText.getTag().toString();
//                myEditText.setId();

                etArrayWeight.add(etArrayWeight.size(), myEditText);
                if (etArrayWeight.size() == 0) {
                    etArrayWeight.get(0);
                    Config.toast(context, etArrayWeight.get(0) + "");
                } else {
//                    etArray.get(etArray.size());
                    Config.toast(context, etArrayWeight.size() + "");
                }
//                myEditText.setTag("myEditText"+"1");
                myEditText.setBackgroundResource(R.drawable.white_box);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                myEditText.setGravity(Gravity.CENTER);
                int maxLength = 7;
                myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                myEditText.setSingleLine(true);
                llWeight.addView(myEditText);
            }
        }
    });

    btnAddYield.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (context != null) {
                myEditText = new EditText(context); // Pass it an Activity or Context
//                String s=myEditText.getTag().toString();
//                myEditText.setId();

                etArrayYeild.add(etArrayYeild.size(), myEditText);
                if (etArrayYeild.size() == 0) {
                    etArrayYeild.get(0);
                    Config.toast(context, etArrayYeild.get(0) + "");
                } else {
//                    etArray.get(etArray.size());
                    Config.toast(context, etArrayYeild.size() + "");
                }
//                myEditText.setTag("myEditText"+"1");
                myEditText.setBackgroundResource(R.drawable.white_box);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(75, ViewGroup.LayoutParams.WRAP_CONTENT);
//                layoutParams.
//                layoutParams.addRule(LinearLayout.ALIGN_RIGHT, textView.getId());

                myEditText.setLayoutParams(layoutParams); // Pass two args; must be LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, or an integer pixel value.
                myEditText.setGravity(Gravity.CENTER);
                int maxLength = 7;
                myEditText.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
                myEditText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_CLASS_NUMBER);
                myEditText.setSingleLine(true);
                llYeild.addView(myEditText);
            }
        }
    });



}

    @Override
    public void onDestroy() {
        OkHttpClient client =new OkHttpClient();
        client.dispatcher().cancelAll();
        super.onDestroy();
    }


    public void getMainCrop() {


        String id= sharedPrefrenceUtil.getResponseId();
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        SoilRequest cropinformation = new SoilRequest(id);


        Call<CropStatusListResponse> call = mapiClinet.getMainCrop(cropinformation);
        call.enqueue(new Callback<CropStatusListResponse>() {

            @Override
            public void onResponse(Call<CropStatusListResponse> call, Response<CropStatusListResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();

                    if (errCode.equals(true)) {
                        CropStatusListResponse labListResponse=response.body();
                        String s=labListResponse.getMessage();
                       labList=new ArrayList<>();
                        labList=labListResponse.getCropStatusList();



//                        Toast.makeText(context, "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();

                        //list.setAdapter(customAdatorr
                        // Toast.makeText(
                        //   BeatPlanActivity.this, "sucessss", Toast.LENGTH_SHORT).show();
//                        Log.e("response", "" + response.body());

                    } else {

//                        Toast.makeText(context, "Something Went Wrong....", Toast.LENGTH_LONG).show();
                    }

                } else {
//                    Toast.makeText(context, "Something Went Wrong....Try Again", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<CropStatusListResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
                if (context!=null)
                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void SaveOtherFertilizer() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        OthersFertilizerRequest machineryrequest = new OthersFertilizerRequest(id,edOthers.getText().toString());
        Call<OthersFertilizerResponse> call = mapiClinet.postOtherFertilizer(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added Fertilizer");
                        getFertilizer();
                    } else {
                    }

                } else {
                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<OthersFertilizerResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void SaveOtherPesticide() {
        ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
        OthersPestisidesRequest machineryrequest = new OthersPestisidesRequest(id,edOthers.getText().toString());
        Call<OthersFertilizerResponse> call = mapiClinet.postOtherPesticides(machineryrequest);
        call.enqueue(new Callback<OthersFertilizerResponse>() {
            @Override
            public void onResponse(Call<OthersFertilizerResponse> call, Response<OthersFertilizerResponse> response) {
                if (response.body() != null) {
                    Boolean errCode = response.body().getStatus();
                    if (errCode.equals(true)) {
                        Config.toast(context,"Successfully Added Pesticide");
                        getpestisides();
                    } else {
                    }

                } else {
                    // Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_LONG).show();
                }
                //  showTaost(msg);

            }

            @Override
            public void onFailure(Call<OthersFertilizerResponse> call, Throwable t) {
                //  progressDoalog.dismiss();
//                 Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
