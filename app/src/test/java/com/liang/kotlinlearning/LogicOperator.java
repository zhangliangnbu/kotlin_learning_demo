package com.liang.kotlinlearning;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class LogicOperator {

	private byte a = 1 >> 2;

	private void testWhile() {
		int a = 0;
		while ((a = a + 1) < 5) {
			System.out.print(a);
		}
	}

	private void readIS(InputStream is) throws Exception {
		int len = 0;
		byte[] bytes = new byte[1024];
		OutputStream os = new FileOutputStream("/file/text.txt");
		while ((len = is.read(bytes)) != -1) {
			os.write(bytes, 0, len);
		}
	}
}