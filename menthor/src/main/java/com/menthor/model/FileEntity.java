package com.menthor.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "File")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "upload_id")
    private UserEntity userEntity1;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "upload_date")
    private Date uploadDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserEntity1() {
        return userEntity1;
    }

    public void setUserEntity1(UserEntity userEntity1) {
        this.userEntity1 = userEntity1;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
