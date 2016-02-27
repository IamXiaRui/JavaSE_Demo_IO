package xr_io_copypic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *利用字节流完成图片的拷贝过程
 * 
 * 
 * 
 * */
public class CopyPicTest {

	public static void main(String[] args) {
		CopyPic();
	}

	public static void CopyPic() {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream("E:\\AllTestFile\\copy_one.png");
			fileOutputStream = new FileOutputStream("E:\\AllTestFile\\copy_two.png");
			byte[] b = new byte[1024];
			int length = 0;
			while ((length = fileInputStream.read(b)) != -1) {
				fileOutputStream.write(b, 0, length);
			}

		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("文件复制失败");
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
					System.out.println("fileInputStream已关闭");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
					System.out.println("fileOutputStream已关闭");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}

		}
	}
}
