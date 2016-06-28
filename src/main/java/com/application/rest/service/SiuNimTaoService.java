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
    
    public List<Image> getAllImagesForForm(String form); 
    
    
    
}
