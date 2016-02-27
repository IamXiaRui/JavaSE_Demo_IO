package xr_io_sequence;

/*
 * 合并流的使用
 * 
 *
 * 
 * */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceTest {
	public static void main(String[] args) throws IOException {
		// Vector 类可以实现可增长的对象数组
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		// 向集合中添加流
		v.add(new FileInputStream("E:\\AllTestFile\\sequence_one.txt"));
		v.add(new FileInputStream("E:\\AllTestFile\\sequence_two.txt"));
		v.add(new FileInputStream("E:\\AllTestFile\\sequence_three.txt"));

		// 实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个
		// Enumeration<E> elements() 返回此向量的组件的枚举。
		Enumeration<FileInputStream> e = v.elements();

		// 创建合并流对象
		SequenceInputStream s = new SequenceInputStream(e);

		// 写入操作
		FileOutputStream f = new FileOutputStream("E:\\AllTestFile\\SequenceTest.txt");
		byte[] b = new byte[1024];
		int length = 0;
		while ((length = s.read(b)) != -1) {
			f.write(b, 0, length);
		}
		f.close();
		s.close();
	}
}
