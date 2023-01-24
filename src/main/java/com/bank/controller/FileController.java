package com.bank.controller;

import com.bank.model.File;
import com.bank.service.FileService;
import com.bank.service.FileServiceImpl;
import com.bank.service.helpers.FileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequestMapping
@RestController
@RequiredArgsConstructor

public class FileController {
    private final FileService fileService;


    @PostMapping("/registration/upload")
    public FileRequest uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        File attachment = null;
        String downloadUrl= "";
        attachment = fileService.saveAttachment(file);
        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/registration/download/").path(attachment.getFileName())
                .toUriString();
        return new FileRequest(
                attachment.getFileName(),
                downloadUrl,file.getContentType(), file.getSize(), attachment.getClient_id()
        );
    }


    @GetMapping("/registration/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) throws Exception {
        File file = null;
        file = fileService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "file; filename=\"" +file.getFileName()+"\"" )
                .body(new ByteArrayResource(file.getData()));
    }

}
