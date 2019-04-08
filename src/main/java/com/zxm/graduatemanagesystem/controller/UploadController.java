package com.zxm.graduatemanagesystem.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zxm.graduatemanagesystem.util.Uploader;

@RestController
public class UploadController {

    @RequestMapping("/uploadUEImage")
    public String uploadUEImage(MultipartFile upfile, HttpServletRequest request) throws Exception{
        Uploader up = new Uploader(request);
        up.setSavePath("/upload");
        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        up.upload(upfile);

        String callback = request.getParameter("callback");
        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize()
                +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";

        result = result.replaceAll( "\\\\", "\\\\" );
        if(callback == null ){
            return result ;
        }else{
            return "<script>"+ callback +"(" + result + ")</script>";
        }
    }

    @RequestMapping("/upload/{uploadDate}/{fileName:[a-zA-Z0-9\\.]+}")
    public ResponseEntity getUploadFile(@PathVariable("uploadDate") String uploadDate,
                                        @PathVariable("fileName") String fileName) throws Exception {

        String path = "/upload/" + uploadDate + "/" +fileName;
        File picFile = new File(Uploader.getPhysicalPath(path));

        byte[] result = FileUtils.readFileToByteArray(picFile);

        return ResponseEntity.ok() //
                .contentLength(result.length) //
                .contentType(MediaType.IMAGE_JPEG) //
                .body(result);
    }
}