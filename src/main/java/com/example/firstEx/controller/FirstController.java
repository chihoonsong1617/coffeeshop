package com.example.firstEx.controller;

import com.example.firstEx.domain.Product;
import com.example.firstEx.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class FirstController {

    @Autowired
    FirstService fs;

    @RequestMapping("/first")
    public String test() {
        return "Hello THIRD";
    }

    @GetMapping("/save")
    public String saveUrl(@RequestParam("name") String name, @RequestParam("price") Long price) {
        fs.saveProduct(name, price);
        System.out.println(name + " " + price);
        return "saved";
    }
    @GetMapping("/readAll")
    public String readAll() {
        HashMap<Integer, Product> map = fs.readAll();
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        String answer = "";
        for (int i=0; i<keySet.size(); i++) {
            answer += map.get(keySet.get(i)).getName();
            answer += " ";
            answer += map.get(keySet.get(i)).getPrice();
            answer += "\n";
        }
        return answer;
    }

    @GetMapping("/readByName")
    public String readByName(@RequestParam("name") String name) {
        System.out.println(name);
        Product product = null;
        if ((product = fs.readByName(name)) == null) {
            return "There is No...";
        }
        String answer = "";
        answer += product.getName();
        answer += " ";
        answer += product.getPrice();
        return answer;
    }

    @GetMapping("/readByPrice")
    public String readByPrice(@RequestParam("price") Long price) {
        System.out.println(price);
        Product product = null;
        if ((product = fs.readByPrice(price)) == null) {
            return "There is No...";
        }
        String answer = "";
        answer += product.getName();
        answer += " ";
        answer += product.getPrice();
        return answer;
    }
}