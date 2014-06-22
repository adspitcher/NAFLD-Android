package com.app.nafld.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.app.nafld.R;
import com.app.nafld.adapters.AuthorsAdapter;
import com.app.nafld.dataobjects.AuthorsItems;

public class AuthorsFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_authors, container, false);
		
		ListView listView_authors_items = (ListView)view.findViewById(R.id.listview_authors);

		String[] authorsNames = view.getResources().getStringArray(R.array.authors_name_array);
		String[] authorsDepartments = view.getResources().getStringArray(R.array.authors_departments_array);
		String[] authorsQualifications = view.getResources().getStringArray(R.array.authors_qualification_array);
		String[] authorsLocations = view.getResources().getStringArray(R.array.authors_location_array);
		
		AuthorsItems[] items = new AuthorsItems[3];
		
		for (int i = 0; i < 3; i++) {
			Log.d("AuthorsFragment", ""+authorsNames[i] + "==" + authorsDepartments[i] + "==" +  authorsQualifications[i] + "==" +  authorsLocations[i]);
			items[i] = new AuthorsItems(authorsNames[i], authorsDepartments[i], authorsQualifications[i], authorsLocations[i]);
		}
				
		AuthorsAdapter adapter = new AuthorsAdapter(view.getContext(), R.layout.fragment_authors, items);
		listView_authors_items.setAdapter(adapter);

		return view;
	}
}
