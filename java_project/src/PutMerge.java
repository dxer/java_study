import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class PutMerge {

	private InputStream in = null;
	private OutputStream out = null;
	private String localPath;
	private String hdfsPath;

	public PutMerge(String localPath, String hdfsPath) {
		this.localPath = localPath;
		this.hdfsPath = hdfsPath;
	}

	public void start() throws Exception {
		File file = new File(localPath);
		Configuration conf = new Configuration();

		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		out = fs.create(new Path(hdfsPath));

		work(file);

		close();
	}

	/*
	 * 1.根据用户定义的参数设置本地目录和HDFS的目标文件
	 * 
	 * 2.创建一个输出流写入到HDFS文件
	 * 
	 * 3.遍历本地目录中的每个文件，打开文件，并读取文件内容，将文件的内容写到HDFS文件中。
	 */
	private void work(File file) throws Exception {
		if (file.isFile()) {
			int byteRead = 0;
			byte[] buffer = new byte[256];
			while ((byteRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, byteRead);
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					in = new BufferedInputStream(new FileInputStream(files[i]));
					int byteRead = 0;
					byte[] buffer = new byte[256];
					while ((byteRead = in.read(buffer)) > 0) {
						out.write(buffer, 0, byteRead);
					}
				} else {
					work(files[i]);
				}
			}
		}
	}

	private void close() throws IOException {
		if (in != null) {
			in.close();
		}

		if (out != null) {
			out.close();
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage:\n\t " + PutMerge.class.getName()
					+ " [LocalPath] [HDFSPath]");
			System.exit(1);
		}
		new PutMerge(args[0], args[1]).start();
	}
}
