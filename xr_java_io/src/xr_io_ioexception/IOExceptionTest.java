package xr_io_ioexception;

/*
 * 标准的IO异常处理方式
 * 
 * 
 * */
import java.io.*;

public class IOExceptionTest {

	public static void main(String[] args) {
		// 在之前一定要初始化为空
		FileWriter fw = null;
		try {
			// new 对象
			fw = new FileWriter("E:\\AllTestFile\\IOExceptionTest.txt", true);
			// 写数据
			// fw.write("IOExceptionTest");
			// 添加数据
			fw.write("\r\n 添加字符");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			// 一定要判断是否为空，不为空才需要执行关闭操作。
			if (fw != null) {
				try {
					// 一定要放在finally中，这是必须的操作。
					fw.close();
					System.out.println("Success！");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
