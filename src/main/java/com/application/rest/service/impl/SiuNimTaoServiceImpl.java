/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.service.impl;

import com.application.rest.Forms.Image;
import com.application.rest.service.SiuNimTaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author James Loveday
 */
@Component("siuNimTaoService")
public class SiuNimTaoServiceImpl implements SiuNimTaoService {
    
    private JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public SiuNimTaoServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; 
    }

    @Override
    public List<Image> getAllImagesForForm(String form) {
        return jdbcTemplate
                .queryForList("select * from IMAGE where form = ?", 
                        new Object[]{form}, Image.class); 
    }
    
}
