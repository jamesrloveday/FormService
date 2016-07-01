/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.service;

import com.application.rest.Forms.Image;
import java.util.List;

/**
 *
 * @author James Loveday
 */
public interface SiuNimTaoService {
    
    //------------ READ OPERATIONS ----------------//
    public List<Image> getAllImagesForForm(String form); 
    public List<Image> getAllImagesByTitle(String title); 
    public List<Image> getAllImagesBy(String form, String section); 
    public List<Image> getAllImagesBy(String title, String sectionName, String form); 
    
    //------------- CREATE OPERATIONS ----------------//
    public void saveImage(Image image);
    public void saveImage(String title, String sectionName, String form, String fileLocation); 
    
    //------------- UPDATE OPERATIONS ----------------//
    public void updateImage(Image image);
    public void updateImage(String title, String sectionName, String form, String fileLocation); 
    
    //------------- DELETE OPERATIONS -----------------//
    public void deleteImage(Image image);
      
}
