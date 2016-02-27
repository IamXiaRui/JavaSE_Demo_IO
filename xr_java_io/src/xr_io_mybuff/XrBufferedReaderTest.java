package xr_io_mybuff;

/*
 * 自定义BufferedReader类
 * 并实现readLine()功能
 * 
 * 
 * */
import java.io.FileReader;
import java.io.IOException;

public class XrBufferedReaderTest {

	public static void main(String[] args) {
		// new 一个自定义BufferedReader类对象
		XrBufferedReader xrbufferReader = null;

		try {
			xrbufferReader = new XrBufferedReader(new FileReader("E:\\AllTestFile\\IOExceptionTest.txt"));
			String line = null;
			while ((line = xrbufferReader.xrReadLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			if (xrbufferReader != null) {
				try {
					xrbufferReader.xrClose();
					System.out.println("xrbufferReader关闭成功");
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
	}

}

class XrBufferedReader {

	private FileReader fileReader;

	XrBufferedReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public String xrReadLine() throws IOException {
		// 创建一个StringBuilder对象
		StringBuilder stringBuilder = new StringBuilder();
		int length = 0;

		while ((length = fileReader.read()) != -1) {
			// \r\n为win下的换行符 如果读到\r 不打印 直接读取下一个
			if (length == '\r') {
				continue;
			}
			// 如果读到\n 则打印缓冲区全部的字符
			if (length == '\n') {
				return stringBuilder.toString();
			}
			// 添加字符
			stringBuilder.append((char) length);
		}
		// 如果缓冲区不是空，那么直接打印 防止文件末尾没有换行 造成文件数据丢失
		if (stringBuilder.length() != 0) {
			return stringBuilder.toString();
		}
		return null;
	}

	public void xrClose() throws IOException {
		fileReader.close();
	}

}
