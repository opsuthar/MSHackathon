package com.mshackathon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity {

    // This class manages sesion of the app.
    SessionManagement session;
    //AppControlls gObject;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      //  getActionBar().hide();
        setContentView(R.layout.splash_activity);
        session = new SessionManagement(getApplicationContext());
        //gObject=(AppControlls)getApplicationContext();

                    if(session.isLoggedIn())
                    {

                        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
                        // session.checkLogin();
                        // get user data from session
                        HashMap<String, String> user = session.getUserDetails();

                        // name
                        String name = user.get(SessionManagement.KEY_NAME);

                        new LoginUser(name).execute();
                    }
                    else {

                        Thread spl=new Thread(){
                            public void run() {
                                try{
                                    sleep(3000);

                        Intent indexscreen = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(indexscreen);
                        finish();
                    }
                    catch(Exception e)
                    {

                    }

                };
            };
            spl.start();
                    }


    }


    public void oprnList(Fragment callFrag)
    {
        FragmentManager req_mnt=getFragmentManager();
        FragmentTransaction req_transion=req_mnt.beginTransaction();
        req_transion.replace(R.id.content_frame, callFrag);
        req_transion.commit();

    }
    /**
     * Login User
     */
    class LoginUser extends AsyncTask<String,String,String>
    {

        String req;
        ProgressDialog pd;
        String userAdhaar;
        LoginUser(String user)
        {
            userAdhaar=user;
        }
        @Override
        protected void onPreExecute() {
           /* pd=new ProgressDialog(SplashActivity.this);
            pd.setMessage("Please wait....");
            pd.show();*/
        }

        @Override
        protected String doInBackground(String... params) {

            /*String cateUrl= AppControlls.baseURl+AppControlls.loginurl+"email="+userMail+"&password="+userPass+"";
            try {
                req= CustomHttpClient.executeHttpGet(cateUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            try
            {
             //   pd.dismiss();
                JSONObject jObjetc = new JSONObject(s);
                JSONObject jsonObjectSub = jObjetc.getJSONObject("response");
                String flg = jsonObjectSub.getString("status");


                //	String flag=jObjetc.getString("status");
                if (flg.equals("1")) {
                    JSONArray jArrObject = jsonObjectSub.getJSONArray("result");
                    JSONObject jIndexObject = jArrObject.getJSONObject(0);

                    session.createLoginSession(userAdhaar);
                    Intent HomeActivity=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(HomeActivity);
                    finish();
                }
                else
                {
                    alert.showAlertDialog(SplashActivity.this, "Login failed..", "Username/Password is incorrect", false);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
