package xr_io_random;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile��ʹ�÷���
 * */
public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		writerFile();
		readerFile();
	}

	// ��ȡ
	public static void readerFile() throws IOException {
		RandomAccessFile r = new RandomAccessFile("E:\\AllTestFile\\randomTest.txt", "r");
		// ����ָ���λ�� ��ȡ���ݲ�ͬ
		r.seek(8);
		byte[] b = new byte[4];
		r.read(b);
		String name = new String(b);
		int age = r.readInt();
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		r.close();
	}

	// д��
	public static void writerFile() throws IOException {
		RandomAccessFile r = new RandomAccessFile("E:\\AllTestFile\\randomTest.txt", "rw");
		// ����ָ��λ�� ����λ�ò�ͬ
		r.seek(8 * 3);
		r.write("���".getBytes());
		r.writeInt(97);
		r.write("���".getBytes());
		r.writeInt(100);
		r.close();
	}
}
