package xr_io_file;

/*
 * 以遍历方式访问文件夹的所有目录
 * 
 * 
 * */
import java.io.File;

public class FileContentsTest {

	public static void main(String[] args) {
		File f = new File("H:\\省物联网");
		showDirs(f, 0);
	}

	// 加层级
	public static String getLevel(int level) {
		StringBuilder sb = new StringBuilder();
		sb.append("|--"); // 分级前面加符号
		for (int i = 0; i < level; i++) {
			sb.insert(0, "  "); // 子目录前加空格
		}
		return sb.toString();
	}

	// 递归方法
	public static void showDirs(File dir, int level) {
		System.out.println(getLevel(level) + dir.getName());
		level++; // 每调用一次层级加1
		File[] f = dir.listFiles(); // 构造遍历对象
		for (int i = 0; i < f.length; i++) {
			if (f[i].isDirectory()) { // 如果是目录 仍然调用此方法
				showDirs(f[i], level);
			} else
				System.out.println(getLevel(level) + f[i]);
		}

	}
}
