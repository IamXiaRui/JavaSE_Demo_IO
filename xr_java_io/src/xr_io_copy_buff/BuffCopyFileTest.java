package xr_io_copy_buff;
/*
 * ����BufferedReader��BufferedWriter�����ļ�
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class BuffCopyFileTest {
	public static void main(String[] args) {
		BufferedReader bufferReader = null;
		BufferedWriter bufferWriter = null;
		try {
			bufferReader = new BufferedReader(new FileReader("E:\\AllTestFile\\IOExceptionTest.txt"));
			bufferWriter = new BufferedWriter(new FileWriter("E:\\AllTestFile\\BuffCopyFileTest.txt"));

			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				// �������������ݴ�������
				bufferWriter.write(line);
				bufferWriter.newLine();
				bufferWriter.flush();
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			// ֻ�в�Ϊ�յ�ʱ�� ���ܹر�
			if (bufferReader != null) {
				try {
					// ֻ��Ҫ�رջ���������
					bufferReader.close();
					System.out.println("bufferReader�رճɹ�");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
			// ֻ�в�Ϊ�յ�ʱ�� ���ܹر�
			if (bufferWriter != null) {
				try {
					// ֻ��Ҫ�رջ���������
					bufferWriter.close();
					System.out.println("bufferWriter�رճɹ�");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
	}
}
