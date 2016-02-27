package xr_io_systemin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * 字符转换流的使用方法
 * 
 * */
public class SystemInTest_three {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		// 字符读取转换流
		InputStreamReader input = new InputStreamReader(in);
		BufferedReader buf = new BufferedReader(input);
		String flag = null;
		while ((flag = buf.readLine()) != null) {
			if ("over".equals(flag)) {
				break;
			}
			System.out.println(flag.toUpperCase());
		}

	}

}
