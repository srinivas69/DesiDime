package com.seenu.desidime;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DealsFragment extends Fragment {

	private View view;

	// Listview Adapter
	private DealsListAdapter adapter;

	// Listview Widget
	private ListView lv;

	// Url
	private String url;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.deals_fragment, null);
		lv = (ListView) view.findViewById(R.id.listView1);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		url = "http://www.desidime.com/api/v1/premium_deals/list/";
		new DealsAsynck().execute(url);
		adapter = new DealsListAdapter(getActivity());
		lv.setAdapter(adapter);
	}

	private class DealsAsynck extends AsyncTask<String, Void, Void> {

		@Override
		protected Void doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
