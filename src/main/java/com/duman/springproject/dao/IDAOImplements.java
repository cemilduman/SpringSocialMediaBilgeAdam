package com.duman.springproject.dao;

import java.sql.Connection;
import java.util.List;

import com.duman.springproject.dto.SubscriberDto;
import com.duman.springproject.utils.DatabaseConnection;

public interface IDAOImplements <T>{
    void insert(T t);
    void update(T t);
    void delete(T t);
    List<T> listing();

    default Connection getInterfaceConnection() {
       return DatabaseConnection.getInstance().getConnection();
    }
}
