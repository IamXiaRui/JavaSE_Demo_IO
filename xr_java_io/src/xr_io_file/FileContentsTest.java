package xr_io_file;

/*
 * �Ա�����ʽ�����ļ��е�����Ŀ¼
 * 
 * 
 * */
import java.io.File;

public class FileContentsTest {

	public static void main(String[] args) {
		File f = new File("H:\\ʡ������");
		showDirs(f, 0);
	}

	// �Ӳ㼶
	public static String getLevel(int level) {
		StringBuilder sb = new StringBuilder();
		sb.append("|--"); // �ּ�ǰ��ӷ���
		for (int i = 0; i < level; i++) {
			sb.insert(0, "  "); // ��Ŀ¼ǰ�ӿո�
		}
		return sb.toString();
	}

	// �ݹ鷽��
	public static void showDirs(File dir, int level) {
		System.out.println(getLevel(level) + dir.getName());
		level++; // ÿ����һ�β㼶��1
		File[] f = dir.listFiles(); // �����������
		for (int i = 0; i < f.length; i++) {
			if (f[i].isDirectory()) { // �����Ŀ¼ ��Ȼ���ô˷���
				showDirs(f[i], level);
			} else
				System.out.println(getLevel(level) + f[i]);
		}

	}
}
