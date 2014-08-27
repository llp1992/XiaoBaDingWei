package org.crazyit.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class setting extends Activity {
	public String get(String args[][], String a, String b, String args1[]) {

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < args[i].length; j++) {
				// 注意以后不要再犯错误，字符串的比较问题不是a==b

				if (a.compareTo(args[i][j]) == 0) {
					a = args1[i];
				}
			}
		}
		if (a.compareTo(b) == 0) {
			a = "对不起，您输入的地点不在校巴站点附近,请重新输入";
		}
		return a;
	};

	public String get1(String str1, String str, String str2) {

		if (str1.compareTo("对不起，您输入的地点不在校巴站点附近,请重新输入") == 0)
			str2 = "对不起，您输入的地点不在校巴站点附近,请重新输入";
		else if (str1.compareTo("对不起，您输入的地点不在校巴站点附近,请重新输入") != 0) {
			str2 = str + "在    " + str1 + "   附近，您须坐车到     " + str1;
		}
		return str2;

	};

	String[] places = new String[] {
			// 北二总站
			"北二饭堂",
			"单车维修",
			"35号楼",
			"北湖便利店",
			"打印店",
			"打印店",
			"眼镜店",
			"北区体育场",
			"天河客运站",
			// 卫生所站
			"26号楼",
			"北区校园价",
			"打印店",
			"电脑维修店",
			"眼镜店",
			"网络教育学院",

			// 北湖站
			"北区图书馆",
			"科技园一号楼",
			"科技园二号楼",

			// 北门站
			"饭堂服务点",
			"北一饭堂",
			"继续教育学院",

			// 修理厂站
			"天桥",
			"多品美超市",
			"夜宵集中地",

			// 西秀村站
			"34号楼", "轮滑场",
			"排球场",
			"西秀村小区（短租房，腐败一条街）",
			"短租房（西秀村小区，腐败一条街）",
			"腐败一条街（西秀村小区，短租房）",

			// 西五站
			"水电中心", "校园价", "饭堂服务点", "西湖苑", "工商银行", "西区体育场",
			"中区饭堂",
			"学六饭堂",
			"邮局",

			// 人文馆站
			"逸夫人文馆", "逸夫科学馆", "励吾科技楼", "计算机中心", "",
			"电力学院（9号楼）",
			"9号楼（电力学院）",
			// 27号楼站
			"27号楼", "3号楼（自动化学院）", "4号楼（数学学院，外语学院）", "华工校医院", "东区饭堂", "清真饭堂",
			"五山地铁站", "自动化学院（3号楼）", "数学学院（4号楼，外语学院）",
			"外语学院（4号楼，数学学院）",

			// 百步梯站
			"百步梯", "12号楼(工商管理学院)", "工商管理学院（12号楼）", "25号楼（物理实验室）",
			"物理实验室（25号楼）",

			// 中山像站
			"1号楼", "文体中心", "电讯楼", "东区体育馆", "游泳池",
			// 南门总站
			"图书馆", "单车维修", "华工正门", "正门腐败一条街", "华工科技园", "天一快印", "麟鸿楼", "汕头校友楼",
			"逸夫工程馆（化学学院）", "13号楼（食品学院）", "化学学院（逸夫工程馆）", "食品学院（13号楼）"

	};
	String[][] places0 = new String[][] {
			{
					// 北二总站
					"北二饭堂", "单车维修", "35号楼", "北湖便利店", "打印店", "打印店", "眼镜店",
					"北区体育场", "天河客运站"

			},
			{
					// 卫生所站
					"26号楼", "北区校园价", "打印店", "电脑维修店", "眼镜店", "网络教育学院" },
			{
					// 北湖站
					"北区图书馆", "科技园一号楼", "科技园二号楼" },
			{
					// 北门站
					"饭堂服务点", "北一饭堂", "继续教育学院" },
			{
					// 修理厂站
					"天桥", "多品美超市", "夜宵集中地" },
			{
					// 西秀村站
					"34号楼", "轮滑场", "排球场", "西秀村小区（短租房，腐败一条街）",
					"短租房（西秀村小区，腐败一条街）", "腐败一条街（西秀村小区，短租房）" },
			{
					// 西五站
					"水电中心", "校园价", "饭堂服务点", "西湖苑", "工商银行", "西区体育场", "中区饭堂",
					"学六饭堂", "邮局" },
			{
					// 人文馆站
					"逸夫人文馆", "逸夫科学馆", "励吾科技楼", "计算机中心", "", "电力学院（9号楼）",
					"9号楼（电力学院）" },
			{
					// 27号楼站
					"27号楼", "3号楼（自动化学院）", "4号楼（数学学院，外语学院）", "华工校医院", "东区饭堂",
					"清真饭堂", "五山地铁站", "自动化学院（3号楼）", "数学学院（4号楼，外语学院）",
					"外语学院（4号楼，数学学院）" },
			{
					// 百步梯站
					"百步梯", "12号楼(工商管理学院)", "工商管理学院（12号楼）", "25号楼（物理实验室）",
					"物理实验室（25号楼）" },
			{
					// 中山像站
					"1号楼", "文体中心", "电讯楼", "东区体育馆", "游泳池" },
			{
					// 南门总站
					"图书馆", "单车维修", "华工正门", "正门腐败一条街", "华工科技园", "天一快印", "麟鸿楼",
					"汕头校友楼", "逸夫工程馆（化学学院）", "13号楼（食品学院）", "化学学院（逸夫工程馆）",
					"食品学院（13号楼）" } };
	String[] places1 = new String[] { "北二总站", "卫生所站", "北湖站", "北门站", "修理厂站",
			"西秀村站", "西五站", "人文馆站", "27号楼站", "百步梯站", "中山像站", "南门总站" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, places);
		AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.auto);

		actv.setAdapter(aa);

		final AutoCompleteTextView ACTV1 = (AutoCompleteTextView) findViewById(R.id.auto);

		Button button0 = (Button) findViewById(R.id.tj);

		button0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// 获取地点名
				String str = ACTV1.getText().toString();

				// 获取站名
				String str1 = get(places0, str, str, places1);
				String str3 = null;
				String str2 = get1(str1, str, str3);

				// 输出语句

				Toast.makeText(setting.this, str2, Toast.LENGTH_LONG).show();
			}
		});

		super.onCreate(savedInstanceState);
	}

}
