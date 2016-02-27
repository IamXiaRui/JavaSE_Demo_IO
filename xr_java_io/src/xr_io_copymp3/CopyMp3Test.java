package xr_io_copymp3;

/*
 * 利用自定义的字节流完成复制MP3文件的操作
 * 
 * 
 * */
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyMp3Test {

	public static void main(String[] args) throws IOException {
		// 获取系统时间
		long start = System.currentTimeMillis();
		copyMp3();
		long end = System.currentTimeMillis();
		System.out.println("操作需要时间为： " + (end - start) + " 毫秒");

	}

	public static void copyMp3() throws IOException {
		XrBufferedInputStream input = new XrBufferedInputStream(new FileInputStream("E:\\AllTestFile\\Mp3Test.mp3"));
		BufferedOutputStream output = new BufferedOutputStream(
				new FileOutputStream("E:\\AllTestFile\\Mp3Test_copy.mp3"));

		int length = 0;

		while ((length = input.xrRead()) != -1) {
			output.write(length);
		}

		input.xrClose();
		output.close();
	}

}

// 自定义字节流
class XrBufferedInputStream {

	private InputStream in;

	private byte[] buf = new byte[1024];

	private int pos = 0; // 数组下标

	private int count = 0; // 计数器

	XrBufferedInputStream(InputStream in) {
		this.in = in;
	}

	public int xrRead() throws IOException {
		// 如果计数器为0，那么需要抓取1024个字节放入数组
		if (count == 0) {
			count = in.read(buf);
			// 小于0，则返回-1
			if (count < 0) {
				return -1;
			}
			// 数组下标重置为0
			pos = 0;
			// 数组第一个数据
			byte b = buf[pos];
			// 计数器自减
			count--;
			// 下标自增
			pos++;
			// 将11111111 前面补0 防止出现 -1 的情况
			return b & 255;
		} else if (count > 0) { // 大于0 则继续读
			byte b = buf[pos];
			count--;
			pos++;
			return b & 255;
		}
		return -1;
	}

	public void xrClose() throws IOException {
		in.close();
	}

}
