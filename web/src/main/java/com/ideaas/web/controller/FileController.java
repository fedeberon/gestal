package com.ideaas.web.controller;

import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.service.FileServiceImpl;
import com.ideaas.services.service.interfaces.CertificadoService;
import com.ideaas.services.service.interfaces.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/file")
public class FileController {


    @Value("${file.upload-dir}")
    private String filePath;

    @Autowired
    private CertificadoService certificadoService;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file,
                             @RequestParam Long idCertificado,
                             RedirectAttributes redirectAttributes) {

        Certificado certificado = certificadoService.get(idCertificado);

        fileService.guardarImagen(file, certificado);
        redirectAttributes.addAttribute("idCertificado", certificado.getId());

        return "redirect:/certificado/list";
    }

    @GetMapping("download/{hash}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String hash, @PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(hash, fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; folder, filename=\"" + hash + "\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
