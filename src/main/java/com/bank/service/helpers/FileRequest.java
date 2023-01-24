package com.bank.service.helpers;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

public class FileRequest {
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private Long fileSize;
    private Long client_id;
}
