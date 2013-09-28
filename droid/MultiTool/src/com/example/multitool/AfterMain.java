package com.example.multitool;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class AfterMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageprocess);
		Button bt = (Button)findViewById(R.id.getButton);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.after_main, menu);
		return true;
	}
	
	private class DownloadImageTask extends AsyncTask{

		protected Object doInBackground(Object... url) {
			if(url[0] instanceof String)
				return loadImageFromNetwork((String)url[0]);
			else
				return null;
		}
		
		protected Object loadImageFromNetwork(String url){
			return null;
		}
	}
}
