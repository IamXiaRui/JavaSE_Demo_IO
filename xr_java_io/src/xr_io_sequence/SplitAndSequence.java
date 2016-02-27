package xr_io_sequence;

/*
 * �и��ļ�Ȼ������Sequence�ϲ��ļ�
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

	// �ϲ��ļ�
	public static void SequenceFile() throws IOException {
		// ��������
		ArrayList<FileInputStream> a = new ArrayList<>();
		for (int num = 1; num <= 4; num++) {
			a.add(new FileInputStream("E:\\AllTestFile\\Mp3TestSplit" + num + ".part"));
		}

		// ������
		Iterator<FileInputStream> i = a.iterator();

		Enumeration<FileInputStream> e = new Enumeration<FileInputStream>() {
			public boolean hasMoreElements() {
				// �Ƿ���Ԫ�ؿ��Ե���
				return i.hasNext();
			}

			public FileInputStream nextElement() {
				// ���ص�������һ��Ԫ�ء�
				return i.next();
			}
		};

		// �ϲ���
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

		// �ļ�������
		int count = 1;
		while ((length = fis.read(b)) != -1) {
			// ÿѭ��һ�� ����һ���ļ�
			fos = new FileOutputStream("E:\\AllTestFile\\Mp3TestSplit" + (count++) + ".part");
			fos.write(b, 0, length);
			fos.close();
		}

		fis.close();
	}
}
