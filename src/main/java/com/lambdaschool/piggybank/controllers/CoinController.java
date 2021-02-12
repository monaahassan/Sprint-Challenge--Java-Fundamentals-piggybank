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
public class CoinController
{
    private List<Coin> findCoins(List<Coin> myList, CheckCoin tester)
    {
        List<Coin> tempList = new ArrayList<>();

        for (Coin c : myList)
        {
            if (tester.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }

    @Autowired
    CoinRepository coinRepository;

    // http://localhost:2019/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> totalAmount(){
        List<Coin> coinList = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(coinList::add);

        double total = 0;
        for (Coin c : coinList){
            total += (c.getValue() * c.getQuantity());
            System.out.println(c.getQuantity() + " " + (c.getQuantity() > 1 ? c.getNamePlural() : c.getName()));
        }
        System.out.println("The piggybank is holding " + total);
        return new ResponseEntity<>(coinList, HttpStatus.OK);
    }
}