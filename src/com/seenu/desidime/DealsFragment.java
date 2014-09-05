package com.seenu.desidime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class DealsFragment extends Fragment {

	private View view;

	// Listview Adapter
	private DealsListAdapter adapter;

	// Listview Widget
	private ListView lv;

	// server Url
	private String url;

	// Progressbar
	private ProgressDialog pdialog;

	private JSONObject obj;
	private String TAG = getClass().getSimpleName();

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

		pdialog = new ProgressDialog(getActivity());
		obj = new JSONObject();

		new DealsAsynck().execute(url);

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		pdialog.dismiss();
	}

	private class DealsAsynck extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pdialog.setMessage("Loading...");
			pdialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String result = null;
			if (!NetworkConnectionStatus.isNetworkAvailable(getActivity())) {
				result = "no internet";
			} else {

				DefaultHttpClient httpclient = new DefaultHttpClient();
				HttpPost httpost = new HttpPost(params[0]);

				try {
					StringEntity se = new StringEntity(obj.toString());

					httpost.setEntity(se);
					httpost.setHeader("Content-type", "application/json");
					HttpResponse response = httpclient.execute(httpost);
					HttpEntity httpEntity = response.getEntity();
					InputStream is = httpEntity.getContent();
					result = convertStreamToString(is);
					Log.i(TAG, result);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			if (result.equals("no internet")) {
				pdialog.dismiss();
				Toast.makeText(getActivity(), "Bad Internet connection!",
						Toast.LENGTH_SHORT).show();
			} else {

				// Parsing the Json using Gson library
				Gson gson = new Gson();
				DealsObject obj = gson.fromJson(result, DealsObject.class);
				// Log.i(TAG, obj.getResult().getTop().size());
				System.out.println(obj.getResult().getTop().size());
				adapter = new DealsListAdapter(getActivity(), obj);
				lv.setAdapter(adapter);
				pdialog.dismiss();
			}

		}

	}

	public String convertStreamToString(InputStream is) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
