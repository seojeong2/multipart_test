package com.example.mutiparttest.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.web.multipart.MultipartFile;


public class WavFile {
    private String filePath;
    private MultipartFile file;

    public WavFile(String filePath, MultipartFile file) {
        this.filePath = filePath;
        this.file = file;
    }

    public String getFilePath() {
        return filePath;
    }

    public MultipartFile getFile() {
        return file;
    }

}
