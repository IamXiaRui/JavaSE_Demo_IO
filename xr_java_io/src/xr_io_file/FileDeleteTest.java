package xr_io_file;

import java.io.File;

/*
 * 用遍历的方法删除文件目录
 * 
 * 
 * */
public class FileDeleteTest {

	public static void main(String[] args) {
		File file = new File("H:\\省物联网2");
		deleteFile(file);
	}

	public static void deleteFile(File dir) {

		File[] f = dir.listFiles();

		for (int i = 0; i < f.length; i++) {
			// 判断是否是隐藏文件
			if (!f[i].isHidden() && f[i].isDirectory()) {
				deleteFile(f[i]);
			} else
				System.out.println(f[i].toString() + "----" + f[i].delete());
		}
		System.out.println(dir.toString() + "----" + dir.delete());
	}
}
