package AhmetTanrikulu.HRMSBackend.api.controllers;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import AhmetTanrikulu.HRMSBackend.business.abstracts.ImageService;
import AhmetTanrikulu.HRMSBackend.core.Service.CloudinaryService;
import AhmetTanrikulu.HRMSBackend.core.utilities.results.DataResult;
import AhmetTanrikulu.HRMSBackend.entities.concretes.Image;


@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class ImagesController {

	
	CloudinaryService cloudinaryService;	
	ImageService imageService;
	
	@Autowired
	public ImagesController(CloudinaryService cloudinaryService, ImageService imageService) {
		super();
		this.cloudinaryService = cloudinaryService;
		this.imageService = imageService;
	}


	@GetMapping("getAll")
	public ResponseEntity<List<Image>> getAll(){
		
		List<Image> list  = this.imageService.getAll().getData();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("getallbyuserid")
	public DataResult<Image> getByUserId (int userId){
		
		return this.imageService.getByUserId(userId);
	}
	
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload (@ModelAttribute Image image,MultipartFile multipartFile) throws IOException{
		
		BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
		if(bufferedImage == null) {
			
			return new ResponseEntity<>("Resim yüklenemedi",HttpStatus.BAD_REQUEST);
		}
		
		Map uploadResult= cloudinaryService.upload(multipartFile);
		
		image.setName((String)uploadResult.get("original_filename"));
		image.setImageUrl((String)uploadResult.get("url"));
		image.setImageId((String)uploadResult.get("public_id"));
	
		
		this.imageService.add(image);
		return new ResponseEntity<>("Resim yüklendi",HttpStatus.OK);
	}
	
	
}