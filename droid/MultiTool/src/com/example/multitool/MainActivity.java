package com.example.multitool;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
//import android.view.Menu;
import android.content.Intent;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener
        (
    		new View.OnClickListener() {
				
				public void onClick(View v) {
					Intent i = new Intent(v.getContext(), AfterMain.class);
					startActivity(i);
				}
			}		
        );
    }
}
