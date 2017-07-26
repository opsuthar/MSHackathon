package com.mshackathon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    //AppControlls gObject;
    EditText adhaarnumber;
    Button signupbtn;
    TextView signinbtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup_activity);
        //gObject=(AppControlls)getApplicationContext();
        signupbtn=(Button)findViewById(R.id.signupbtn);
        signinbtn1=(TextView)findViewById(R.id.signupview);
        signupbtn.setOnClickListener(this);
        signinbtn1.setOnClickListener(this);
        adhaarnumber=(EditText)findViewById(R.id.passtxt);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        moveTaskToBack(true);
    }
    public void oprnList(Fragment callFrag)
    {
        FragmentManager req_mnt=getFragmentManager();
        FragmentTransaction req_transion=req_mnt.beginTransaction();
        req_transion.replace(R.id.content_frame, callFrag);
        req_transion.commit();

    }

    @Override
    public void onClick(View v) {


        if(v.getId()==R.id.signupbtn)
        {
            new SignupUser(adhaarnumber.getText().toString().trim(),"C").execute();
        }
        else if(v.getId()==R.id.signupview)
        {
            Intent HomeActivity=new Intent(SignupActivity.this,LoginActivity.class);
            startActivity(HomeActivity);
            finish();
        }
    }

    /*
    Singup Async task
     */
    class SignupUser extends AsyncTask<String,String,String>
    {

        String req;
        ProgressDialog pd;
        String uAdhaar;
        String typeu;


        SignupUser(String umail,String utype)
        {
            uAdhaar=umail;
            typeu=utype;
        }



        @Override
        protected void onPreExecute() {
            pd=new ProgressDialog(SignupActivity.this);
            pd.setMessage("Please wait....");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {

            /*String cateUrl= AppControlls.baseURl+AppControlls.signupUrl+"user_email="+uMail+"&user_password="+uPass+"&user_firstname="+uName+"&user_address="+uAddress+"&type="+typeu+"&mobi="+uMob+"";
            try {
                req= CustomHttpClient.urlincoding(cateUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            try
            {
                pd.dismiss();
                JSONObject jObjetc = new JSONObject(s);
                JSONObject jsonObjectSub = jObjetc.getJSONObject("response");
                String flg = jsonObjectSub.getString("status");


                //	String flag=jObjetc.getString("status");
                if (flg.equals("1")) {
                    JSONArray jArrObject = jsonObjectSub.getJSONArray("result");
                    for (int i = 0; i < jArrObject.length(); i++) {
                        // item2 = new RowItems_Banner();
                        JSONObject jIndexObject = jArrObject.getJSONObject(i);

                        Intent HomeActivity=new Intent(SignupActivity.this,MainActivity.class);
                        startActivity(HomeActivity);
                        finish();
                    }

                }
                else
                {
                    Toast.makeText(SignupActivity.this,"User Already Register!!",Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }



}
