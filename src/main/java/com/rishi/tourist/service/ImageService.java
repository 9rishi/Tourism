package com.rishi.tourist.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rishi.tourist.dao.ImageRepository;
import com.rishi.tourist.model.Image;

@Service
public class ImageService {
	
	//
	@Autowired
	ImageRepository imgRepository;
//	, long empId
	public String uploadImage(MultipartFile file, long empId) throws IOException {
	Image img =  imgRepository.save(Image.builder().fileName(file.getOriginalFilename()).imageData(file.getBytes()).build());
	if(img != null) {
		return "file uploaded successfully"+file.getOriginalFilename();
	}
	return null;
	}
	
	public byte[] downloadImage (String fileName) {
		Optional<Image> downloadImg = imgRepository.findByFileName(fileName);
    	byte[] images = downloadImg.get().getImageData();
		return images;
	}
}
