package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.nafld.R;
import com.app.nafld.constants.Constants;

public class InnerDetailsFragment extends Fragment {

	private int detailsID;

	public InnerDetailsFragment(int detailsID) {
		super();
		this.detailsID = detailsID;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_details, container,
				false);

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

		String detailsText = "";
		switch (detailsID) {
		case Constants.INDEX_POSITION_PAPER_DETAIL_1: {
			detailsText = getResources().getString(R.string.h2_increasing_obesity);
		}
			break;
		case Constants.INDEX_POSITION_PAPER_DETAIL_2: {
			detailsText = getResources().getString(R.string.h2_insulin_resistence);
		}
			break;
		case Constants.INDEX_POSITION_PAPER_DETAIL_3: {
			detailsText = getResources().getString(R.string.h2_NTFLD);
		}
			break;
		}

		TextView detailsTxtView = (TextView) view
				.findViewById(R.id.textview_innerdetails);
		detailsTxtView.setText(detailsText);

		return view;
	}
}
