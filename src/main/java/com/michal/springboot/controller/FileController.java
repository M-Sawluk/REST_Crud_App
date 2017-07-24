package com.michal.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.springboot.domain.File;
import com.michal.springboot.repository.FileRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Mike on 2017-07-24.
 */
@RestController
public class FileController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileRepo fileRepo;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file, @RequestPart("a") String json) throws IOException {

        File f =new ObjectMapper().readValue(json , File.class);
        logger.error("{}", f);
        File filee = new File();
        filee.setId(1L);

        filee.setFile(file.getBytes());

        fileRepo.save(filee);
    }


}
