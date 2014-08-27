package org.crazyit.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class exit extends Activity 
{
	final int LIST_DIALOG1 = 0x111;
	final int LIST_DIALOG2 = 0x112;
	final int LIST_DIALOG3 = 0x113;
	final int LIST_DIALOG4 = 0x114;
	final int LIST_DIALOG5 = 0x115;
	final int LIST_DIALOG6 = 0x116;
	final int LIST_DIALOG7 = 0x117;
	final int LIST_DIALOG8 = 0x118;
	
	
	private String[] names = new String[]{"华工正门聚餐地","美食一条街","湘乡居","卫生站的饭堂","西秀村外饺子","西区运动场小西门旁大排档和望湖轩"
			,"五山街的餐馆","五山街的麦当劳","五山街的金麦西饼","人文馆下面咖啡厅","32号楼旁咖啡厅","西湖苑"};
	
	private String[] names2 = new String[]{"多品美超市","美食一条街","好当家超市","世纪联华","五山街衣服","北京路","上下九","岗顶","石牌东",
			"龙洞步行街"
			
	};
	private String[] names3 = new String[]{
			"工行","中国银行","农行","招商银行","广发"
	};
	private String[] names4 = new String[]{"西区华工招待所","西秀村外面日租房","东莞庄赛宝酒店","西湖苑","新华发行社的招待所"
			
	};
	private String[] names5 = new String[]{"往大学城的线路","天河客运站"
			
	};
	private String[] names6 = new String[]{
			"东区体育馆","羽毛球场","综合运动场","西区体育馆","篮球场","东区运动场","乒乓球室","网球场"
	};
	private String[] names7 = new String[]{
			"正佳广场","岗顶","体育西路","华南植物园","天河城","天河公园","火炉山公园"
	};
	private String[] names9 = new String[]{"买二手单车","自习的地方","办理网络服务","移动营业厅","复印/打印店"
			
	};
	                                     
	private String[] names8 = new String[]{};
	private int[] imageIds = new int[]

	                             	{ R.drawable.meishi6,R.drawable.meishi7,R.drawable.dapaidang,R.drawable.meishi6,
			R.drawable.jiaozi,R.drawable.meishi7,R.drawable.meishi6,R.drawable.meishi7,R.drawable.meishi6,R.drawable.cafei,
			R.drawable.cafei,R.drawable.meishi6
	                             	};

	
	private int[] imageIds2 = new int[]{R.drawable.duopin,R.drawable.meishiyitiaojie,R.drawable.haodangjia,
			R.drawable.shijianlianhau,R.drawable.wushan,R.drawable.beijinglu,R.drawable.shangxiajiu,
			R.drawable.gangding,R.drawable.shipaidong,R.drawable.longdongbuxingjie
		
	};
	
	private int[] imageIds3 = new int[]{
			R.drawable.gh,R.drawable.zh,R.drawable.nonghang,R.drawable.zhanshan,R.drawable.guangfa,
	};
	
	private int[] imageIds4 = new int[]{R.drawable.xiqu,R.drawable.xixiu,R.drawable.dongguangzhuang,R.drawable.xihuyuan,R.drawable.xinhua
			
	};
	
	private int[] imageIds5 = new int[]{R.drawable.wandaxue,R.drawable.tianhekeyuanzhan
			
	};
	
	private int[] imageIds6 = new int[]{R.drawable.dongqu,R.drawable.yumaoqiu,R.drawable.zonghe,R.drawable.xiqutiyu,
			R.drawable.lanqiuc,R.drawable.dongquyundong,R.drawable.ppq,R.drawable.wanqiu
			
	};
	
	private int[] imageIds8 = new int[]{R.drawable.zixingche,R.drawable.zixishi,R.drawable.waqmgluo,R.drawable.yidongfuwuitng,R.drawable.dayinji
			
	};
	
	private String[] str1 = new String[]{
"一般同学聚餐都是在华工正门，因为这里小店比较多","美食一条街位于北区附近，美食推荐奉天美食、网吧边上那块空地进去的肠粉和粥","湘乡居北区正门，不推荐、快餐、粥、小笼包，早上上课路过买早餐可以考虑，不过有时人比较多"	,
"卫生站里面的饭堂（推荐小规模宵夜）","位于西秀村外面（首推辽宁饺子，实在不行东北饺子也将就）","西区运动场旁边的小西门出去的大排档和望湖轩（不推荐）",
"五山街的餐馆（不推荐）","五山街的麦当劳（推荐晚上,据说9：00后半价，具体情况还得看店长）","五山街的金麦西饼（推荐原磨豆浆，很划算1元，超好喝）","人文馆下面和32号楼旁发电所旧址内的各有一家咖啡厅，算是华工周边唯二的西餐厅了，价钱稍贵，分量少，不过人文馆的咖啡厅环境还算可以的，以前经常叫一大杯奶茶然后在里面看一个下午的书(两个地方都是最低消费每人10个大洋)，天气太热图书馆又没位置的时候不失为一个好地方；发电所的咖啡厅里面有WIFI无线网络，带上笔记本电脑什么的吧"

,
"人文馆下面和32号楼旁发电所旧址内的各有一家咖啡厅，算是华工周边唯二的西餐厅了，价钱稍贵，分量少，不过人文馆的咖啡厅环境还算可以的，以前经常叫一大杯奶茶然后在里面看一个下午的书(两个地方都是最低消费每人10个大洋)，天气太热图书馆又没位置的时候不失为一个好地方；发电所的咖啡厅里面有WIFI无线网络，带上笔记本电脑什么的吧",

"至于西湖苑……忘了它吧，又贵又难吃，传说中只有早茶还算可以了。平时聚餐学六饭堂、北一、北二饭堂足矣。学六五楼如果班上聚会什么的，可以去试试。菜还挺好吃的。价钱和正门的好像差不多。"
			
	};
	
	
	private String[] str2 = new String[]{"北区正门的多品美超市（价格稍偏高，有时候货也不齐、一般生活用品可以在这考虑）","北区附近的美食一条街（又名腐败一条街，从北区科技园出去能到，或者从去北图那条路从北侧门出去）有N多超市，也有五金店之类的东东，（推荐小食街的彩蝴蝶超市）推荐",
			"东区、西区的推荐去五山街的好当家超市（强烈推荐）","东莞庄的世纪联华（世纪联华是个好地方，货物很齐全，价钱也算公道，就是有点远，可以考虑一个星期去一次，然后疯狂扫货，主要是买食物储备",
			"五山街可以去逛逛，里面不少，但很多看看就好。","这个就不用说了，女生逛街必去之地，东西较多","这个就不用说了，女生逛街必去之地，东西较多",
			"可以在岗顶那里下车（或地铁），岗顶有摩登百货和天娱广场（贵）","石牌东的衣服挺不错的，觉得它是扩大版的五山街/缩小版的上下九",
			"龙洞步行街也有衣服，因为那边有批发，所以衣服好像挺便宜的。（从天河客运站坐公交）。"
			
	};
private String[] str3 = new String[]{"西区风味厅、34号楼柜员机、华农门口的十字路口","中区饭堂生活服务点、北十二楼下柜员机，五山街的左边东海堂饼店往前再走几步有中行",
		"多品美超市门口柜员机/五山M记与KFC之间，沿着去学三饭堂的路一直往下走就能看到，有窗口可以办理人工手续","五山地铁口华农正门右侧柜员机",
		"五山花园的入口处、M记旁边"
			
	};
private String[] str4 = new String[]{"红棉苑教师宿舍附近，跟西十九中间隔了一栋楼(较便宜)","廉价，卫生状况还算可以，不过因为是城中村，安全会成问题","比较高级一点，价钱也会相对高一点",
		"好歹也算是三星级酒店","在北门出去的新华发行社的招待所也可以，80元左右"
		
};
private String[] str5 = new String[]{"华工正门站点-大学城二线；广外艺-大学城一线；天河客运站-235","北区篮球场和网球场那个方向出去之后就是天河客运站，那里是大型公交站场通向广州各个地区；也是三号线的终点，第二个站就是五山站，出口就是华工和华农，虽然广州的路上交通也算发达，不过还是比较推荐地铁，一来快速，二来是最重要的，不堵车！三号线换了长车之后客流应该没以前那么挤了。广州现在的地铁网也算小有规模了，基本上市区没有到不了的地方，连佛山都直接到"
		
		
};
private String[] str6 = new String[]{"据说位于东区吧的体育馆每周末放电影，游泳池就在旁边","华工唯一一栋圆形建筑文体中心里面就是一个羽毛球场。北区小礼堂里面是一个羽毛球馆，虽然很简陋，但够便宜。北区大院里有三个羽毛球场",
		"位于西湖西的尽头","位于西湖西的尽头","西十九楼有篮球场,北区网院大楼旁边的篮球场太小了，一般都去北区北部（北二北三后面），那里网球场和篮球场都大大的有","东区运动场有攀爬设施，不过没做好防护还是不要乱玩了（对攀爬有兴趣的建议选，老师很好)",
		"北十一楼下有乒乓球室","北区北部有一个网球场；去34号楼路上也有几个网球场"
};
private String[] str7 = new String[]{"大型购物娱乐餐饮中心","K房影院都很多","K房影院都很多","北区北部出去直接有公交到华南植物园，在里面逛上一天都看不完","大型购物娱乐餐饮中心","位于中山大道270号，电话：02085525052   人气较火","位于火炉山北路，风景好，是烧烤圣地"
		
};
private String[] str8 = new String[]{"去华师附近（具体位置请自行开口寻问，叫做华景路华师东门）、华农北门前有两三家，新车二手车都有，数量偏少。另外，在天河客运站后面也有，不过具体地点就去清楚啦。",
		"正门图书馆、31-34号楼、35号楼（也叫北二饭堂）四到六楼、北区图书馆（有空调）、各宿舍楼下的自习室（有些可以通宵哦），还有一个好地方，华农的第三教学楼，夏天的好去处，有空调，期末的时候会有N多电信的跑过去",
		"北校开校园网，到文体中心边上的网络中心去开，建议开学前去拿好表，通过ipconfig -all查出自己的物理地址填上，然后开学后找辅导员盖章后拿过去（大二以上一般不用辅导员签字），交钱后拿到IP等相关信息，一般说是72小时开通，回来后直接打网管电话其实就可以开通了。续费的同学建议在开学前就去续费，那时候人很少，否则人多排队的时候，惨不忍睹的",
		"五山街好当家超市前面，或者说五山街麦当劳旁边；五山广场入口那个移动服务厅可以办理补卡业务，中区饭堂生活服务点。",
		"西区校园价旁边打印店（一般不推荐，黑店。但如果需要专业论文排版可以去光顾）、西区篮球场旁边的印刷厂打印店、西秀村外面东北饺子附近、北区篮球场旁边的校园价里面（推荐）、北区正门多品美超市里面（推荐）、北二楼下北湖便利店对面（推荐）、东区饭堂出去那个小门有家打印店（推荐，貌似是北校最便宜的）、华工正门天一快印和什么快印（不推荐，有点贵，但可以出AutoCAD图）正门图书馆二楼可以复印（推荐，其实有点贵）、从北区华工科技园出去进入华农西门，有两间复印店（质量跟价格都比华工的好！）"
		
};
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exit);
		
		
		
		
		Button bt1 = (Button)findViewById(R.id.meishi);
		Button bt2 = (Button)findViewById(R.id.gouwu);
		Button bt3 = (Button)findViewById(R.id.yinghang);
		Button bt4 = (Button)findViewById(R.id.lvdian);
		Button bt5 = (Button)findViewById(R.id.jiaotong);
		Button bt6 = (Button)findViewById(R.id.yundong);
		Button bt7 = (Button)findViewById(R.id.yule);
		Button bt8 = (Button)findViewById(R.id.qita);
		
		
		bt1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG1);
			}		
		});
		
		bt2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG2);
			}		
		});
		
		bt3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG3);
			}		
		});
		
		bt4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG4);
			}		
		});
		bt5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG5);
			}		
		});
		
		bt6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG6);
			}		
		});
		
		bt7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG7);
			}		
		});
		
		bt8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(LIST_DIALOG8);
			}		
		});
	}
	public Dialog onCreateDialog(int id, Bundle state)
	{
		//判断需要生成哪种类型的对话框
		switch (id)
		{
			case LIST_DIALOG1:
				Builder b = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b.setIcon(R.drawable.meishi6);
				// 设置对话框的标题
				b.setTitle("美食");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds[i]);
					listItem.put("personName", names[i]);
					listItems.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter = new SimpleAdapter(this
					, listItems 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b.setAdapter(simpleAdapter				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							
							
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str1[which]);   
							 
							startActivity (i);
							
							
							
						}
					});
				// 创建对话框
				return b.create();
				
			case LIST_DIALOG2:
				Builder b2 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b2.setIcon(R.drawable.buxingjie);
				// 设置对话框的标题
				b2.setTitle("购物");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems2 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names2.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds2[i]);
					listItem.put("personName", names2[i]);
					listItems2.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter2 = new SimpleAdapter(this
					, listItems2 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b2.setAdapter(simpleAdapter2				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str2[which]);   
							 
							startActivity (i);

						}
					});
				// 创建对话框
				return b2.create();
				
			case LIST_DIALOG3:
				Builder b3 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b3.setIcon(R.drawable.zh);
				// 设置对话框的标题
				b3.setTitle("银行/ATM");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems3 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names3.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds3[i]);
					listItem.put("personName", names3[i]);
					listItems3.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter3 = new SimpleAdapter(this
					, listItems3 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b3.setAdapter(simpleAdapter3				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str3[which]);   
							 
							startActivity (i);
							

						}
					});
				// 创建对话框
				return b3.create();
				
				
			case LIST_DIALOG4:
				Builder b4 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b4.setIcon(R.drawable.dongguangzhuang);
				// 设置对话框的标题
				b4.setTitle("旅店");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems4 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names4.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds4[i]);
					listItem.put("personName", names4[i]);
					listItems4.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter4 = new SimpleAdapter(this
					, listItems4 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b4.setAdapter(simpleAdapter4				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str4[which]);   
							 
							startActivity (i);

						}
					});
				// 创建对话框
				return b4.create();
				
				
			case LIST_DIALOG5:
				Builder b5 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b5.setIcon(R.drawable.xiaoba);
				// 设置对话框的标题
				b5.setTitle("交通");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems5 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names5.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds5[i]);
					listItem.put("personName", names5[i]);
					listItems5.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter5 = new SimpleAdapter(this
					, listItems5 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b5.setAdapter(simpleAdapter5				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str5[which]);   
							 
							startActivity (i);
						}
					});
				// 创建对话框
				return b5.create();
				
				
			case LIST_DIALOG6:
				Builder b6 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b6.setIcon(R.drawable.yundongyuan);
				// 设置对话框的标题
				b6.setTitle("运动");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems6 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names6.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds6[i]);
					listItem.put("personName", names6[i]);
					listItems6.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter6 = new SimpleAdapter(this
					, listItems6 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b6.setAdapter(simpleAdapter6				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str6[which]);   
							 
							startActivity (i);

						}
					});
				// 创建对话框
				return b6.create();
				
				
			case LIST_DIALOG7:
				Builder b7 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b7.setIcon(R.drawable.tools);
				// 设置对话框的标题
				b7.setTitle("娱乐");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems7 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names7.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds[i]);
					listItem.put("personName", names7[i]);
					listItems7.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter7 = new SimpleAdapter(this
					, listItems7
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b7.setAdapter(simpleAdapter7				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str7[which]);   
							 
							startActivity (i);

						}
					});
				// 创建对话框
				return b7.create();
				
				
			case LIST_DIALOG8:
				Builder b8 = new AlertDialog.Builder(this);
				// 设置对话框的图标
				b8.setIcon(R.drawable.zixishi);
				// 设置对话框的标题
				b8.setTitle("其他");
				//创建一个List对象，List对象的元素是Map
				List<Map<String, Object>> listItems8 = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < names9.length; i++)
				{
					Map<String, Object> listItem = new HashMap<String, Object>();
					listItem.put("header", imageIds8[i]);
					listItem.put("personName", names9[i]);
					listItems8.add(listItem);
				}
				//创建一个SimpleAdapter
				SimpleAdapter simpleAdapter8 = new SimpleAdapter(this
					, listItems8 
					, R.layout.row
					, new String[]{ "personName", "header" }
					, new int[]{R.id.name , R.id.header});
				
				// 为对话框设置多个列表
				b8.setAdapter(simpleAdapter8				
					//为列表项的单击事件设置监听器
					, new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface dialog,
							int which)
						{
							Intent i = new Intent(exit.this,lvdian.class);   
							i.putExtra("uName", str8[which]);   
							 
							startActivity (i);

						}
					});
				// 创建对话框
				return b8.create();
		}
		return null;
	}
	
}

            		
            	
            
				
		
		
		
		
		
		
		    
	
