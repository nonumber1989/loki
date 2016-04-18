package org.sevenup.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@RestController
@RequestMapping("/files")
public class FileController {

	// @Autowired
	// private GridFsTemplate gridFsTemplate;

	// @CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public void handleFileUpload(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// MultipartHttpServletRequest multipartRequest =
		// (MultipartHttpServletRequest) request;
		Map<String, String[]> formMap = request.getParameterMap();
		request.getContentType();
		request.getHeaderNames();
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();

		InputStream fileContent = filePart.getInputStream();
		DBObject metaData = new BasicDBObject();
		metaData.put("author", "steven.xu");

		// gridFsTemplate.store(fileContent, fileName,
		// filePart.getContentType(),metaData);
		// List<Part> fileParts = (List<Part>) request.getParts();
		// for (Part filePart : fileParts) {
		// String fileName = filePart.getSubmittedFileName();
		// InputStream fileContent = filePart.getInputStream();
		// }

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("lokiGridFS");
		// Location of file to be saved
		GridFS gridFs = new GridFS(db);
		// Create a file entry for the image file
		GridFSInputFile gridFsInputFile = gridFs.createFile(fileContent);
		// Set a name on GridFS entry
		gridFsInputFile.setFilename("teststecebeebeb");
		// Save the file to MongoDB
		gridFsInputFile.save();
		mongo.close();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/download")
	public  void handleFileDownload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("lokiGridFS");
		// Create instance of GridFS implementation
		GridFS gridFs = new GridFS(db);
		// Find the image with the name image1 using GridFS API
		GridFSDBFile outputImageFile = gridFs.findOne("teststecebeebeb");
		// Get the number of chunks
		System.out.println("Total Chunks: " + outputImageFile.numChunks());
		// Location of the image read from MongoDB to be written
		// String imageLocation = "E:/steven1.png";
		// outputImageFile.writeTo(imageLocation);
		InputStream test = outputImageFile.getInputStream();
		mongo.close();
	}
}
