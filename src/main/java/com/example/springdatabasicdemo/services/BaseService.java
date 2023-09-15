package com.example.springdatabasicdemo.services;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID>{

    T create(T t);

    void destroy(T t);

    void destroyById(ID id);

    Optional<T> find(ID id);

    List<T> getAll();

}
