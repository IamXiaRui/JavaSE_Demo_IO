package xr_io_ioexception;

/*
 * ��׼��IO�쳣����ʽ
 * 
 * 
 * */
import java.io.*;

public class IOExceptionTest {

	public static void main(String[] args) {
		// ��֮ǰһ��Ҫ��ʼ��Ϊ��
		FileWriter fw = null;
		try {
			// new ����
			fw = new FileWriter("E:\\AllTestFile\\IOExceptionTest.txt", true);
			// д����
			// fw.write("IOExceptionTest");
			// �������
			fw.write("\r\n ����ַ�");
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			// һ��Ҫ�ж��Ƿ�Ϊ�գ���Ϊ�ղ���Ҫִ�йرղ�����
			if (fw != null) {
				try {
					// һ��Ҫ����finally�У����Ǳ���Ĳ�����
					fw.close();
					System.out.println("Success��");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
