package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUpload2 {
	@RequestMapping("/singleFileUpload")
	public void oneFileUpload(@RequestParam String username,
			@RequestParam MultipartFile uploadFile, HttpServletRequest request) {
		try {
			System.out.println("username=" + username);
			MultipartFile file = uploadFile;
			String uploadFileName = file.getOriginalFilename();

			InputStream isRef = file.getInputStream();

			String targetDir = request.getSession().getServletContext()
					.getRealPath("/upload");
			File targetFile = new File(targetDir, uploadFileName);
			FileOutputStream fosRef = new FileOutputStream(targetFile);
			IOUtils.copy(isRef, fosRef);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
