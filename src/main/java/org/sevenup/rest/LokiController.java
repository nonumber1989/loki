package org.sevenup.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@RestController
@RequestMapping("/test")
public class LokiController {
	// @Autowired
	// private CollerberationFileRepository fileRepository;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void saveFile() throws IOException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("lokiGridFS");
		// Location of file to be saved
		String imageLocation = "E:/steven.png";
		// Create instance of GridFS implementation
		GridFS gridFs = new GridFS(db);
		// Create a file entry for the image file
		GridFSInputFile gridFsInputFile = gridFs.createFile(new File(imageLocation));
		// Set a name on GridFS entry
		gridFsInputFile.setFilename("image1");
		// Save the file to MongoDB
		gridFsInputFile.save();
	}

	@RequestMapping(method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) throws IOException {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("lokiGridFS");
		// Create instance of GridFS implementation
		GridFS gridFs = new GridFS(db);
		// Find the image with the name image1 using GridFS API
		GridFSDBFile outputImageFile = gridFs.findOne("image1");
		// Get the number of chunks
		System.out.println("Total Chunks: " + outputImageFile.numChunks());
		// Location of the image read from MongoDB to be written
		String imageLocation = "E:/steven1.png";
		outputImageFile.writeTo(imageLocation);
		mongo.close();
	}

	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(name + "-uploaded")));
				stream.write(bytes);
				stream.close();
				return "You successfully uploaded " + name + " into " + name + "-uploaded !";
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	// ResponseEntity<byte[]>
	public void download(HttpServletRequest request, @RequestParam(value = "filename") String filename)
			throws IOException {
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		File file = new File(realPath, filename);
		if (!file.exists()) {
			throw new FileNotFoundException("文件名称：" + filename + "\n对不起，资源已被删除或者不再提供该资源的下载服务！");
		}
		// 第一步：创建HttpHeaders
		HttpHeaders httpHeaders = new HttpHeaders();
		// 第二步：设置HttpHeaders的数据类型为任意二进制附件
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 第三步：设置attachment附件的名称【貌似不能直接使用传递过来的filename参数】
		httpHeaders.setContentDispositionFormData("attachment",
				new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"));
		// 第四步：创建响应主题
		// (FileUtils.readFileToByteArray(file)
		// return new ResponseEntity<>(file., httpHeaders, HttpStatus.CREATED);
	}
}