package xr_io_copymp3;

/*
 * �����Զ�����ֽ�����ɸ���MP3�ļ��Ĳ���
 * 
 * 
 * */
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyMp3Test {

	public static void main(String[] args) throws IOException {
		// ��ȡϵͳʱ��
		long start = System.currentTimeMillis();
		copyMp3();
		long end = System.currentTimeMillis();
		System.out.println("������Ҫʱ��Ϊ�� " + (end - start) + " ����");

	}

	public static void copyMp3() throws IOException {
		XrBufferedInputStream input = new XrBufferedInputStream(new FileInputStream("E:\\AllTestFile\\Mp3Test.mp3"));
		BufferedOutputStream output = new BufferedOutputStream(
				new FileOutputStream("E:\\AllTestFile\\Mp3Test_copy.mp3"));

		int length = 0;

		while ((length = input.xrRead()) != -1) {
			output.write(length);
		}

		input.xrClose();
		output.close();
	}

}

// �Զ����ֽ���
class XrBufferedInputStream {

	private InputStream in;

	private byte[] buf = new byte[1024];

	private int pos = 0; // �����±�

	private int count = 0; // ������

	XrBufferedInputStream(InputStream in) {
		this.in = in;
	}

	public int xrRead() throws IOException {
		// ���������Ϊ0����ô��Ҫץȡ1024���ֽڷ�������
		if (count == 0) {
			count = in.read(buf);
			// С��0���򷵻�-1
			if (count < 0) {
				return -1;
			}
			// �����±�����Ϊ0
			pos = 0;
			// �����һ������
			byte b = buf[pos];
			// �������Լ�
			count--;
			// �±�����
			pos++;
			// ��11111111 ǰ�油0 ��ֹ���� -1 �����
			return b & 255;
		} else if (count > 0) { // ����0 �������
			byte b = buf[pos];
			count--;
			pos++;
			return b & 255;
		}
		return -1;
	}

	public void xrClose() throws IOException {
		in.close();
	}

}
