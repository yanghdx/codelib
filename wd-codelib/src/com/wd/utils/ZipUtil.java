package com.wd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * 
 * 压缩文件夹
 * 
 * @author yang_huidi
 * @version 1.00
 * @date 2014年10月24日
 * @see
 * 
 */
public class ZipUtil {

	// LOGGER
	private static final Logger LOGGER = Logger.getLogger(ZipUtil.class);

	/**
	 * 输入一个文件夹 ，输出一个压缩文件
	 * 
	 * @author yang_huidi
	 * @param inputDir
	 */
	public static void zipDir(String inputDir) {
		File dir = new File(inputDir);
		if (!dir.exists() || !dir.isDirectory()) {
			LOGGER.info("压缩"+inputDir+"出错，不存在或不是目录");
			return;
		}
		String target = inputDir + ".zip"; // 打包后文件名字
		LOGGER.info("开始压缩"+inputDir);
		zip(target, new File(inputDir));
		LOGGER.info("压缩成功");
	}

	private static void zip(String zipFileName, File inputFile) {
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			zip(out, inputFile, "");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}

	}

	private static void zip(ZipOutputStream out, File f, String base)
			throws IOException {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = null;
			int b;
			try {
				in = new FileInputStream(f);
				while ((b = in.read()) != -1) {
					out.write(b);
				}
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error(e.getMessage(), e);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception e) {
					}
				}
			}

		}
	}

	public static void main(String[] temp) {
		ZipUtil.zipDir("d:\\哈哈");//
		
	}

}
