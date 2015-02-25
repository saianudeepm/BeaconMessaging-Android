package com.yahoo.beaconmessaging.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.yahoo.beaconmessaging.R;
import com.yahoo.beaconmessaging.util.LoginManager;

/**
 * Activity which displays a registration screen to the user.
 */
public class WelcomeActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);

    // Log in button click handler
    Button loginButton = (Button) findViewById(R.id.login_button);
    loginButton.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {
          if (LoginManager.isSavedLoginPresent())
          {
              final ProgressDialog dialog = new ProgressDialog(WelcomeActivity.this);
              dialog.setMessage(getString(R.string.progress_login));
              dialog.show();
              LoginActivity.loginWithUserAndPassword(LoginManager.getUser(), LoginManager.getPassword(), dialog, WelcomeActivity.this);
          }
          else {
              // Starts an intent of the log in activity
              startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
          }
      }
    });

    // Sign up button click handler
    Button signupButton = (Button) findViewById(R.id.signup_button);
    signupButton.setOnClickListener(new OnClickListener() {
      public void onClick(View v) {
        // Starts an intent for the sign up activity
        startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
      }
    });
  }
}
