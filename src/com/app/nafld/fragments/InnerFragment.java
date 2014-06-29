package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.FragmentsListViewAdapter;
import com.app.nafld.constants.Constants;

public class InnerFragment extends Fragment {

	private int position;

	public InnerFragment(int position) {
		super();
		this.position = position;
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

		switch (position) {
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

		return view;
	}
}
