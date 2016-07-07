/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.service.impl.siuNimTaoServices;

import com.application.rest.Forms.Image;
import com.application.rest.rowMapper.ImageRowMapper;
import com.application.rest.service.SiuNimTaoService;
import com.application.rest.utils.Incrementer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author James Loveday
 */
@Component("siuNimTaoService")
public  class SiuNimTaoServiceImpl implements SiuNimTaoService {
    
    private final JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public SiuNimTaoServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; 
    }

    @Override
    public List<Image> getAllImagesForForm(String form) {
        return (List<Image>) jdbcTemplate .query("select * from IMAGE where form = ?",  
                new Object[]{form}, new ImageRowMapper()); 
    }

    @Override
    public List<Image> getAllImagesByTitle(String title) {
        return (List<Image>) jdbcTemplate
                .query("select * from IMAGE where title = ?", new Object[]{title}, new ImageRowMapper()); 
    }

    @Override
    public List<Image> getAllImagesBy(String form, String section) {
        return (List<Image>) jdbcTemplate
                .query("select * from IMAGE where form = ? and section_name = ?", 
                        new Object[]{form, section}, 
                        new ImageRowMapper()); 
    }

    @Override
    public List<Image> getAllImagesBy(String title, String sectionName, String form) {
        return (List<Image>) jdbcTemplate
                .query("select * from IMAGE where title = ? and section_name = ? and form = ?", 
                        new Object[]{title, sectionName.toLowerCase(), form}, new ImageRowMapper()); 
    }

    @Override
    public void saveImage(Image image) {
        int id = Incrementer.getAndIncrement(jdbcTemplate.getMaxRows()); 
        int count = jdbcTemplate.update("insert into image(id, file_location, form, section_name, title) values(?, ?, ?, ?, ?)", 
                new Object[]{id, image.getFileLocation(), image.getForm(), image.getSectionName(), image.getTitle()}); 
    }

    @Override
    public void saveImage(String title, String sectionName, String form, String fileLocation) {
        int id = Incrementer.getAndIncrement(jdbcTemplate.getMaxRows()); 
        Image image = new Image(id, fileLocation, form, sectionName, title); 
        this.saveImage(image);
    }

    @Override
    public void updateImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateImage(String title, String sectionName, String form, String fileLocation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteImage(Image image) {
        jdbcTemplate.update("delete from image where id = ?", new Object[]{image.getId()});
    }
    
}
