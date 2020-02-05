package com.ideaas.api.restController;

/**
 * Created by Damian Saez on 13/12/2019.
 */

import com.ideaas.services.bean.FileUtil;
import com.ideaas.services.payload.UploadFileResponse;
import com.ideaas.services.service.interfaces.FileService;
import com.ideaas.services.service.interfaces.FileStorageService;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

@CrossOrigin
@RestController
@RequestMapping("api/file")
public class FileRestController {

    private static final Logger logger = LoggerFactory.getLogger(FileRestController.class);

    @Value("${file.upload-dir}")
    private String destination;

    @Value("${file.upload-dir-temp}")
    private String destinationTemp;

    private FileStorageService fileStorageService;

    private FileService fileService;

    @Autowired
    public FileRestController(FileStorageService fileStorageService, FileService fileService) {
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

    @GetMapping("download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @PostMapping("/uploadZip")
    public List<UploadFileResponse> add(@RequestParam("file") MultipartFile file) throws IOException {

        /**
         * save file to temp
         */
        File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
        FileOutputStream o = new FileOutputStream(zip);
        IOUtils.copy(file.getInputStream(), o);
        o.close();

        /**
         * unizp file from temp by zip4j
         */
        try {
            ZipFile zipFile = new ZipFile(zip);
            zipFile.extractAll(destinationTemp);
            File filesTemp = new File(destinationTemp);

            try (Stream<Path> paths = Files.walk(Paths.get(filesTemp.toURI()))) {
                return paths
                        .filter(Files::isRegularFile)
                        .map(path -> createFile(path))
                        .collect(Collectors.toList());
            }

        } catch (ZipException e) {
            e.printStackTrace();

            return null;
        } finally {
            /**
             * delete temp file
             */
            zip.delete();
        }
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
}