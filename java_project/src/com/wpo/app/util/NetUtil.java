package com.wpo.app.util;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 网络辅助类
 * 
 * @author Walker
 * 
 */
public class NetUtil {

	/**
	 * 判断机器的端口是否被占用
	 * 
	 * @param port
	 *            要检查的端口
	 * @return true 被占用 false未被占用
	 */
	public boolean isUsed(int port) {
		boolean ret = false;
		try {
			ServerSocket socket = new ServerSocket(port);
			ret = true;
		} catch (IOException e) {
		}
		return ret;
	}
}
