package org.crazyit.helloworld;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorld extends Activity {
	final int LIST_DIALOG1 = 0x111;

	String str[] = new String[] { "没有正在运行的校巴。上一辆校巴于43分钟前停车。",
			"一辆开往【北二总站】的校巴已经经过【卫生所站】。", "一辆开往【北二总站】的校巴已经经过【北湖站】。",
			"一辆开往【北二总站】的校巴已经经过【北门站】。", "一辆开往【北二总站】的校巴已经经过【修理厂站】。",
			"一辆开往【北二总站】的校巴已经经过【西秀村站】。", "一辆开往【北二总站】的校巴已经经过【西五站】。",
			"一辆开往【北二总站】的校巴已经经过【人文馆站】。", "一辆开往【北二总站】的校巴已经经过【27号楼站】。",
			"一辆开往【北二总站】的校巴已经经过【百步梯站】。", "一辆开往【北二总站】的校巴已经经过【中山像站】。",
			"一辆开往【北二总站】的校巴已经经过【南门总站】。" };
	String str1[] = new String[] { "一辆开往【南门总站】的校巴已经经过【北二总站】。",
			"一辆开往【南门总站】的校巴已经经过【卫生所站】。", "一辆开往【南门总站】的校巴已经经过【北湖站】。",
			"一辆开往【南门总站】的校巴已经经过【北门站】。", "一辆开往【南门总站】的校巴已经经过【修理厂站】。",
			"一辆开往【南门总站】的校巴已经经过【西秀村站】。", "一辆开往【南门总站】的校巴已经经过【西五站】。",
			"一辆开往【南门总站】的校巴已经经过【人文馆站】。", "一辆开往【南门总站】的校巴已经经过【27号楼站】。",
			"一辆开往【南门总站】的校巴已经经过【百步梯站】。", "一辆开往【南门总站】的校巴已经经过【中山像站】。",
			"一辆开往【南门总站】的校巴已经经过【南门总站】。"

	};

	String place[] = new String[] { "北二总站", "卫生所站", "北湖站", "北门站", "修理厂站",
			"西秀村站", "西五站", "人文馆站", "27号楼站", "百步梯站", "中山像站", "南门总站" };

	// menu按钮的选择功能
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == 4) {
			Intent intent = new Intent();
			intent.setClass(HelloWorld.this, exit.class);
			startActivity(intent);
		}
		if (item.getItemId() == 1) {
			Intent intent = new Intent();
			intent.setClass(HelloWorld.this, about.class);
			startActivity(intent);

		}
		if (item.getItemId() == 2) {
			Intent intent = new Intent();
			intent.setClass(HelloWorld.this, fankui.class);
			startActivity(intent);
		}
		if (item.getItemId() == 3) {
			Intent intent = new Intent();
			intent.setClass(HelloWorld.this, setting.class);
			startActivity(intent);
		}

		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	private static Boolean isExit = false;

	Timer tExit = new Timer();

	MyTimerTask task;

	// 调用闹钟进行定站提醒
	class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			isExit = false;

		}
	}

	// 按后退键退出程序
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isExit == false) {
				isExit = true;
				Toast.makeText(this, "再按一次后退键退出应用程序", Toast.LENGTH_SHORT)
						.show();
				if (task != null)
					task.cancel(); // 将原任务从队列中移除
				task = new MyTimerTask();// 新建一个任务
				tExit.schedule(task, 2000);
			} else {
				finish();
				System.exit(0);
			}
		}
		return false;
	}

	// menu添加按钮选项
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.add(0, 1, 1, R.string.about).setIcon(
				android.R.drawable.ic_menu_help);
		menu.add(0, 2, 2, R.string.fankui).setIcon(
				android.R.drawable.ic_menu_send);
		;
		menu.add(0, 3, 3, R.string.setting).setIcon(
				android.R.drawable.ic_menu_search);
		menu.add(0, 4, 4, R.string.exit).setIcon(
				android.R.drawable.ic_menu_more);
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn = (Button) findViewById(R.id.ok);
		bn.setOnClickListener(startIt);

		Button bt0 = (Button) findViewById(R.id.tixing);

		bt0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG1);

			}

		});

	}

	Handler handler = new Handler();

	// 定站提醒功能的实现
	public Dialog onCreateDialog(int id, Bundle state) {
		// 判断需要生成哪种类型的对话框
		switch (id) {
		case LIST_DIALOG1:
			Builder b = new AlertDialog.Builder(this);
			// 设置对话框的图标
			b.setIcon(R.drawable.xiaoba1);
			// 设置对话框的标题
			b.setTitle("定站提醒");
			// 创建一个List对象，List对象的元素是Map
			List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < place.length; i++) {
				Map<String, Object> listItem = new HashMap<String, Object>();
				// listItem.put("header", imageIds[i]);
				listItem.put("personName", place[i]);
				listItems.add(listItem);
			}
			// 创建一个SimpleAdapter
			SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
					R.layout.row, new String[] { "personName", "header" },
					new int[] { R.id.name, R.id.header });

			// 为对话框设置多个列表
			b.setAdapter(simpleAdapter
			// 为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								final int which) {

							Handler handler = new Handler() {
							};
							Runnable runnable = new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									// 抓取网页

									try {

										Toast.makeText(HelloWorld.this,
												"正在刷新，请稍等~~", Toast.LENGTH_LONG)
												.show();
										final TextView show = (TextView) findViewById(R.id.show);
										URL url = new URL(
												"http://bus.100steps.net/text.php");
										URLConnection conn = url
												.openConnection();
										InputStream in = null;
										conn.setDoOutput(true);
										in = url.openStream();
										// 获取源代码

										String content = pipe(in, "utf-8");

										Pattern patt = Pattern
												.compile("<p>(.*?)</p>");
										Matcher matc = patt.matcher(content);

										if (matc.find()) {
											String temp = matc.group(1)
													.replaceAll("<.*?>", "");

											show.setText(temp);

											String temp1 = show.getText()
													.toString();
											if (temp1.compareTo(str[which]) == 0) {
												Toast.makeText(HelloWorld.this,
														"匹配成功！",
														Toast.LENGTH_LONG)
														.show();
												TextView tv = (TextView) findViewById(R.id.show);
												tv.setText("校巴到站");

												// handler.removeCallbacks(runnable);

											}

											Toast.makeText(HelloWorld.this,
													temp1, Toast.LENGTH_LONG)
													.show();
											// handler.postDelayed(this,4000);
										}

									} catch (Exception e) {
										e.printStackTrace();

									}

									Toast.makeText(HelloWorld.this, "刷新成功！",
											Toast.LENGTH_LONG).show();

								}

							};

							handler.postDelayed(runnable, 4000);// 每4秒执行一次runnable.

							
							  TextView tv = (TextView)findViewById(R.id.show);
							  if(tv.getText().toString().compareTo("校巴到站")==0)
							  { handler.removeCallbacks(runnable); // 停止循环
							  Toast.makeText(HelloWorld.this, "成功停止",
							  Toast.LENGTH_LONG).show(); Intent it = new
							  Intent(); it.setClass(HelloWorld.this,
							  AlarmActivity.class); startActivity(it);
							  
							  } else {
							 
							  handler.postDelayed(runnable, 4000);
							  //每4秒执行一次runnable
							  Toast.makeText(HelloWorld.this,
							  "继续运行", Toast.LENGTH_LONG).show(); }
							 
							Toast.makeText(HelloWorld.this,
									"设置" + place[which] + "成功~~",
									Toast.LENGTH_LONG).show();

						}
					});
			// 创建对话框
			return b.create();

		}
		return null;

	}

	// 抓取网页获取源代码
	public String getdata(int which) {
		try {
			final TextView show = (TextView) findViewById(R.id.show);
			URL url = new URL("http://bus.100steps.net/text.php");
			URLConnection conn = url.openConnection();
			InputStream in = null;
			conn.setDoOutput(true);
			in = url.openStream();
			// 获取源代码

			String content = pipe(in, "utf-8");

			Pattern patt = Pattern.compile("<p>(.*?)</p>");
			Matcher matc = patt.matcher(content);

			if (matc.find()) {
				String temp = matc.group(1).replaceAll("<.*?>", "");

				show.setText(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		final TextView show = (TextView) findViewById(R.id.show);
		String temp = show.getText().toString();
		return temp;

	}

	public OnClickListener startIt = new OnClickListener() {

		public void onClick(View v) {

			try {
				ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = connectivityManager
						.getActiveNetworkInfo();
				if (networkInfo == null || !networkInfo.isAvailable()) {
					// 当前没有可用网络
					Toast.makeText(HelloWorld.this, "您的网络连接好像有问题哦~~",
							Toast.LENGTH_SHORT).show();
				} else {
					// 当前有可用网络
					Toast.makeText(HelloWorld.this, "正在刷新，请稍等~~",
							Toast.LENGTH_LONG).show();
					final TextView show = (TextView) findViewById(R.id.show);
					URL url = new URL("http://bus.100steps.net/text.php");
					URLConnection conn = url.openConnection();
					InputStream in = null;
					conn.setDoOutput(true);
					in = url.openStream();
					// 获取源代码

					String content = pipe(in, "utf-8");

					Pattern patt = Pattern.compile("<p>(.*?)</p>");
					Matcher matc = patt.matcher(content);

					if (matc.find()) {
						String temp = matc.group(1).replaceAll("<.*?>", "");

						show.setText(temp);
					}

				}

			} catch (Exception e) {
				e.printStackTrace();

			}
			Toast.makeText(HelloWorld.this, "刷新成功！", Toast.LENGTH_LONG).show();
		}

	};

	// 进行http通信获取网页源代码的一个函数
	String pipe(InputStream in, String charset) throws IOException {
		StringBuffer s = new StringBuffer();
		if (charset == null || "".equals(charset)) {
			charset = "utf-8";
		}
		String rLine = null;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(in,
				charset));
		PrintWriter pw = null;
		FileOutputStream fo = HelloWorld.this.openFileOutput("index.html",
				Context.MODE_PRIVATE);

		// FileOutputStream fo = new FileOutputStream("/index.html");

		OutputStreamWriter writer = new OutputStreamWriter(fo, "utf-8");
		pw = new PrintWriter(writer);
		while ((rLine = bReader.readLine()) != null) {
			String tmp_rLine = rLine;
			int str_len = tmp_rLine.length();
			if (str_len > 0) {
				s.append(tmp_rLine);
				pw.println(tmp_rLine);
				pw.flush();
			}
			tmp_rLine = null;
		}
		in.close();
		pw.close();
		return s.toString();
	}
}
