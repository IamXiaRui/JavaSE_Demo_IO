package xr_io_copy;
/*
 * 利用FileReader和FileWriter复制文件
 * 
 * 
 * */

import java.io.*;

public class CopyFileTest {
	public static void main(String[] args) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			fileReader = new FileReader("E:\\AllTestFile\\IOExceptionTest.txt");
			fileWriter = new FileWriter("E:\\AllTestFile\\CopyFileTest.txt");

			// 设置标志位变量
			int length = 0;
			// 设置缓冲数组
			char[] buffer = new char[1024];
			// 循环读取缓冲区中的数据
			while ((length = fileReader.read(buffer)) != -1) {
				// 将缓冲区的数据存入流中
				fileWriter.write(buffer, 0, length);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			// 只有不为空的时候 才能关闭
			if (fileReader != null) {
				try {
					fileReader.close();
					System.out.println("fileReader关闭成功");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
			// 只有不为空的时候 才能关闭
			if (fileWriter != null) {
				try {
					fileWriter.close();
					System.out.println("fileWriter关闭成功");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
	}
}
