package com.dogfriend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity //테이블 명시
// @Table(name = "user")
@Setter @Getter
public class User {

    @Id //기본키 명시
    private String id;
    
    @Column
    private String pw;
    
    // @Column
    // private String ProductKey;
}