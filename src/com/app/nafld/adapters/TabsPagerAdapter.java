package com.app.nafld.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.nafld.fragments.AlgorithmsFragment;
import com.app.nafld.fragments.AppendixFragment;
import com.app.nafld.fragments.CaseStudyFragment;
import com.app.nafld.fragments.ClinicalTrialFragment;
import com.app.nafld.fragments.DrugsFragment;
import com.app.nafld.fragments.InformationFragment;
import com.app.nafld.fragments.NAFLDnMSFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			// Information fragment activity
			return new InformationFragment();
		case 1:
			// NAFLD & MS fragment activity
			return new NAFLDnMSFragment();
		case 2:
			// Algorithms fragment activity
			return new AlgorithmsFragment();
		case 3:
			// Drugs fragment activity
			return new DrugsFragment();
		case 4:
			// Clinical Trial fragment activity
			return new ClinicalTrialFragment();
		case 5:
			// Appendix fragment activity
			return new AppendixFragment();
		case 6:
			// Case study fragment activity
			return new CaseStudyFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 7;
	}

}