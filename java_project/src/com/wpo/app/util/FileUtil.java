package com.wpo.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 文件辅助类
 * 
 * @author Walker
 * 
 */
public class FileUtil {

	/**
	 * 文件夹拷贝
	 * 
	 * @param src
	 *            原始文件路径
	 * @param dest
	 *            目的路径
	 * @throws Exception
	 */
	public static void copyDirectory(String src, String dest) throws Exception {
		File srcFile = new File(src);
		File destFile = new File(dest);
		copyDirectory(srcFile, destFile);
	}

	/**
	 * 文件夹拷贝
	 * 
	 * @param src
	 *            原始文件
	 * @param dest
	 *            目的路径
	 * @throws Exception
	 */
	public static void copyDirectory(File src, File dest) throws Exception {
		// 判断src文件是否存在
		if (!src.exists()) {
			throw new Exception("Source [" + src.getPath() + "] is not exist.");
		}

		// 判断src文件是否是文件夹
		if (!src.isDirectory()) {
			throw new Exception("Source [" + src.getPath()
					+ "] must be a directory.");
		}

		// 判断dest文件是否是文件夹
		if (!dest.isDirectory()) {
			throw new Exception("Destination [" + dest.getPath()
					+ "] is not a Directory.");
		}

		// 判断dest文件是否存在，不存在就创建
		if (!dest.exists()) {
			dest.mkdirs();
		}

		File[] fileList = src.listFiles();

		for (int i = 0; i < fileList.length; i++) {
			File file = fileList[i];
			if (file.isDirectory()) {
				copyDirectory(file, new File(dest, file.getName()));
			}

			if (file.isFile()) {
				copyFile(file, new File(dest, file.getName()));
			}
		}
	}

	/**
	 * 文件拷贝
	 * 
	 * @param src
	 *            原始文件的路径
	 * @param dest
	 *            目的路径
	 * @throws Exception
	 */
	public static void copyFile(String src, String dest) throws Exception {
		File srcFile = new File(src);
		File destFile = new File(dest);
		copyFile(srcFile, destFile);
	}

	/**
	 * 文件拷贝
	 * 
	 * @param src
	 *            原始文件的路劲
	 * @param dest
	 *            目的文件的路径
	 * @throws Exception
	 */
	public static void copyFile(File src, File dest) throws Exception {
		// 判断src是否存在
		if (!src.exists()) {
			throw new Exception("Source [" + src.getPath() + "] is not exist.");
		}

		// 判断dest文件是否存在
		if (dest.exists()) {
			throw new Exception("Destination [" + src.getPath() + "] is exist.");
		}

		FileChannel srcChannel = null;
		FileChannel destChannel = null;
		try {
			srcChannel = new FileInputStream(src).getChannel();
			destChannel = new FileOutputStream(dest).getChannel();
			srcChannel.transferTo(0, srcChannel.size(), destChannel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (destChannel != null) {
				destChannel.close();
			}

			if (srcChannel != null) {
				srcChannel.close();
			}
		}
	}
}
