package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUpload {
	@RequestMapping("/oneFileUpload")
	public void oneFileUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("username=" + request.getParameter("username"));
			MultipartFile file = request.getFile("uploadFile");
			String uploadFileName = file.getOriginalFilename();

			InputStream isRef = file.getInputStream();
			System.out.println(request.getSession().getServletContext().getRealPath("/upload"));
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
