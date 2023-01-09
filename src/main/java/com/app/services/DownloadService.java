package com.app.services;

import jakarta.servlet.http.HttpServletResponse;

public interface DownloadService {
	public void fileDownload(HttpServletResponse response);
}
