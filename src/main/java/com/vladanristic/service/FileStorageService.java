package com.vladanristic.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String storeFile(MultipartFile file) throws Exception;
    Resource loadFileAsResource(String fileName) throws Exception;
}
