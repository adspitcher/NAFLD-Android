package com.app.nafld.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.FragmentsListViewAdapter;
import com.app.nafld.constants.Constants;

public class InformationFragment extends Fragment{
	
	private onItemClickListener activityCallback;

	public interface onItemClickListener{
		public void onItemClicked(View view, int position);
	}
	
	@Override
	public void onAttach(Activity activity) {
		 super.onAttach(activity);
	        try {
	        	activityCallback = (onItemClickListener) activity;
	        } catch (ClassCastException e) {
	            throw new ClassCastException(activity.toString()
	                    + " must implement onItemClickListener");
	        }
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_information, container, false);
		
		view.setFocusableInTouchMode(true);
		view.requestFocus();
		view.setOnKeyListener(new View.OnKeyListener() {
		        @Override
		        public boolean onKey(View v, int keyCode, KeyEvent event) {
		            if( keyCode == KeyEvent.KEYCODE_BACK ) {
		                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		                return true;
		            } else {
		                return false;
		            }
		        }
		    });

		ListView listView_information_items = (ListView)view.findViewById(R.id.listview_information);

		String[] infoItems = view.getResources().getStringArray(R.array.informations_array);
		FragmentsListViewAdapter adapter = new FragmentsListViewAdapter(view.getContext(), R.layout.fragment_information, infoItems);
		listView_information_items.setAdapter(adapter);

		listView_information_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				Log.d("ListItem Clicked==", ">>>>>"+position);
				switch(position){
				case Constants.INDEX_COPYRIGHT:
					break;
				case Constants.INDEX_AUTHORS:{
					//activityCallback.onItemClicked(view, position);
					AuthorsFragment authorsFragment = new AuthorsFragment();
					FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

					// Replace whatever is in the fragment_container view with this fragment,
					// and add the transaction to the back stack so the user can navigate back
					transaction.replace(R.id.content_frame, authorsFragment);
					transaction.addToBackStack(null);
					transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

					// Commit the transaction
					transaction.commit();
				}
					break;
				case Constants.INDEX_SOCIETIES:
					break;
				}
			}
		});

		return view;
	}
	

}