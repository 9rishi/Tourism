package com.rishi.tourist.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rishi.tourist.service.ImageService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/image")
public class ImageController {

	//
	@Autowired
	ImageService imgService;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam(name = "image") MultipartFile file,
			@RequestParam(name = "empId") long empId) throws IOException {
		String uploadImg = imgService.uploadImage(file, empId);
		return new ResponseEntity<>(uploadImg, HttpStatus.OK);
	}

	// sending filebinary to outstream for first we will convert filebinary to
	// inputstream
	@GetMapping(path = "/{fileName}")
	public void downloadImage(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		byte[] fileBinary = imgService.downloadImage(fileName);
		response.setHeader("Content-Disposition",
				"attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + '"');
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentType("application/octet-stream");
		OutputStream outStream = response.getOutputStream();
		InputStream inputStream = new ByteArrayInputStream(fileBinary);
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		outStream.flush();
		outStream.close();
		inputStream.close();

	}

	// sending directly binary file to body
	@GetMapping(path = "file/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName) throws IOException {
		byte[] fileBinary = imgService.downloadImage(fileName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"").body(fileBinary);

	}
}
