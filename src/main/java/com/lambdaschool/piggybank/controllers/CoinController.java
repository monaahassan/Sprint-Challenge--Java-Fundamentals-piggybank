package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinRepository;
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> ListAllMoney() {
        List<Coin> myList = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(myList::add);

        double total = 0.00;
        for (Coin c : myList) {
            total += (c.getValue() * c.getQuantity());
            if (c.getQuantity() > 1) {
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            } else {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
        }
        System.out.println("The piggy bank holds " + total);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
