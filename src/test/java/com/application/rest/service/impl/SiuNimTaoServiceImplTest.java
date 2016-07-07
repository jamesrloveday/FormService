/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.service.impl;

import com.application.rest.service.impl.siuNimTaoServices.SiuNimTaoServiceImpl;
import com.application.rest.FormServiceApplication;
import com.application.rest.Forms.Image;
import com.application.rest.service.SiuNimTaoService;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author James Loveday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FormServiceApplication.class)
public class SiuNimTaoServiceImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate; 
    private SiuNimTaoService siuNimTaoService; 
    private Image testImage; 
    private int counter = 1; 
    
    @Before
    public void setUp() {
        siuNimTaoService = new SiuNimTaoServiceImpl(jdbcTemplate);
        testImage = new Image(counter, "C:\\Documents\\fileLocation", "siu nim tao", "test section", "test title"); 
        siuNimTaoService.saveImage(testImage);
        counter++; 
    }
    
    @After
    public void tearDown() {
        jdbcTemplate.execute("delete from image where 1=1");
    }

    @Test
    public void canGetAllImagesForFormSiuNimTao() {
        String form = "siu nim tao"; 
        List<Image> imagesTest = siuNimTaoService.getAllImagesForForm(form); 
        assertTrue("Images test list for form should not be null", imagesTest.size() > 0); 
    }
    
    @Test
    public void canGetAllImagesForBasicStanceTitle() {
        String title = "test title"; 
        List<Image> imagesTest = siuNimTaoService.getAllImagesByTitle(title); 
        assertTrue("Images test list for title should not be null", imagesTest.size() > 0); 
    }
    
    @Test
    public void canGetAllImagesForFormSiuNimTaoAndSectionSection1() {
        String form = "siu nim tao"; 
        String section = "test section";
        List<Image> imagesTest = siuNimTaoService.getAllImagesBy(form, section);
        assertTrue("Images test list for form and section should not be null", imagesTest.size() > 0); 
    }

    @Test
    public void canGetAllImagesWithTitleSectionNameAndForm() {
        final String title = "test title"; 
        final String section = "test section"; 
        final String form = "siu nim tao";
        List<Image> imagesTest = siuNimTaoService.getAllImagesBy(title, section, form);
        assertTrue("Images test list for title, section and name should be > 0", imagesTest.size() > 0); 
    }
    
}
