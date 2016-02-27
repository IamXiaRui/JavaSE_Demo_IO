package xr_io_systemin;

/*
 * 从键盘录入字符串 追加到原有的文件中
 * */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SystemInTest_one {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入内容 ：");
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		// 将字符串转换为字节数组
		byte[] b1 = in.getBytes();
		// 是否追加标志符
		boolean flag = true;
		BufferedOutputStream output = new BufferedOutputStream(
				new FileOutputStream("E:\\AllTestFile\\BuffCopyFileTest.txt", flag));

		output.write(b1);
		output.close();

	}

}
