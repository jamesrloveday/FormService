/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.controller;

import com.application.rest.Forms.Image;
import com.application.rest.service.SiuNimTaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author James Loveday
 */
@RestController("/wingchun")
public class SiuNimTaoController {
    
    @Autowired
    private SiuNimTaoService siuNimTaoService; 
    
    @RequestMapping(value = "/getAllImagesForForm", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Image> getAllImagesForForm(@RequestParam("form") String form) {
       return  siuNimTaoService.getAllImagesForForm(form);
    }
       
    
}
