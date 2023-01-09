package com.app.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
	
	/**
	 * ファイルをInputStreamに変換し、出力用ファイルオブジェクトを作成してOutputStreamに変換し
	 * InputStreamの内容を読み込んでOutputStreamに出力する。
	 * @param file アップロードしたファイル  
	 */
	@Override
	public void fileUpload(MultipartFile file) {
		// 出力先パス+ファイル名を作成
		String path = "./src/main/resources/uploadFile/" + file.getOriginalFilename();
		
		// ファイルオブジェクトを作成
		File convFile = new File(path);

		try (InputStream inputStream = file.getInputStream();
				OutputStream outputStream = new FileOutputStream(convFile)) {
			int read = 0;
			byte[] bytes = new byte[1024];
			
			// InputStreamの内容を読み込んでOutputStreamに出力する。
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
