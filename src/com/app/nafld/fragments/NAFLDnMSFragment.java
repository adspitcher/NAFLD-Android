package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.FragmentsListViewAdapter;

public class NAFLDnMSFragment extends Fragment{

	private ListView listView_nafld_items;
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_nafld, container, false);

		listView_nafld_items = (ListView)view.findViewById(R.id.listview_nafld_mainitems);

		String[] nafldItems = view.getResources().getStringArray(R.array.naflds_array);
		FragmentsListViewAdapter adapter = new FragmentsListViewAdapter(view.getContext(), R.layout.fragment_nafld, nafldItems);
		listView_nafld_items.setAdapter(adapter);

		listView_nafld_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				Log.d("ListItem Clicked==", ">>>>>"+position);
				InnerFragment innerFragment = new InnerFragment(position);
				FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack so the user can navigate back
				transaction.replace(R.id.content_frame_nafld, innerFragment);
				transaction.addToBackStack(null);
				transaction.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);

				// Commit the transaction
				transaction.commit();
			}
		});

		return view;
	}
}