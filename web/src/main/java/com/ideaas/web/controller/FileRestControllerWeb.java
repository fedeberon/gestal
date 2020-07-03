package com.ideaas.web.controller;

import com.ideaas.services.bean.FileUtil;
import com.ideaas.services.payload.UploadFileResponse;
import com.ideaas.services.service.FileServiceImpl;
import com.ideaas.services.service.interfaces.FileStorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipFile;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("api/file")
public class FileRestControllerWeb {
    private static final Logger logger = LoggerFactory.getLogger(FileRestControllerWeb.class);

    @Value("${file.upload-dir}")
    private String destination;

    @Value("${file.upload-dir-temp}")
    private String destinationTemp;

    private FileStorageService fileStorageService;

    private FileServiceImpl fileService;

    @Autowired
    public FileRestControllerWeb(FileStorageService fileStorageService, FileServiceImpl fileService) {
        this.fileStorageService = fileStorageService;
        this.fileService = fileService;
    }

    @PostMapping("upload")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/file/download/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUrl,
                file.getContentType(), file.getSize());
    }

    @PostMapping("uploadFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    private UploadFileResponse createFile(Path path){
        String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/file/download/")
                .path(path.toFile().getName())
                .toUriString();

        File file = path.toFile();
        String mimeType = FileUtil.getMimeType(file.getName());
        if(Objects.nonNull(mimeType) && mimeType.equals("text/html")){
            String content = FileUtil.readLineByLineJava8(path.toString());
            return new UploadFileResponse(file.getName(), content, fileDownloadUrl, mimeType, file.length());
        }

        else return new UploadFileResponse(file.getName(), fileDownloadUrl, FileUtil.getMimeType(file.getName()), file.length());
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
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; folder, filename=\"" + hash + "\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
