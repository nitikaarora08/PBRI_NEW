package com.patanjali.pbri_new.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.patanjali.pbri_new.NetworkUtility;
import com.patanjali.pbri_new.R;
import com.patanjali.pbri_new.database.SharedPrefrenceUtil;

import com.patanjali.pbri_new.model.RequestGetFarmLab;
import com.patanjali.pbri_new.model.SoilRequest;
import com.patanjali.pbri_new.model1.CostBenifitGetResponse;
import com.patanjali.pbri_new.model1.GetDataRequest;
import com.patanjali.pbri_new.model1.GetDataResponse;
import com.patanjali.pbri_new.model1.PostCostRequest;
import com.patanjali.pbri_new.model1.PostCostResponse;
import com.patanjali.pbri_new.network.ApiInterface;
import com.patanjali.pbri_new.network.RetrofitClientInstance;

import java.text.DecimalFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CostBenefits#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CostBenefits extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ProgressDialog mprogressDialog;

    float landpreparation;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button save_farmerdetails;
    private OnFragmentInteractionListener mListener;

    public CostBenefits() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CostBenefits.
     */
    // TODO: Rename and change types and number of parameters
    public static CostBenefits newInstance(String param1, String param2) {
        CostBenefits fragment = new CostBenefits();
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

    View view;
    public static LinearLayout expenses,income,income1;
   public static RelativeLayout expenses1;
//    RelativeLayout ;

    EditText Planting,totalcost,otherexpenses,Landpreparation,Seed,Fertilizer,
            pestisides,Weeding,Irrigation,HarvestingThresing,
            winnoing,Packing,tranportation,amount,discrip,TotalProducemaincrop,
            TotalProduceverticalcrop,TotalCostExpenditure,
            Marketvaluemaincrop,marketvalueverticalcrop,
            Incomefarmlab,CostBenefitratio;

    EditText b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView txtProfitLoss,txtResult;
    SharedPrefrenceUtil sharedPrefrenceUtil;
Button btnCancelCostBenefit,btnOkCostBenefit,btnBack,btnBackToHome,saveCostBenifit;

    double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=  inflater.inflate(R.layout.fragment_cost_benefits, container, false);
         sharedPrefrenceUtil = new SharedPrefrenceUtil(getActivity().getApplicationContext());

        declaration();
        onBtnClick();

//        SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
//        if (!sharedPrefrenceUtil.getCostStatus()) {
            getDataInCaseOfUninstall();
//        }
//        else {
//
//        }


//        getOfflineData();
        getTextWatcherForAllField();

        b7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!b7.getText().toString().equals("")) {
                    try {
                        double x =  (Double.parseDouble(b7.getText().toString()) +
                                Double.parseDouble(b8.getText().toString()) + Double.parseDouble(b9.getText().toString())
                                -Double.parseDouble(totalcost.getText().toString()));
                        x=roundTwoDecimals(x);
                        txtProfitLoss.setText(x + "");
                        if (x<0)
                            txtResult.setText(getResources().getString(R.string.loss)+x+getResources().getString(R.string.rupees));
                        else
                            txtResult.setText(getResources().getString(R.string.profit)+x+getResources().getString(R.string.rupees));

                    }catch (Exception e){}  }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
         b8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!b8.getText().toString().equals("")) {
                    try {
                        double x =  (Double.parseDouble(b7.getText().toString()) +
                                Double.parseDouble(b8.getText().toString()) + Double.parseDouble(b9.getText().toString())
                                -Double.parseDouble(totalcost.getText().toString()));

                        x=roundTwoDecimals(x);
                        txtProfitLoss.setText(x + "");
                        if (x<0)
                            txtResult.setText(getResources().getString(R.string.loss)+x+getResources().getString(R.string.rupees));
                        else
                            txtResult.setText(getResources().getString(R.string.profit)+x+getResources().getString(R.string.rupees));


                    }catch (Exception e){}  }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
         b9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                   }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!b9.getText().toString().equals("")) {
                    try {
                        double x =  (Double.parseDouble(b7.getText().toString()) +
                                Double.parseDouble(b8.getText().toString()) + Double.parseDouble(b9.getText().toString())
                                -Double.parseDouble(totalcost.getText().toString()));
                        x=roundTwoDecimals(x);
                        txtProfitLoss.setText(x + "");
                        if (x<0)
                            txtResult.setText(getResources().getString(R.string.loss)+x+getResources().getString(R.string.rupees));
                        else
                            txtResult.setText(getResources().getString(R.string.profit)+x+getResources().getString(R.string.rupees));


                    }catch (Exception e){}    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
 totalcost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                 }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!totalcost.getText().toString().equals("")) {
                    try {
                        double x =  (Double.parseDouble(b7.getText().toString()) +
                                Double.parseDouble(b8.getText().toString()) + Double.parseDouble(b9.getText().toString())
                                -Double.parseDouble(totalcost.getText().toString()));
                        x=roundTwoDecimals(x);
                        txtProfitLoss.setText(x + "");
                        if (x<0)
                            txtResult.setText(getResources().getString(R.string.loss)+x+getResources().getString(R.string.rupees));
                        else
                            txtResult.setText(getResources().getString(R.string.profit)+x+getResources().getString(R.string.rupees));


                    }catch (Exception e){}      }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        try {
            double x =  (Double.parseDouble(b7.getText().toString()) +
                    Double.parseDouble(b8.getText().toString()) + Double.parseDouble(b9.getText().toString())
                    -Double.parseDouble(totalcost.getText().toString()));
            x=roundTwoDecimals(x);
            txtProfitLoss.setText(x + "");
            if (x<0)
                txtResult.setText(getResources().getString(R.string.loss)+x+getResources().getString(R.string.rupees));
            else
                txtResult.setText(getResources().getString(R.string.profit)+x+getResources().getString(R.string.rupees));
        }catch (Exception e){}


        return  view;

    }

    public  void getOfflineData()
    {
        SharedPrefrenceUtil sharedPrefrenceUtil = new SharedPrefrenceUtil(getContext());
        if (sharedPrefrenceUtil.getLandpreparation()!=null)
        {
            Landpreparation.setText(sharedPrefrenceUtil.getLandpreparation());
        }

        if (sharedPrefrenceUtil.getSeed()!=null)
        {

            Seed.setText(sharedPrefrenceUtil.getSeed());

        }

        if (sharedPrefrenceUtil.getFertilizer() !=null && (!sharedPrefrenceUtil.getFertilizer().isEmpty()))
        {

            Fertilizer.setText(sharedPrefrenceUtil.getFertilizer());

        }

        if (sharedPrefrenceUtil.getpestisides()!=null)
        {
            pestisides.setText(sharedPrefrenceUtil.getpestisides());
        }

        if (sharedPrefrenceUtil.getPlanting()!=null)
        {
            Planting.setText(sharedPrefrenceUtil.getPlanting());

        }

        if (sharedPrefrenceUtil.getWeeding()!=null)

        {
            Weeding.setText(sharedPrefrenceUtil.getWeeding());

        }

        if (sharedPrefrenceUtil.getIrrigation()!=null)
        {

            Irrigation.setText(sharedPrefrenceUtil.getIrrigation());

        }

        if (sharedPrefrenceUtil.getHarvestingThresing()!=null)
        {
            HarvestingThresing.setText(sharedPrefrenceUtil.getHarvestingThresing());

        }

        if (sharedPrefrenceUtil.getwinnoing()!=null)
        {
            winnoing.setText(sharedPrefrenceUtil.getwinnoing());

        }
        if (sharedPrefrenceUtil.getPacking()!=null)
        {
            Packing.setText(sharedPrefrenceUtil.getPacking());

        }
        if (sharedPrefrenceUtil.gettranportation()!=null)
        {
            tranportation.setText(sharedPrefrenceUtil.gettranportation());

        }

        if (sharedPrefrenceUtil.getotherexpense()!=null)
        {
            otherexpenses.setText(sharedPrefrenceUtil.getotherexpense());

        }

        if (sharedPrefrenceUtil.getTotalCostExpenditure()!=null)
        {
            totalcost.setText(sharedPrefrenceUtil.getTotalCostExpenditure());
        }

        if (sharedPrefrenceUtil.getb1()!=null)
        {
            b1.setText(sharedPrefrenceUtil.getb1());
        }

        if (sharedPrefrenceUtil.getb2()!=null)
        {
            b2.setText(sharedPrefrenceUtil.getb2());
        }

        if (sharedPrefrenceUtil.getb3()!=null)
        {
            b3.setText(sharedPrefrenceUtil.getb3());
        }
        if (sharedPrefrenceUtil.getb4()!=null)
        {
            b4.setText(sharedPrefrenceUtil.getb4());
        }

        if (sharedPrefrenceUtil.getb4()!=null)
        {
            b5.setText(sharedPrefrenceUtil.getb5());
        }
        if (sharedPrefrenceUtil.getb6()!=null)
        {
            b6.setText(sharedPrefrenceUtil.getb6());
        }
        if (sharedPrefrenceUtil.getb7()!=null)
        {
            b7.setText(sharedPrefrenceUtil.getb7());
        }
        if (sharedPrefrenceUtil.getb8()!=null)
        {
            b8.setText(sharedPrefrenceUtil.getb8());
        }
        if (sharedPrefrenceUtil.getb9()!=null)
        {
            b9.setText(sharedPrefrenceUtil.getb9());
        }

    }

    private void onBtnClick() {

        save_farmerdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostAllDeatailsToServer();
            }
        });

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income1.setVisibility((income1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);
            }
        });


        expenses.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                expenses1.setVisibility((expenses1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });
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

    public void declaration(){

        save_farmerdetails=view.findViewById(R.id.save_farmerdetails);
        Planting=view.findViewById(R.id.Planting);
        expenses=view.findViewById(R.id.expenses);
        expenses1=view.findViewById(R.id.expenses1);
        income=view.findViewById(R.id.income);
        income1=view.findViewById(R.id.income1);
        totalcost=view.findViewById(R.id.totalcost);
        otherexpenses=view.findViewById(R.id.otherexpenses);
        Landpreparation=view.findViewById(R.id.Landpreparation);
        Seed=view.findViewById(R.id.Seed);
        Fertilizer=view.findViewById(R.id.Fertilizer);
        pestisides=view.findViewById(R.id.pestisides);
        Weeding=view.findViewById(R.id.Weeding);
        Irrigation=view.findViewById(R.id.Irrigation);
        HarvestingThresing=view.findViewById(R.id.HarvestingThresing);
        winnoing=view.findViewById(R.id.winnoing);
        Packing=view.findViewById(R.id.Packing);
        tranportation=view.findViewById(R.id.tranportation);
        b1=view.findViewById(R.id.b1);
        b2=view.findViewById(R.id.b2);
        b3=view.findViewById(R.id.b3);
        b4=view.findViewById(R.id.b4);
        b5=view.findViewById(R.id.b5);
        b6=view.findViewById(R.id.b6);
        b7=view.findViewById(R.id.b7);
        b8=view.findViewById(R.id.b8);
        b9=view.findViewById(R.id.b9);
        btnCancelCostBenefit=view.findViewById(R.id.btnCancelCostBenefit);
        btnOkCostBenefit=view.findViewById(R.id.btnOkCostBenefit);
        btnBack=view.findViewById(R.id.btnBack);
        btnBackToHome=view.findViewById(R.id.btnBackToHome);
        saveCostBenifit=view.findViewById(R.id.saveCostBenifit);
        txtProfitLoss=view.findViewById(R.id.txtProfitLoss);
        txtResult=view.findViewById(R.id.txtResult);

        btnCancelCostBenefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income1.setVisibility(View.GONE);
            }
        });
        btnOkCostBenefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                income1.setVisibility(View.GONE);
            }
        });

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenses1.setVisibility(View.GONE);
            }
        });
        saveCostBenifit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenses1.setVisibility(View.GONE);
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f4 = getFragmentManager().findFragmentById(R.id.container4);
                if (f4 instanceof CostBenefits) {
                    getFragmentManager().beginTransaction().remove(f4).commit();
                }
            }
        });
    }

    public  void getTextWatcherForAllField()
    {
        Landpreparation.addTextChangedListener(costTextwatcher);
        Seed.addTextChangedListener(costTextwatcher);
        Fertilizer.addTextChangedListener(costTextwatcher);
        pestisides.addTextChangedListener(costTextwatcher);
        Planting.addTextChangedListener(costTextwatcher);
        Weeding.addTextChangedListener(costTextwatcher);
        Irrigation.addTextChangedListener(costTextwatcher);
        HarvestingThresing.addTextChangedListener(costTextwatcher);
        winnoing.addTextChangedListener(costTextwatcher);
        Packing.addTextChangedListener(costTextwatcher);
        tranportation.addTextChangedListener(costTextwatcher);
        otherexpenses.addTextChangedListener(costTextwatcher);
        b1.addTextChangedListener(costTextwatcher);
        b2.addTextChangedListener(costTextwatcher);
        b3.addTextChangedListener(costTextwatcher);
        b4.addTextChangedListener(costTextwatcher);
        b5.addTextChangedListener(costTextwatcher);
        b6.addTextChangedListener(costTextwatcher);
//        b7.addTextChangedListener(costTextwatcher);
//        b8.addTextChangedListener(costTextwatcher);
//        b9.addTextChangedListener(costTextwatcher);

        // totalcost.addTextChangedListener(costTextwatcher);
    }

    TextWatcher costTextwatcher=new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {

            if (getActivity()!=null) {

                sharedPrefrenceUtil.setLandpreparation(Landpreparation.getText().toString());
                sharedPrefrenceUtil.setSeed(Seed.getText().toString());
                sharedPrefrenceUtil.setFertilizer(Fertilizer.getText().toString());
                sharedPrefrenceUtil.setpestisides(pestisides.getText().toString());
                sharedPrefrenceUtil.setPlanting(Planting.getText().toString());
                sharedPrefrenceUtil.setWeeding(Weeding.getText().toString());
                sharedPrefrenceUtil.setIrrigation(Irrigation.getText().toString());
                sharedPrefrenceUtil.setHarvestingThresing(HarvestingThresing.getText().toString());
                sharedPrefrenceUtil.setwinnoing(winnoing.getText().toString());
                sharedPrefrenceUtil.setPacking(Packing.getText().toString());
                sharedPrefrenceUtil.settranportation(tranportation.getText().toString());
                sharedPrefrenceUtil.setotherexpense(otherexpenses.getText().toString());
                sharedPrefrenceUtil.setTotalCostExpenditure(totalcost.getText().toString());
                sharedPrefrenceUtil.setb1(b1.getText().toString());
                sharedPrefrenceUtil.setb2(b2.getText().toString());
                sharedPrefrenceUtil.setb3(b3.getText().toString());
                sharedPrefrenceUtil.setb4(b4.getText().toString());
                sharedPrefrenceUtil.setb5(b5.getText().toString());
                sharedPrefrenceUtil.setb6(b6.getText().toString());
                sharedPrefrenceUtil.setb7(b7.getText().toString());
                sharedPrefrenceUtil.setb8(b8.getText().toString());
                sharedPrefrenceUtil.setb9(b9.getText().toString());

                landpreparation = 0;

                if (!Landpreparation.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(Landpreparation.getText().toString());
                }

                if (!Seed.getText().toString().isEmpty()) {

                    landpreparation = landpreparation + Float.parseFloat(Seed.getText().toString());

                }

                if (!Fertilizer.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(Fertilizer.getText().toString());
                }

                if (!pestisides.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(pestisides.getText().toString());
                }


                if (!Planting.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(Planting.getText().toString());
                }

                if (!Weeding.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(Weeding.getText().toString());
                }

                if (!Irrigation.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(Irrigation.getText().toString());
                }

                if (!HarvestingThresing.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(HarvestingThresing.getText().toString());
                }

                if (!winnoing.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(winnoing.getText().toString());
                }

                if (!Packing.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(Packing.getText().toString());
                }

                if (!tranportation.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(tranportation.getText().toString());
                }

                if (!otherexpenses.getText().toString().isEmpty()) {
                    landpreparation = landpreparation + Float.parseFloat(otherexpenses.getText().toString());
                }

                totalcost.setText(landpreparation + "");
                sharedPrefrenceUtil.setTotalCostExpenditure(totalcost.getText().toString());
            }
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
        }

        @Override
        public void afterTextChanged(Editable arg0) {

            //Toast.makeText(getApplicationContext(), "aaaaaaaaa", Toast.LENGTH_SHORT).show();
        }
    };

    public void PostAllDeatailsToServer() {
        {
            if (NetworkUtility.isNetworkAvailable(getContext())) {
                /* if (!lat.equals("0.0") && !longi.equals("0.0")) {*/
                showLoadingDialog(getContext());
                PostCostRequest loginRequestt = new PostCostRequest(sharedPrefrenceUtil.getFarmLabID(),sharedPrefrenceUtil.getResponseId(), Fertilizer.getText().toString(),HarvestingThresing.getText().toString(),Irrigation.getText().toString(),Landpreparation.getText().toString(),b7.getText().toString(),b4.getText().toString(),b1.getText().toString(),otherexpenses.getText().toString(),b9.getText().toString(),b6.getText().toString(),b3.getText().toString()
                        ,Packing.getText().toString(),pestisides.getText().toString(),Planting.getText().toString(),Seed.getText().toString(),b8.getText().toString(),b5.getText().toString(),b2.getText().toString(),tranportation.getText().toString(),Weeding.getText().toString(),winnoing.getText().toString());
                ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
                mapiClinet.postcostdata(loginRequestt).enqueue(new Callback<PostCostResponse>() {

                    @Override
                    public void onResponse(Call<PostCostResponse> call, Response<PostCostResponse> response) {
                        hideLoading();
                        if (response.body() != null) {

                            Boolean value = response.body().getStatus();
                            if (value.equals(true)) {
                                //everthing is ok
                                if (getActivity()!=null)
                                    Toast.makeText(getActivity(), "Successfully Data Syc to Server", Toast.LENGTH_LONG).show();
                            } else {
//                                Toast.makeText(getActivity(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                                //showTaost(msg);
                            }

                        } else {
//                            Toast.makeText(getContext(), "Something Went Wrong....Please Try Again", Toast.LENGTH_LONG).show();
                        }
                        //  showTaost(msg);
                    }

                    @Override
                    public void onFailure(Call<PostCostResponse> call, Throwable t) {
                        final String err = "Something went wrong please try again";
                        hideLoading();
                        showMessage(err);
                    }
                });
               /* } else

                showMessage("Please Wait While we are Fetching your Location and Try Again!!");*/
            } else
                showMessage("Please Check Your Internet Connection");


        }
    }

    public void getDataInCaseOfUninstall()
    {
        final   RelativeLayout gif1=view.findViewById(R.id.imgGif);

        {
            if (getActivity()!=null) {
                if (NetworkUtility.isNetworkAvailable(getContext())) {
                    /* if (!lat.equals("0.0") && !longi.equals("0.0")) {*/
                    final String err = "Something went wrong please try again";
                    RequestGetFarmLab loginRequestt = new RequestGetFarmLab(sharedPrefrenceUtil.getResponseId(),sharedPrefrenceUtil.getFarmLabID());
                    ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
                    mapiClinet.getcostdata(loginRequestt).enqueue(new Callback<CostBenifitGetResponse>() {

                        @Override
                        public void onResponse(Call<CostBenifitGetResponse> call, Response<CostBenifitGetResponse> response) {

                            if (response.body() != null) {


                                Boolean value = response.body().getStatus();
                                if (value.equals(true)) {
//                                    showMessage("uplaoded Data Successfully");
                                    sharedPrefrenceUtil.setCostStatus(true);
                                    Landpreparation.setText(response.body().getCostList().get(0).getLandPreparation());
                                    Seed.setText(response.body().getCostList().get(0).getSeed());
                                    Fertilizer.setText(response.body().getCostList().get(0).getFertilizer());
                                    pestisides.setText(response.body().getCostList().get(0).getPesticides());
                                    Planting.setText(response.body().getCostList().get(0).getPlanting());
                                    Weeding.setText(response.body().getCostList().get(0).getWeeding());
                                    Irrigation.setText(response.body().getCostList().get(0).getIrrigation());
                                    HarvestingThresing.setText(response.body().getCostList().get(0).getHarvestingAndThreshing());
                                    winnoing.setText(response.body().getCostList().get(0).getWinnowing());
                                    Packing.setText(response.body().getCostList().get(0).getPacking());
                                    tranportation.setText(response.body().getCostList().get(0).getTransportation());
                                    otherexpenses.setText(response.body().getCostList().get(0).getOtherExpenses());
                                    totalcost.setText(response.body().getCostList().get(0).getTotalCost());
                                    b1.setText(response.body().getCostList().get(0).getMainCropProduction());
                                    b2.setText(response.body().getCostList().get(0).getSubCropProduction());
                                    b3.setText(response.body().getCostList().get(0).getOtherProduction());
                                    b4.setText(response.body().getCostList().get(0).getMainCropMarketing());
                                    b5.setText(response.body().getCostList().get(0).getSubCropMarketing());
                                    b6.setText(response.body().getCostList().get(0).getOtherMarketing());
                                    b7.setText(response.body().getCostList().get(0).getMainCropMarketValue());
                                    b8.setText(response.body().getCostList().get(0).getSubCropMarketValue());
                                    b9.setText(response.body().getCostList().get(0).getOtherMarketValue());


                                }

                            }
                            gif1.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<CostBenifitGetResponse> call, Throwable t) {
                            gif1.setVisibility(View.GONE);
                        }
                    });

                } else
                    showMessage("Please Check Your Internet Connection");

            }
        }



    }
        public void showLoadingDialog (Context context){
            if (context!=null){
                mprogressDialog = new ProgressDialog(context);
            mprogressDialog.show();
            if (mprogressDialog.getWindow() != null) {
                mprogressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            mprogressDialog.setContentView(R.layout.progress_layout);
            mprogressDialog.setIndeterminate(true);
            mprogressDialog.setCancelable(false);
            mprogressDialog.setCanceledOnTouchOutside(false);
        }
}

        public void hideLoading () {
            if (mprogressDialog != null && mprogressDialog.isShowing()) {
                mprogressDialog.cancel();

            }
        }
    public void showMessage(String msg) {
          if (getActivity()!=null) Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        }


    }
