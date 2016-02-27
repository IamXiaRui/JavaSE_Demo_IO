package xr_io_copy_buff;
/*
 * 利用BufferedReader和BufferedWriter复制文件
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class BuffCopyFileTest {
	public static void main(String[] args) {
		BufferedReader bufferReader = null;
		BufferedWriter bufferWriter = null;
		try {
			bufferReader = new BufferedReader(new FileReader("E:\\AllTestFile\\IOExceptionTest.txt"));
			bufferWriter = new BufferedWriter(new FileWriter("E:\\AllTestFile\\BuffCopyFileTest.txt"));

			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				// 将缓冲区的数据存入流中
				bufferWriter.write(line);
				bufferWriter.newLine();
				bufferWriter.flush();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			// 只有不为空的时候 才能关闭
			if (bufferReader != null) {
				try {
					// 只需要关闭缓冲流即可
					bufferReader.close();
					System.out.println("bufferReader关闭成功");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
			// 只有不为空的时候 才能关闭
			if (bufferWriter != null) {
				try {
					// 只需要关闭缓冲流即可
					bufferWriter.close();
					System.out.println("bufferWriter关闭成功");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
	}
}
