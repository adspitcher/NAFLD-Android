package com.app.nafld.views;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.app.nafld.R;

public class LoginActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		
		EditText password = (EditText) findViewById(R.id.edittext_password);
		password.setTypeface(Typeface.SERIF);
		password.setTransformationMethod(new PasswordTransformationMethod());
		
		Button btn_signin = (Button) findViewById(R.id.btn_login);
		btn_signin.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(LoginActivity.this,
						ConditionsActivity.class);
				LoginActivity.this.startActivity(screenChangeIntent);
				LoginActivity.this.finish();
			}
		});
	}

}