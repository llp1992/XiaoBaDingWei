package org.crazyit.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;





public class fankui extends Activity 
{
	protected static final String ViewUtility = null;
	EditText help_feedback=null;
	protected Object UserDataServiceHelper;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fankui);
		
		
			
			

			//获取按钮
			Button but_help_feedback=(Button)findViewById(R.id.tj);
			final EditText MyEditText1 =(EditText)findViewById(R.id.et1);
			final EditText MyEditText2 =(EditText)findViewById(R.id.et2);
			
			//添加点击事件 ，保存文本信息，并生成提示，同时跳转到主界面 
			but_help_feedback.setOnClickListener(new Button.OnClickListener()
			{
			public void onClick(View v){
		    
			//保存
			try{
			//调用网络接口，实现登陆指令
			
				final String str1 = MyEditText1.getText().toString();
				final String str = MyEditText1.getText().toString()+"/n"+MyEditText2.getText().toString();

				
				if(str1.length()!=0){
					Toast.makeText(fankui.this,"感谢您的反馈,我们会尽快处理您的意见。" , Toast.LENGTH_SHORT).show(); 
				}else{
					Toast.makeText(fankui.this, "反馈内容不能为空。", Toast.LENGTH_SHORT).show();
					
				}
			fankui.NavigateActivate((Activity)fankui.this, HelloWorld.class);
			}
			catch(Exception e)
			{
			e.printStackTrace(); 
			}
			finally{

			} 
			}
			});


			}

			protected static void NavigateActivate(Activity activity,
			Class<HelloWorld> class1) {
		// TODO Auto-generated method stub
		
	}

			@Override
			public boolean onKeyDown(int keyCode, KeyEvent event) {
			if(keyCode == KeyEvent.KEYCODE_BACK){
				Intent back = new Intent(fankui.this,HelloWorld.class);
                back.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
                startActivity(back);
                fankui.this.finish();

				
			}
			return false;
			}
			

		
		
		/**
		EditText MyEditText1 =(EditText)findViewById(R.id.et1);
		EditText MyEditText2 =(EditText)findViewById(R.id.et2);
		String str = MyEditText1.getText().toString()+"/n"+MyEditText2.getText().toString();
		Intent testintent = new Intent(Intent.ACTION_SEND);
		String[] tos = {"864743958@qq.com"};
		testintent.putExtra(Intent.EXTRA_EMAIL, tos);
		testintent.putExtra(Intent.EXTRA_TEXT, str);
		startActivity(Intent.createChooser(testintent, "发送"));
		*/
	}


            		
            	
            
		
		
		
		
		
		
		
		
		    
	
