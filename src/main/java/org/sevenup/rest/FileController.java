package org.sevenup.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController {
//	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public void handleFileUpload(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, String[]> formMap = request.getParameterMap();

		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		InputStream fileContent = filePart.getInputStream();
		// List<Part> fileParts = (List<Part>) request.getParts();
		// for (Part filePart : fileParts) {
		// String fileName = filePart.getSubmittedFileName();
		// InputStream fileContent = filePart.getInputStream();
		// }
	}
}
