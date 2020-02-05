package com.ideaas.services.exception;

/**
 * Created by Damian Saez on 13/12/2019.
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
