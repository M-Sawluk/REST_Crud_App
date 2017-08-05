package com.michal.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.springboot.domain.File;
import com.michal.springboot.repository.FileRepo;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Mike on 2017-07-24.
 */
@RestController
public class FileController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileRepo fileRepo;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestParam("file") MultipartFile file, @RequestParam("a") String json) throws IOException {
        File f =new ObjectMapper().readValue(json , File.class);
//        f.setFile(file.getBytes());
        fileRepo.save(f);
    }

    @RequestMapping(value = "/showPdf/{id}" , produces = "application/pdf", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadPDFFile(@PathVariable Long id)
            throws IOException, Base64DecodingException {

        String file = fileRepo.findOne(id).getFile();
        logger.info("{}", file.length());

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(file));

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(byteArrayInputStream));
    }

    @RequestMapping(value = "/uploadBase" , method = RequestMethod.POST)
    public void up(@RequestBody File file){
        logger.info("{}",file);
        fileRepo.save(file);
    }


}
