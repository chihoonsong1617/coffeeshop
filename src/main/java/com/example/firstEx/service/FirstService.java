package com.example.firstEx.service;

import com.example.firstEx.domain.Product;
import com.example.firstEx.repository.FirstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FirstService {

    @Autowired
    FirstRepository fr;

    public void saveProduct(String name, Long price) {
        fr.create(name, price);
    }

    public HashMap<Integer, Product> readAll() {
        return fr.readAll();
    }

    public Product readByName(String name) {
        return fr.readByName(name);
    }

    public Product readByPrice(Long price) {
        return fr.readByPrice(price);
    }
}
