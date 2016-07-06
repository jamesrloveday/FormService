/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.rowMapper;

import com.application.rest.Forms.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author James Loveday
 */
public class ImageRowMapper implements RowMapper<Image> {

    @Override
    public Image mapRow(ResultSet rs, int i) throws SQLException {
        Image image = new Image();
        image.setId(rs.getInt("id"));
        image.setFileLocation(rs.getString("file_location"));
        image.setForm(rs.getString("form"));
        image.setSectionName(rs.getString("section_name"));
        image.setTitle(rs.getString("title"));
       return image; 
    }
    
}
