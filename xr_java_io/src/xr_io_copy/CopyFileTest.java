package xr_io_copy;
/*
 * ����FileReader��FileWriter�����ļ�
 * 
 * 
 * */

import java.io.*;

public class CopyFileTest {
	public static void main(String[] args) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			fileReader = new FileReader("E:\\AllTestFile\\IOExceptionTest.txt");
			fileWriter = new FileWriter("E:\\AllTestFile\\CopyFileTest.txt");

			// ���ñ�־λ����
			int length = 0;
			// ���û�������
			char[] buffer = new char[1024];
			// ѭ����ȡ�������е�����
			while ((length = fileReader.read(buffer)) != -1) {
				// �������������ݴ�������
				fileWriter.write(buffer, 0, length);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			// ֻ�в�Ϊ�յ�ʱ�� ���ܹر�
			if (fileReader != null) {
				try {
					fileReader.close();
					System.out.println("fileReader�رճɹ�");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
			// ֻ�в�Ϊ�յ�ʱ�� ���ܹر�
			if (fileWriter != null) {
				try {
					fileWriter.close();
					System.out.println("fileWriter�رճɹ�");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
	}
}
