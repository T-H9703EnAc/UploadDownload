package com.app.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class DownloadServiceImpl implements DownloadService {

	@Override
	public void fileDownload(HttpServletResponse response) {
		try (InputStream inputStream = new FileInputStream("./src/main/resources/uploadFile/test.txt");
				OutputStream outputStream = response.getOutputStream();) {

			byte[] fileByteArray = inputStream.readAllBytes();

			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=test.txt");
			response.setContentLength(fileByteArray.length);

			outputStream.write(fileByteArray);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
