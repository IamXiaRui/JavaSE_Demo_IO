package xr_io_property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * ����Properties����ʵ���������ʹ�ô���
 * 
 * */
public class PropertyTest {
	public static void main(String[] args) throws IOException {
		// ����Properties����
		Properties pro = new Properties();
		File f = new File("E:\\AllTestFile\\apptime.properties");
		// ��������������ļ� �򴴽�
		if (!f.exists()) {
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);
		// ����������
		pro.load(fis);
		int count = 0;
		// �õ�����Ӧ��ֵ
		String value = pro.getProperty("time");

		if (value != null) {
			count = Integer.parseInt(value);
			if (count >= 5) {
				System.out.println("�Բ���ʹ��ʱ���ѵ�����ע��!");
				return;
			}
		}
		// ����������
		count++;
		String num = Integer.toString(count);
		// ������Ӧ��ֵ
		pro.setProperty("time", num);
		FileOutputStream fos = new FileOutputStream(f);
		pro.store(fos, "");
		fis.close();
		fos.close();
	}
}
