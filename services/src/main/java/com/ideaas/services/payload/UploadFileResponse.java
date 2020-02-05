package com.ideaas.services.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

/**
 * Created by Damian Saez on 13/12/2019.
 */
@Component
public class UploadFileResponse {

    private String fileName;
    private String fileDownloadUrl;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fileType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contentAsString;
    private long size;

    public UploadFileResponse() { }

    public UploadFileResponse(String fileName, String contentAsString, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.contentAsString = contentAsString;
        this.fileDownloadUrl = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUrl = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }


    public String getContentAsString() {
        return contentAsString;
    }

    public void setContentAsString(String contentAsString) {
        this.contentAsString = contentAsString;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUrl() {
        return fileDownloadUrl;
    }

    public void setFileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}