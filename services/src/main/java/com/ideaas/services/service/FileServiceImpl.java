package com.ideaas.services.service;

import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.Imagen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class FileServiceImpl{

    @Value("${file.upload-dir}")
    private String filePathCertificados;


    public File getVersionFile(File theDir, File theDirWithFile) {
        Integer version = 1;

        while(theDirWithFile.exists()){
            File fileRename = new File(theDir.getAbsolutePath() + "//" + getFileName(theDirWithFile) + "_V" + version + "." + getFileExtension(theDirWithFile));
            theDirWithFile.renameTo(fileRename);
            version++;
        }

        return theDirWithFile;
    }

    public String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    public String getFileName(File file) {
        String name = file.getName();
        try {
            return name.substring(0, name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }

    public List<Imagen> readFiles(String url) throws IOException {
        final List<Imagen> imagenes = new ArrayList<>();
        Files.walkFileTree(Paths.get(url), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                try {
                    imagenes.add(new Imagen(file.getFileName().toString(), false));
                }
                finally {
                    return FileVisitResult.CONTINUE;
                }
            }
        });
        Collections.sort(imagenes,new Comparator<Imagen>(){
            @Override
            public int compare(Imagen o1, Imagen o2) {
                return o1.getUrl().compareTo(o2.getUrl());
            }
        });

        return imagenes;
    }

    public void crearDirectorioParaImagenesDe(String codigo) {
        File fileCertificado = new File(filePathCertificados + codigo);
        if (!fileCertificado.exists()) {
            fileCertificado.mkdir();
        }
    }


    public void guardarImagen(MultipartFile file, Certificado certificado) {
        if (file.isEmpty()) return;
        try {
            File theDir;
            theDir = new File(filePathCertificados +  certificado.getColaborador().getId());

            File theDirWithFile = new File(theDir.getAbsolutePath() + "//" + file.getOriginalFilename());
            theDirWithFile = this.getVersionFile(theDir, theDirWithFile);

            if (!theDir.exists()) {
                theDir.mkdir();
            }

            file.transferTo(theDirWithFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }


}