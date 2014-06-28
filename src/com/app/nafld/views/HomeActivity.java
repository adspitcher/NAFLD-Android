package com.app.nafld.views;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.app.nafld.R;
import com.app.nafld.adapters.TabsPagerAdapter;
import com.app.nafld.constants.Constants;
import com.app.nafld.fragments.AlgorithmsFragment.onAlgorithmClickListener;
import com.app.nafld.fragments.AuthorsFragment;
import com.app.nafld.fragments.InformationFragment.onItemClickListener;

public class HomeActivity extends ActionBarActivity implements TabListener, onItemClickListener, onAlgorithmClickListener{
	
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getSupportActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);   

		Resources itemTexts = getResources();
		String[] tabs = itemTexts.getStringArray(R.array.tabs_array);

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClicked(View view, int position) {
		switch(position){
		case Constants.INDEX_AUTHORS:{
			AuthorsFragment authorsFragment = new AuthorsFragment();
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

			// Replace whatever is in the fragment_container view with this fragment,
			// and add the transaction to the back stack so the user can navigate back
			transaction.replace(R.id.pager, authorsFragment);
			transaction.addToBackStack(null);
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

			// Commit the transaction
			transaction.commit();
		}
		break;
		}
	}

	@Override
	public void onAlgoClicked(View view, int position) {
		Intent screenChangeIntent = null;
		screenChangeIntent = new Intent(HomeActivity.this,
				AlgorithmActivity.class);
		screenChangeIntent.putExtra("itemposition", position);
		HomeActivity.this.startActivity(screenChangeIntent);
	}

}
