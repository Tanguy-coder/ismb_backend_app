package com.tanguydev.ismb.Domain.Ports;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageServiceInterface {
    void init();
    String save(MultipartFile file);
}
