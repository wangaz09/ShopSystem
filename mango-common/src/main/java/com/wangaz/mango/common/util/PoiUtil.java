package com.wangaz.mango.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;

public class PoiUtil {
	
	static final String suffix = ".xlsx";
	
	public static File createExcelFile(Workbook workbook,String fileName) throws Exception {
		OutputStream outputStream = null;
		File file = null;
		try {
			file = File.createTempFile(fileName, suffix);
			outputStream = new FileOutputStream(file.getAbsoluteFile());
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(workbook != null) {
				workbook.close();
			}
			if(outputStream != null) {
				outputStream.close();
			}
		}
		return file;
	}

}
