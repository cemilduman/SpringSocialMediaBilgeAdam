package com.duman.springproject.utils;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DatabaseInformation {
    private String url;
    private String userName;
    private String password;
    private String forNameData;

    public DatabaseInformation(){
        this.url = "jdbc:mysql://localhost:3306/bilgeadam_blog";
        this.userName = "root";
        this.password = "root";
        this.forNameData = "com.mysql.jdbc.Driver";
    }
}
