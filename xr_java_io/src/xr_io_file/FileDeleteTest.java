package xr_io_file;

import java.io.File;

/*
 * �ñ����ķ���ɾ���ļ�Ŀ¼
 * 
 * 
 * */
public class FileDeleteTest {

	public static void main(String[] args) {
		File file = new File("H:\\ʡ������2");
		deleteFile(file);
	}

	public static void deleteFile(File dir) {

		File[] f = dir.listFiles();

		for (int i = 0; i < f.length; i++) {
			// �ж��Ƿ��������ļ�
			if (!f[i].isHidden() && f[i].isDirectory()) {
				deleteFile(f[i]);
			} else
				System.out.println(f[i].toString() + "----" + f[i].delete());
		}
		System.out.println(dir.toString() + "----" + dir.delete());
	}
}
