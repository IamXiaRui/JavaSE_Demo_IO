package xr_io_systemin;

/*
 * �Ӽ���¼���ַ��� ׷�ӵ�ԭ�е��ļ���
 * */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SystemInTest_one {

	public static void main(String[] args) throws IOException {
		System.out.println("���������� ��");
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		// ���ַ���ת��Ϊ�ֽ�����
		byte[] b1 = in.getBytes();
		// �Ƿ�׷�ӱ�־��
		boolean flag = true;
		BufferedOutputStream output = new BufferedOutputStream(
				new FileOutputStream("E:\\AllTestFile\\BuffCopyFileTest.txt", flag));

		output.write(b1);
		output.close();

	}

}
