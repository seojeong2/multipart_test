package com.example.mutiparttest.Controller;


import com.example.mutiparttest.domain.WavFile;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.web.bind.annotation.*;


import java.io.*;


@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String testGet() {

        return "TestGet";
    }


    @PostMapping("/test")
    public String testPost(@ModelAttribute WavFile wavFile) throws IOException{

        WavFile file = new WavFile(wavFile.getFilePath(),wavFile.getFile());

        String originalFileName = file.getFile().getOriginalFilename();
        //파일 확장자
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")+1);

        logger.info("File Extension: "+extension);

        File destination = new File(file.getFilePath() + originalFileName);

        StringBuilder sb = new StringBuilder();
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getFile().getInputStream()));
        ){
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            file.getFile().transferTo(destination);
        }catch(IOException e){
            return "error";
        }
        return sb.toString();
    }
}
