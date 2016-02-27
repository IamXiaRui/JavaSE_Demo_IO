package xr_io_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * �ñ����ķ��� �г��ļ�Ŀ¼�µ�������Ҫ��ʽ�ļ�Ŀ¼
 * 
 * 
 * */
public class FileListTest {

	public static void main(String[] args) throws IOException {
		File f = new File("E:\\Github");
		// ����List���϶���
		List<File> list = new ArrayList<File>();
		fileList(f, list);
		// ��һ�������Ǹ�Ŀ¼��·��
		File file = new File(f, "fileList.txt");
		writerList(list, file.toString());
	}

	// ѭ���õ�ָ���ļ�Ŀ¼
	public static void fileList(File dir, List<File> list) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				fileList(f, list);
			} else {
				// �����׺��.java�򱣴浽������
				if (f.getName().endsWith(".java")) {
					list.add(f);
				}
			}
		}
	}

	// ���õ���Ŀд���ļ���
	public static void writerList(List<File> list, String filePath) throws IOException {
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter(filePath));
			for (File f : list) {
				// �õ�����·��
				String path = f.getAbsolutePath();
				bfw.write(path);
				bfw.newLine();
				bfw.flush();
			}

		} catch (IOException e) {
			throw e;
		} finally {
			if (bfw != null) {
				try {
					bfw.close();
					System.out.println("�ļ������ɹ�");
				} catch (IOException e) {
					throw e;
				}
			}
		}
	}
}
