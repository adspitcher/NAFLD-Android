package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class InnerFragment extends Fragment {

	private int innerposition;

	public InnerFragment(int position) {
		super();
		this.innerposition = position;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_inner, container, false);

		view.setFocusableInTouchMode(true);
		view.requestFocus();
		view.setOnKeyListener(new View.OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					getFragmentManager().popBackStack(null,
							FragmentManager.POP_BACK_STACK_INCLUSIVE);
					return true;
				} else {
					return false;
				}
			}
		});

		ListView listView_items = (ListView) view
				.findViewById(R.id.listview_inneritems);

		String[] items = null;

		switch (innerposition) {
		case Constants.INDEX_POSITION_PAPER: {
			items = view.getResources().getStringArray(
					R.array.naflds_positionpaper_array);
		}
			break;
		case Constants.INDEX_POSITION_DEFINITIONS: {
			items = view.getResources().getStringArray(
					R.array.naflds_definitions_array);
		}
			break;
		case Constants.INDEX_POSITION_PATHOGENESIS: {
			items = view.getResources().getStringArray(
					R.array.naflds_pathogenesis_array);
		}
			break;
		case Constants.INDEX_POSITION_DIAGNOSIS: {
			items = view.getResources().getStringArray(
					R.array.naflds_diagonosis_array);
		}
			break;
		case Constants.INDEX_POSITION_TREATMENT: {
			items = view.getResources().getStringArray(
					R.array.naflds_treatment_array);
		}
			break;
		case Constants.INDEX_POSITION_CONCLUSION: {
			items = view.getResources().getStringArray(
					R.array.naflds_definitions_array);
		}
			break;
		case Constants.INDEX_SOCIETIES_ARRAY: {
			items = view.getResources().getStringArray(R.array.socities_array);
		}
			break;
		}

		FragmentsListViewAdapter adapter = new FragmentsListViewAdapter(
				view.getContext(), R.layout.fragment_inner, items);
		listView_items.setAdapter(adapter);

		listView_items.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String index = "" + (innerposition + 1) + (position + 1);
				InnerDetailsFragment innerFragment = new InnerDetailsFragment(
						Integer.parseInt(index));
				FragmentTransaction transaction = getChildFragmentManager()
						.beginTransaction();

				// Replace whatever is in the fragment_container view with this
				// fragment,
				// and add the transaction to the back stack so the user can
				// navigate back
				transaction.replace(R.id.content_frame_inner, innerFragment);
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
