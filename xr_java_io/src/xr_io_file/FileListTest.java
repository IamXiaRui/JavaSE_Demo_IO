package xr_io_file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 用遍历的方法 列出文件目录下的所有需要格式文件目录
 * 
 * 
 * */
public class FileListTest {

	public static void main(String[] args) throws IOException {
		File f = new File("E:\\Github");
		// 创建List集合对象
		List<File> list = new ArrayList<File>();
		fileList(f, list);
		// 第一个参数是父目录的路径
		File file = new File(f, "fileList.txt");
		writerList(list, file.toString());
	}

	// 循环得到指定文件目录
	public static void fileList(File dir, List<File> list) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				fileList(f, list);
			} else {
				// 如果后缀是.java则保存到集合中
				if (f.getName().endsWith(".java")) {
					list.add(f);
				}
			}
		}
	}

	// 将得到的目写入文件中
	public static void writerList(List<File> list, String filePath) throws IOException {
		BufferedWriter bfw = null;
		try {
			bfw = new BufferedWriter(new FileWriter(filePath));
			for (File f : list) {
				// 得到绝对路径
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
					System.out.println("文件创建成功");
				} catch (IOException e) {
					throw e;
				}
			}
		}
	}
}
