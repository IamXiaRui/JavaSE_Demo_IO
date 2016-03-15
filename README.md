##基本的IO流
###基本概念
1、IO流用来处理设备之间的数据传输。

2、Java中对数据的操作都是通过流的方式，而用于操作流的对象都在IO包: java.IO.* 中。

3、流按照操作数据分为两种：字节流和字符流；按照流向分为：输入流和输出流。

4、IO流常见基类：字节流的抽象基类：InputStream,OutputStream；字符流的抽象基类：Reader,Writer；

5、所有以四个基类名作为后缀名的都是相应的流。如FileInputStream是字节流，FileReader是字符流。

6、字符流的缓冲区：BufferWriter、BufferReader。缓冲区的出现提高了对数据的读写效率，但是必须结合流才能使用。


###IO异常处理方式

方式一：直接抛，throws IOExption

方式二：【标准】  try...catch...  


###FileWriter
1、先导包：import java.io.*;

2、创建(new)一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。而且该文件会被创建到指定的目录下。如果该目录下已有同名文件，将被覆盖。也就是明确数据要存放的目的地。

3、调用writer()方法将字符串写入到流中，然后刷新该流的缓冲写入数据到目的地：flush();

4、close() 关闭流资源，但是关闭之前会刷新一次内部的缓冲，将数据存入目的地中。与flush()的区别在于，flush刷新后流仍存在，close刷新后流关闭。

5、在FileWriter中传递一个true参数，代表不覆盖已有的文件，而是在已有文件的末尾处添加内容。

###FileReader
1、先导包：import java.io.*;

2、创建一个文件读取流对象和指定名称的文件相关联。且该文件是已经存在的，不存在则异常。

3、调用读取流对象的read（）方法。read方法一次读单个数据，且自动往下读。读到末尾返回-1。一般使用循环处理。

4、也可以通过字符数组进行读取，字符数组用于存储读到字符。该read(char[])返回的是读到字符个数，一般来说字符数组大小定义为1024。

###BufferWriter
1、先导包：import java.io.*;

2、创建一个字符写入流对象，再创建一个缓冲写入流对象，并相关联。

	new BufferWriter(new FileWriter());

3、记得刷新缓冲区：flush或者close。其实关闭缓冲区，就是在关闭缓冲区中的流对象，所以只需要关闭缓冲流即可。

>特别：
>>缓冲区提供了跨平台的换行符 newLine();


###BufferReader
1、先导包：import java.io.*;

2、创建一个读取流对象与文件相关联。

3、将字符流对象作为参数传递给缓冲读取流对象的构造函数。


>特别：
>>1、一次读取一行的字符，readLine(); 返回的是字符串String对象。

>>2、BufferReader装饰类LineNumberReader：跟踪行号的缓冲字符输入流。此类定义了方法
setLineNumber(int) 和 getLineNumber()，它们可分别用于设置和获取当前行号。


###字节流
1、字节流不需要刷新，但是必须关闭。

2、available(); 返回int，得到数据字节大小。用处：定义刚刚好的缓冲区，不需要循环。但谨慎使用，以循环为主。

3、得到流操作的具体时间，可以通过currentTimeMillis(); 来获取


###自定义字节流
1、read方法将byte强转成int型，而write方法将int强转成byte类型。

2、MP3文件一般通过二进制来存储，而在流操作中，可能出现连续8个1的情况，也就是-1，可能会直接结束操作。而11111111 提升成int类型是还是-1，因为前面补位的是1，如何在前面补0呢？
只需要将8个1 和 255的二进制相"与"即可。
 
>>为什么要补0呢？ 既可以保留原字节数据不变，又可以避免-1的出现。

###字符转换流
1、转换流是在字符流体系中。

2、InputStreamReader 是字节流通向字符流的桥梁：每次调用 InputStreamReader 中的一个 read() 方法都会导致从底层输入流读取一个或多个字节。

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

3、OutputStreamWriter 是字符流通向字节流的桥梁：每次调用 write() 方法都会导致在给定字符（或字符集）上调用编码转换器。在写入底层输出流之前，得到的这些字节将在缓冲区中累积。可以指定此缓冲区的大小，不过，默认的缓冲区对多数用途来说已足够大。注意，传递给 write() 方法的字符没有缓冲。必须刷新：flush();

	Writer out = new BufferedWriter(new OutputStreamWriter(System.out));

###流操作的基本规律

>如何确定需要使用的流对象？
>>1、明确源和目的

>>源：输入流   ： InputStream、Reader

>>目的：输出流  ：OutputStream、Writer

>>2、明确操作的数据是否是纯文本。
>
>>是纯文本：字符流
>
>>不是纯文本：字节流
>
>>3、当体系明确后，明确要使用的具体流对象。通过设备来进行区分。

>>源设备：内存、硬盘、键盘
>
>>目的设备：内存、硬盘、控制台


举例：

1、将一个文本文件中的数据存储到另一个文件中：复制文件

源：①使用读取流：InputStream、Reader

②是操作文件文件，纯文本，所以选择Reader

③明确设备：硬盘上的一个文件。Reader体系中可以操作文件的对象是FileReader

④需要提高效率：加入缓冲区：BufferedReader

目的：①使用写入流：OutputStream、Writer

②是纯文本，使用Writer

③Writer体系中可以操作文件的对象是FileWriter

④需要提高效率：加入缓冲区：BufferedWriter

2、将键盘录入的数据保存到一个文件中

源：①使用读取流：InputStream、Reader

②是操作文件文件，纯文本 ，所以选择Reader

③明确设备：键盘设备。对应的对象是System.in。为了操作键盘的文本数据方便，转成字符流。所以选择InputStreamReader

④需要提高效率：加入缓冲区：BufferedReader

目的：①使用写入流：OutputStream、Writer

②是纯文本，使用Writer

③设备：硬盘，一个文件，使用FIleWriter

④需要提高效率：加入缓冲区：BufferedWriter


`扩展：想要把录入的数据按照指定的编码表(如：utf-8)存入文件中，需要转换流：OutputStreamWriter，可以指定编码表。`

	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(),"utf-8");

>特殊：
>
>>1、标准输入;System.in   
>>标准输出;System.out
>>更改标准输入输出设备： setIn();  setOut();

>>2、异常信息可以打印到流中 : e.printStackTrace(PrintStream s)

>>3、日期信息格式化  导包 java.text.*;  （hh  改为 HH   就是为24进制）

##高级IO流
###打印流
1、PrintStream构造函数中可以接受的参数类型有：File对象、字符串路径String、字节输出流OutputStream。

2、PrintWriter构造函数中可以接受的参数类型有：File对象、字符串路径String、字节输出流OutputStream、字符输出流Writer。

3、PrintWriter(OutputStream out,boolean autoFlush)  ： autoFlush - boolean 变量；如果为 true，则 println、printf 或 format 方法将刷新输出缓冲区。

###合并流
1、SequenceInputStream 表示其他输入流的逻辑串联。它从输入流的有序集合开始，并从第一个输入流开始读取，直到到达文件末尾，接着从第二个输入流读取，依次类推，直到到达包含的最后一个输入流的文件末尾为止。

2、两个流：SequenceInputStream(InputStream s1, InputStream s2) ：通过记住这两个参数来初始化新创建的 SequenceInputStream（将按顺序读取这两个参数，先读取 s1，然后读取 s2），以提供从此 SequenceInputStream 读取的字节。

3、多个流：SequenceInputStream(Enumeration<? extends InputStream> e) ： 通过记住参数来初始化新创建的 SequenceInputStream，该参数必须是生成运行时类型为 InputStream 对象的 Enumeration 型参数。

>>注意：实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个。连续调用 nextElement 方法将返回一系列的连续元素，比如可以输出 Vector<E> v 的所有元素。


	public class SequenceTest {
	     public static void main(String[] args) throws IOException {
	            // Vector 类可以实现可增长的对象数组
	           Vector<FileInputStream> v = new Vector<FileInputStream>();
	            // 向集合中添加流
	            v.add( new FileInputStream("E:\\AllTestFile\\sequence_one.txt" ));
	            v.add( new FileInputStream("E:\\AllTestFile\\sequence_two.txt" ));
	            v.add( new FileInputStream("E:\\AllTestFile\\sequence_three.txt" ));
	            // 实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个
	            // Enumeration<E> elements() 返回此向量的组件的枚举。
	           Enumeration<FileInputStream> e = v.elements();
	            // 创建合并流对象
	           SequenceInputStream s = new SequenceInputStream( e);
	            // 写入操作
	           FileOutputStream f = new FileOutputStream("E:\\AllTestFile\\SequenceTest.txt" );
	            byte[] b = new byte[1024];
	            int length = 0;
	            while (( length = s.read( b)) != -1) {
	                 f.write( b, 0, length);
	           }
	            f.close();
	            s.close();
	     }
	}

>注意：
>
>>1、想要切割文件的话，只需要在循环中不断创建流，关闭流即可

>>2、切完合并需要用到合并流。

###操作对象流
1、ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream。可以使用 ObjectInputStream 读取（重构）对象。

2、ObjectInputStream 对以前使用 ObjectOutputStream 写入的基本数据和对象进行反序列化。
3、ObjectOutputStream 和 ObjectInputStream 分别与 FileOutputStream 和 FileInputStream 一起使用时，可以为应用程序提供对对象图形的持久存储。ObjectInputStream 用于恢复那些以前序列化的对象。

>>注意：必须实现序列化 java.io.Serializable 接口，否则抛出NotSerializableException异常。这是个标记接口，没有具体方法。

>特别：

>>1、序列化的UID是根据成员变量来确定的，不具有随机性。但是可以自定义UID,给类提供一个固定标识。
	private static final long serialVersionUID = 42L ；

>>2、静态变量不能被序列化。如果不想非静态的变量被序列化，可以添加关键字transient修饰变量。


###管道流
1、PipedInputStream 管道输入流应该连接到管道输出流；管道输入流提供要写入管道输出流的所有数据字节。

2、PipedOutputStream ：可以将管道输出流连接到管道输入流来创建通信管道。管道输出流是管道的发送端。

3、通常数据由某个线程从 PipedInputStream 对象读取，并由其他线程将其写入到相应的 PipedOutputStream。不建议对这两个对象尝试使用单个线程，因为这样可能死锁线程。 

>两种连接方式：
>>①、直接构造函数

	PipedOutputStream(PipedInputStream snk)
	          创建连接到指定管道输入流的管道输出流
>>②、通过方法连接

	 void	connect(PipedInputStream snk)
		          将此管道输出流连接到接收者。
###RandomAccessFile
1、随机访问文件，自身具备读写的方法。既可读也可写。

2、通过skipBytes(int x) , seek(int x)来实现随机访问。

3、不是IO体系中的子类，直接继承自Object。

4、其内部封装了一个数组，而且通过指针对数组的元素进行操作，getFilePointer获取指针位置，同时可以通过seek改变指针位置。

5、该类只能操作文件。操作文件具有模式：只读只写读写等。如果模式为只读，不会创建文件，会去读取一个已经存在的文件，如果该文件不存在，则会抛出异常。

6、该对象构造函数要操作的文件不存在则会自动创建，如果存在不会覆盖。
	
	/*
	 * RandomAccessFile的使用方法
	 * */
	public class RandomAccessFileTest {
	     public static void main(String[] args) throws IOException {
	            writerFile();
	            readerFile();
	     }
	     // 读取
	     public static void readerFile() throws IOException {
	           RandomAccessFile r = new RandomAccessFile("E:\\AllTestFile\\randomTest.txt" , "r" );
	            // 调整指针的位置 读取内容不同
	            r.seek(8);
	            byte[] b = new byte[4];
	            r.read( b);
	           String name = new String( b);
	            int age = r.readInt();
	           System. out.println( "name = " + name);
	           System. out.println( "age = " + age);
	            r.close();
	     }
	     // 写入
	     public static void writerFile() throws IOException {
	           RandomAccessFile r = new RandomAccessFile("E:\\AllTestFile\\randomTest.txt" , "rw" );
	            // 调整指针位置 插入位置不同
	            r.seek(8 * 3);
	            r.write( "夏睿".getBytes());
	            r.writeInt(97);
	            r.write( "胡斐".getBytes());
	            r.writeInt(100);
	            r. close();
	     }
	}

##Properties类
###基本概念
1、Properties是Hashtable的子类，具备了Map集合的特点，而且存储的键值对都是字符串，是集合中和IO技术相结合的集合容器。

2、特点：可以用于键值对形式的配置文件 

###存取文件

如何将流中的数据存储到集合中？

1、将一个流和文件相关联；

2、读取一行数据，用split("=")进行切割；

3、等号左边作为键，邮编作为值，存入到Properties集合中即可。

>>注意：也可以将流中的数据加载到集合中。

###配置文件
如何修改文件中的数据？

	store(FileOutputStream,String 注释)
>>注意：文件中的#开头的不被Properties所读取。文件中的数据需要有固定格式，也就是键=值。

###自定义配置文件

如何限制软件的使用次数？
	
	/*
	 * 利用Properties对象实现限制软件使用次数
	 * 
	 * */
	public class PropertyTest {
		public static void main(String[] args) throws IOException {
			// 创建Properties对象
			Properties pro = new Properties();
			File f = new File("E:\\AllTestFile\\apptime.properties");
			// 如果不存在配置文件 则创建
			if (!f.exists()) {
				f.createNewFile();
			}
			FileInputStream fis = new FileInputStream(f);
			// 关联输入流
			pro.load(fis);
			int count = 0;
			// 得到键相应的值
			String value = pro.getProperty("time");
	
			if (value != null) {
				count = Integer.parseInt(value);
				if (count >= 5) {
					System.out.println("对不起，使用时间已到，请注册!");
					return;
				}
			}
			// 计数器自增
			count++;
			String num = Integer.toString(count);
			// 填入相应的值
			pro.setProperty("time", num);
			FileOutputStream fos = new FileOutputStream(f);
			pro.store(fos, "");
			fis.close();
			fos.close();
		}
	}


>>用途：Android 记录软件的使用次数。



