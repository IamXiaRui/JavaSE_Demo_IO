package xr_io_systemin;

/*
 * 从键盘录入 并显示字符串
 * 
 * */
import java.io.IOException;
import java.io.InputStream;

public class SystemInTest_two {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int ch = in.read();
			if (ch == '\r')
				continue;
			if (ch == '\n') {
				String s = sb.toString();
				if ("over".equals(s)) {
					break;
				}
				System.out.println(s.toUpperCase());
				sb.delete(0, sb.length()); // 清空缓冲区
			} else
				sb.append((char) ch);
		}
		in.close();
	}

}
