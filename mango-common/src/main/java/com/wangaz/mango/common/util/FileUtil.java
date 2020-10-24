package com.wangaz.mango.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

public class FileUtil {

	public static void downloadFile(HttpServletResponse response,File file,String fileName) throws Exception {
		BufferedOutputStream bos = null;
		InputStream is =  null;
		BufferedInputStream bis = null;
		try {
			response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes("ISO-8859-1"),"UTF-8"));
			bos = new BufferedOutputStream(new FileOutputStream(file));
			is = new FileInputStream(file.getAbsolutePath());
			bis = new BufferedInputStream(is);
			int length = 0;
			byte[] temp = new byte[1*1024*10];
			while ((length = bis.read(temp)) != -1) {
				bos.write(temp,0,length);
			}
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
				bis.close();
			}
			if(bos != null) {
				bos.close();
			}
			if(is != null) {
				is.close();
			}
		}
	}
}
