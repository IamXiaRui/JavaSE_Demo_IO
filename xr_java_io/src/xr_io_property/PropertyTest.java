package xr_io_property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 利用Properties对象实现限制软件使用次数
 * 
 * */
public class PropertyTest {
	public static void main(String[] args) throws IOException {
		// 创建Properties对象
		Properties pro = new Properties();
		File f = new File("E:\\AllTestFile\\apptime.properties");
		// 如果不存在配置文件 则创建
		if (!f.exists()) {
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);
		// 关联输入流
		pro.load(fis);
		int count = 0;
		// 得到键相应的值
		String value = pro.getProperty("time");

		if (value != null) {
			count = Integer.parseInt(value);
			if (count >= 5) {
				System.out.println("对不起，使用时间已到，请注册!");
				return;
			}
		}
		// 计数器自增
		count++;
		String num = Integer.toString(count);
		// 填入相应的值
		pro.setProperty("time", num);
		FileOutputStream fos = new FileOutputStream(f);
		pro.store(fos, "");
		fis.close();
		fos.close();
	}
}
