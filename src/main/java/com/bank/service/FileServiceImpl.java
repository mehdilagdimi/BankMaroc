package com.bank.service;

import com.bank.model.File;
import com.bank.repository.FileRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepo fileRepo;
    @Override
    public File saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid");
            }
            File file1 = new File(fileName, file.getContentType(), file.getBytes());
            return fileRepo.save(file1);
        } catch (Exception e) {
            throw new Exception("could not  save the file "+fileName);
        }
    }

    @Override
    public File getFile(Long fileId) throws Exception {
        return fileRepo.findById(fileId).orElseThrow(()->new Exception("file not found with id = "+fileId));
    }
}
