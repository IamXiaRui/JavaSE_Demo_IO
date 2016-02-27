package xr_io_mybuff;

/*
 * �Զ���BufferedReader��
 * ��ʵ��readLine()����
 * 
 * 
 * */
import java.io.FileReader;
import java.io.IOException;

public class XrBufferedReaderTest {

	public static void main(String[] args) {
		// new һ���Զ���BufferedReader�����
		XrBufferedReader xrbufferReader = null;

		try {
			xrbufferReader = new XrBufferedReader(new FileReader("E:\\AllTestFile\\IOExceptionTest.txt"));
			String line = null;
			while ((line = xrbufferReader.xrReadLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (xrbufferReader != null) {
				try {
					xrbufferReader.xrClose();
					System.out.println("xrbufferReader�رճɹ�");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
	}

}

class XrBufferedReader {

	private FileReader fileReader;

	XrBufferedReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public String xrReadLine() throws IOException {
		// ����һ��StringBuilder����
		StringBuilder stringBuilder = new StringBuilder();
		int length = 0;

		while ((length = fileReader.read()) != -1) {
			// \r\nΪwin�µĻ��з� �������\r ����ӡ ֱ�Ӷ�ȡ��һ��
			if (length == '\r') {
				continue;
			}
			// �������\n ���ӡ������ȫ�����ַ�
			if (length == '\n') {
				return stringBuilder.toString();
			}
			// ����ַ�
			stringBuilder.append((char) length);
		}
		// ������������ǿգ���ôֱ�Ӵ�ӡ ��ֹ�ļ�ĩβû�л��� ����ļ����ݶ�ʧ
		if (stringBuilder.length() != 0) {
			return stringBuilder.toString();
		}
		return null;
	}

	public void xrClose() throws IOException {
		fileReader.close();
	}

}
