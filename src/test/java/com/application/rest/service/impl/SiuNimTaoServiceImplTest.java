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
    
    @Before
    public void setUp() {
        siuNimTaoService = new SiuNimTaoServiceImpl(jdbcTemplate); 
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllImagesForForm method, of class SiuNimTaoServiceImpl.
     */
    @Test
    public void canGetAllImagesForFormSiuNimTao() {
        String form = "Siu nim tao"; 
        List<Image> imagesTest = siuNimTaoService.getAllImagesForForm(form); 
        assertTrue("Images test list for form should not be null", imagesTest != null); 
    }
    
    @Test
    public void canGetAllImagesForBasicStanceTitle() {
        String title = "basic stance"; 
        List<Image> imagesTest = siuNimTaoService.getAllImagesByTitle(title); 
        assertTrue("Images test list for title should not be null", imagesTest != null); 
    }
    
    @Test
    public void canGetAllImagesForFormSiuNimTaoAndSectionSection1() {
        String form = "Siu nim tao"; 
        String section = "section 1";
        List<Image> imagesTest = siuNimTaoService.getAllImagesBy(form, section);
        assertTrue("Images test list for form and section should not be null", imagesTest != null); 
    }
    
}
