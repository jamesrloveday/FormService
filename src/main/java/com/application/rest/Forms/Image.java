/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.rest.Forms;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author James Loveday
 */
@Entity
@Table(name = "IMAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i"),
    @NamedQuery(name = "Image.findById", query = "SELECT i FROM Image i WHERE i.id = :id"),
    @NamedQuery(name = "Image.findByFileLocation", query = "SELECT i FROM Image i WHERE i.fileLocation = :fileLocation"),
    @NamedQuery(name = "Image.findByForm", query = "SELECT i FROM Image i WHERE i.form = :form"),
    @NamedQuery(name = "Image.findBySectionName", query = "SELECT i FROM Image i WHERE i.sectionName = :sectionName"),
    @NamedQuery(name = "Image.findByTitle", query = "SELECT i FROM Image i WHERE i.title = :title")})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "FILE_LOCATION")
    private String fileLocation;
    @Size(max = 50)
    @Column(name = "FORM")
    private String form;
    @Size(max = 50)
    @Column(name = "SECTION_NAME")
    private String sectionName;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;

    public Image() {
    }

    public Image(Integer id) {
        this.id = id;
    }
    
    public Image(int id, String fileLocation, String form, String sectionName, String title) {
        this.id = id;
        this.fileLocation = fileLocation;
        this.form = form;
        this.sectionName = sectionName;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.rest.Forms.Image[ id=" + id + " ]";
    }
    
}
