package com.app.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	/**
	 * ファイルアップロードサービス
	 * 
	 * @param file アップロードしたファイル
	 */
	public void fileUpload(MultipartFile file);
}
