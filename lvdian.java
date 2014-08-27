package org.crazyit.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView;

public class lvdian extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lvdian);
		Intent i = getIntent();   
		String uName = i.getStringExtra("uName");   


	TextView tv1 = (TextView)findViewById(R.id.show1);

	
	tv1.setText(uName);
	}

	
	}
	
	
	
	


	


            		
            	
            
		
		
		
		
		
		
		
		
		    
	
