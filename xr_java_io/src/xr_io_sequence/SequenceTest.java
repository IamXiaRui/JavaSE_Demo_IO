package xr_io_sequence;

/*
 * �ϲ�����ʹ��
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
		// Vector �����ʵ�ֿ������Ķ�������
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		// �򼯺��������
		v.add(new FileInputStream("E:\\AllTestFile\\sequence_one.txt"));
		v.add(new FileInputStream("E:\\AllTestFile\\sequence_two.txt"));
		v.add(new FileInputStream("E:\\AllTestFile\\sequence_three.txt"));

		// ʵ�� Enumeration �ӿڵĶ���������һϵ��Ԫ�أ�һ������һ��
		// Enumeration<E> elements() ���ش������������ö�١�
		Enumeration<FileInputStream> e = v.elements();

		// �����ϲ�������
		SequenceInputStream s = new SequenceInputStream(e);

		// д�����
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
