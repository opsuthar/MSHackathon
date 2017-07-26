package com.mshackathon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText passtxt;
    Button loginBtn;
    AlertDialogManager alert = new AlertDialogManager();

    DBManager dbManager;

    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);
        session = new SessionManagement(getApplicationContext());

        dbManager = new DBManager(getApplicationContext());

        passtxt=(EditText)findViewById(R.id.passtxt);

        loginBtn=(Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);


    /*    if(session.isLoggedIn())
        {
            Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

            HashMap<String, String> user = session.getUserDetails();

            // name
            String adhaar = user.get(SessionManagement.KEY_NAME);

            session.createLoginSession(adhaar);
        } */

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        moveTaskToBack(true);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.loginBtn)
        {
            String passtem = passtxt.getText().toString().trim();

            AadharTable aadharTable = new AadharTable();

            long aadharNo = Long.parseLong(passtem);

            UserInfo userInfo = aadharTable.Authenticate(aadharNo);

            if(userInfo == null) {
                Toast.makeText(getApplicationContext(), "Login unsuccessful, try again ", Toast.LENGTH_LONG).show();
                passtxt.setText("");
                return;
            }

            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();


            Intent HomeActivity =new Intent(LoginActivity.this,ContentActivity.class);
            startActivity(HomeActivity);
            finish();

         //  session.createLoginSession(passtem);

        }
        else if(v.getId()==R.id.login2)
        {
            Intent HomeActivity=new Intent(LoginActivity.this,SignupActivity.class);
            startActivity(HomeActivity);
            finish();
        }
    }
}
