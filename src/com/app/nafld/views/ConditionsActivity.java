package com.app.nafld.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.app.nafld.R;

public class ConditionsActivity extends ActionBarActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conditions);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_conditions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_accept:{
	        	Intent screenChangeIntent = null;
				screenChangeIntent = new Intent(ConditionsActivity.this,
						HomeActivity.class);
				ConditionsActivity.this.startActivity(screenChangeIntent);
	            return true;
	        }
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
