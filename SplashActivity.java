package org.crazyit.helloworld;



import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;
 
public class SplashActivity extends Activity {
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
 
		setContentView(R.layout.splash);
 
		// Display the current version number
		PackageManager pm = getPackageManager();
		try {
			PackageInfo pi = pm.getPackageInfo("com.uutroy.android.bjtuer", 0);
			TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
			versionNumber.setText("Version " + pi.versionName +"\n"+"天堂皓月");
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
 
		new Handler().postDelayed(new Runnable() {
			public void run() {
				/* Create an Intent that will start the Main Activity. */
				Intent mainIntent = new Intent(SplashActivity.this,
						HelloWorld.class);
				SplashActivity.this.startActivity(mainIntent);
				SplashActivity.this.finish();
			}
		}, 2500);
	}
}


            		
            	
            
		
		
		
		
		
		
		
		
		    
	
