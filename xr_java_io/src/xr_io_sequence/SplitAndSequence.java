package xr_io_sequence;

/*
 * 切割文件然后利用Sequence合并文件
 * 
 * */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SplitAndSequence {

	public static void main(String[] args) throws IOException {
		//SplitFile();
		SequenceFile();
	}

	// 合并文件
	public static void SequenceFile() throws IOException {
		// 创建集合
		ArrayList<FileInputStream> a = new ArrayList<>();
		for (int num = 1; num <= 4; num++) {
			a.add(new FileInputStream("E:\\AllTestFile\\Mp3TestSplit" + num + ".part"));
		}

		// 迭代器
		Iterator<FileInputStream> i = a.iterator();

		Enumeration<FileInputStream> e = new Enumeration<FileInputStream>() {
			public boolean hasMoreElements() {
				// 是否有元素可以迭代
				return i.hasNext();
			}

			public FileInputStream nextElement() {
				// 返回迭代的下一个元素。
				return i.next();
			}
		};

		// 合并流
		SequenceInputStream s = new SequenceInputStream(e);

		FileOutputStream fos = new FileOutputStream("E:\\AllTestFile\\Mp3TestSequnce.mp3");

		byte[] b = new byte[1024 * 1024];

		int length = 0;

		while ((length = s.read(b)) != -1) {
			fos.write(b, 0, length);
		}

		fos.close();
		s.close();

	}

	public static void SplitFile() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\AllTestFile\\Mp3Test.mp3");

		FileOutputStream fos = null;

		byte[] b = new byte[1024 * 1024];

		int length = 0;

		// 文件计数器
		int count = 1;
		while ((length = fis.read(b)) != -1) {
			// 每循环一次 创建一个文件
			fos = new FileOutputStream("E:\\AllTestFile\\Mp3TestSplit" + (count++) + ".part");
			fos.write(b, 0, length);
			fos.close();
		}

		fis.close();
	}
}
