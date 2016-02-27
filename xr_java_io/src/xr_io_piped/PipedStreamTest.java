package xr_io_piped;

/*
 * �ܵ�����ʹ�÷���
 * 
 * */
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamTest {
	public static void main(String[] args) throws IOException {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		// �ܵ���������
		pis.connect(pos);
		Reader r = new Reader(pis);
		Writer w = new Writer(pos);
		// �����ڶ���߳�����
		new Thread(r).start();
		new Thread(w).start();
	}
}

class Reader implements Runnable {
	private PipedInputStream in;

	Reader(PipedInputStream in) {
		this.in = in;
	}

	public void run() {
		try {
			byte[] b = new byte[1024];
			int length = in.read(b);
			String s = new String(b, 0, length);
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}

class Writer implements Runnable {
	private PipedOutputStream out;

	Writer(PipedOutputStream out) {
		this.out = out;
	}

	public void run() {
		try {
			out.write("���ǹܵ���".getBytes());
			out.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}