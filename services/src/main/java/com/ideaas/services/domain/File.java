package com.ideaas.services.domain;

/**
 * Created by Damian Saez on 19/12/2019.
 */

public class File {

    private Long id;

    private String fileUrl;

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

}
