package com.example.mutiparttest.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.jvm.hotspot.runtime.Bytes;

import java.io.*;

@RestController
public class TestController {


    @GetMapping("/test")
    public String testGet() {

        return "TestGet";
    }

    @PostMapping("/test")
    public String testPost(@RequestParam("file")MultipartFile multipartFile) throws IOException{

        String originalFileName = multipartFile.getOriginalFilename();
        File destination = new File("/Users/kimseojeong/Desktop/testdir/" + originalFileName);

        StringBuilder sb = new StringBuilder();

        try{
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()));
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            br.close();

            multipartFile.transferTo(destination);
        }catch(IOException e){
            return "error";
        }
        return sb.toString();
    }
}
