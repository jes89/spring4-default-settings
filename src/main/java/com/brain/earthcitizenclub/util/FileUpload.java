package com.brain.earthcitizenclub.util;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private FileOutputStream fos;
    
    public void writeFile(MultipartFile file, String path, String fileName){
         
        try{
            byte fileData[] = file.getBytes();
            fos = new FileOutputStream(path +  File.separator + fileName);
            fos.write(fileData);
        }catch(Exception e){
             
            e.printStackTrace();
             
        }finally{
             
            if(fos != null){
                 
                try{
                    fos.close();
                }catch(Exception e){}
                 
                }
        }
         
    }
}
