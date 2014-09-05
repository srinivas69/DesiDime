package com.seenu.desidime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class MainActivity extends ActionBarActivity {

//	private FrameLayout fl;
	private Fragment mFrag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//fl = (FrameLayout) findViewById(R.id.frameLayout);
		FragmentManager fm = getSupportFragmentManager();

		if (savedInstanceState == null) {

			FragmentTransaction t = fm.beginTransaction();
			mFrag = new DealsFragment();
			t.replace(R.id.frameLayout, mFrag);
			t.commit();
		} else {
			mFrag = (Fragment) fm.findFragmentById(R.id.frameLayout);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
