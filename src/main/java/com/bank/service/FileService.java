package com.bank.service;

import com.bank.model.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    File saveAttachment(MultipartFile file) throws Exception;

    File getFile(Long fileId) throws Exception;
}
