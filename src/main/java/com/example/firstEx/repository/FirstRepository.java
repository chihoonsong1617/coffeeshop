package com.example.firstEx.repository;

import com.example.firstEx.domain.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class FirstRepository {

    private final HashMap<Integer, Product> db = new HashMap<>();

    private static int num = 0;
    public void create(String name, Long price) {
        Product product = new Product(name, price);
        db.put(++num, product);
    }

    public Product readByName(String name) {
        ArrayList<Integer> keyset = new ArrayList<>(db.keySet());
        for (int i=0; i<keyset.size(); i++) {
            if (db.get(keyset.get(i)).getName().equals(name)) {
                return db.get(keyset.get(i));
            }
        }
        return null;
    }

    public Product readByPrice(Long price) {
        ArrayList<Integer> keyset = new ArrayList<>(db.keySet());
        for (int i=0; i<db.size(); i++) {
            if (db.get(keyset.get(i)).getPrice() == price) {
                return db.get(keyset.get(i));
            }
        }
        return null;
    }

    public HashMap<Integer, Product> readAll() {
        HashMap<Integer, Product> map = new HashMap<>(db);
        return map;
    }
    public void update() {

    }

    public Product delete() {
        return null;
    }
}
