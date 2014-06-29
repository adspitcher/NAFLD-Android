package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.app.nafld.R;
import com.app.nafld.adapters.FragmentsListViewAdapter;
import com.app.nafld.constants.Constants;

public class DrugsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_drugs, container, false);

		ListView listView_drugs_items = (ListView) view
				.findViewById(R.id.listview_drugs_mainitems);

		String[] drugsItems = view.getResources().getStringArray(
				R.array.drugs_array);
		FragmentsListViewAdapter adapter = new FragmentsListViewAdapter(
				view.getContext(), R.layout.fragment_drugs, drugsItems);
		listView_drugs_items.setAdapter(adapter);

		listView_drugs_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long arg3) {

				InnerDetailsFragment innerFragment = new InnerDetailsFragment(
						position);
				FragmentTransaction transaction = getChildFragmentManager()
						.beginTransaction();

				// Replace whatever is in the fragment_container view with this
				// fragment,
				// and add the transaction to the back stack so the user can
				// navigate back
				transaction.replace(R.id.content_frame_drugs, innerFragment);
				transaction.addToBackStack(null);
				transaction
						.setTransition(FragmentTransaction.TRANSIT_ENTER_MASK);

				// Commit the transaction
				transaction.commit();
			}
		});

		return view;
	}

}