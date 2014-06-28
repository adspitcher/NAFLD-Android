package com.app.nafld.views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.nafld.R;
import com.app.nafld.utilities.DownloadImage;

public class AlgorithmActivity extends ActionBarActivity {
	
	int[] drawableID = {R.drawable.algorithm1, R.drawable.algorithm2};
	int position;
	ImageView img_algo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_algorithm);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			// get the parent view of home (app icon) imageview
			ViewGroup home = (ViewGroup) findViewById(android.R.id.home)
					.getParent();
			// get the first child (up imageview)
			((ImageView) home.getChildAt(0))
			// change the icon according to your needs
					.setImageDrawable(getResources().getDrawable(
							R.drawable.ic_action_content_remove));
		} else {
			// get the up imageview directly with R.id.up
			((ImageView) findViewById(R.id.up)).setImageDrawable(getResources()
					.getDrawable(R.drawable.ic_action_content_remove));
		}
		
		position = getIntent().getIntExtra("itemposition", 0);
		img_algo = (ImageView)findViewById(R.id.imageview_bigalgo);
		img_algo.setImageDrawable(getResources().getDrawable(drawableID[position]));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_algorithm, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_download:{
	        	img_algo.getDrawable();
	        	Bitmap icon = BitmapFactory.decodeResource(getResources(),
                        drawableID[position]);
	        	DownloadImage.saveImageToExternalStorage(this, "Algorithm"+position, icon);
	            return true;
	        }
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}