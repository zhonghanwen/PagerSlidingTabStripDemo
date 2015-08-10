package com.zhw.pagerslidingtabstripdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ProjectDynamicFragment extends Fragment{
	
	 public static ProjectDynamicFragment newInstance() {
	        return new ProjectDynamicFragment();
	    }

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	    }

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_project_dynamic, null);
	        return view;
	    }

}
