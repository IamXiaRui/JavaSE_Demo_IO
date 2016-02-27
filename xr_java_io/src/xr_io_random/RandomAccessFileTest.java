package xr_io_random;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile的使用方法
 * */
public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		writerFile();
		readerFile();
	}

	// 读取
	public static void readerFile() throws IOException {
		RandomAccessFile r = new RandomAccessFile("E:\\AllTestFile\\randomTest.txt", "r");
		// 调整指针的位置 读取内容不同
		r.seek(8);
		byte[] b = new byte[4];
		r.read(b);
		String name = new String(b);
		int age = r.readInt();
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		r.close();
	}

	// 写入
	public static void writerFile() throws IOException {
		RandomAccessFile r = new RandomAccessFile("E:\\AllTestFile\\randomTest.txt", "rw");
		// 调整指针位置 插入位置不同
		r.seek(8 * 3);
		r.write("夏睿".getBytes());
		r.writeInt(97);
		r.write("胡斐".getBytes());
		r.writeInt(100);
		r.close();
	}
}
