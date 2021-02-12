package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinrepo;

    @GetMapping(value = "money/total", produces = "application/json")
    public ResponseEntity<?> getTotal(){
        final double[] total = {0};
        coinrepo.findAll().iterator().forEachRemaining((item) ->
                {
                    long quantity = item.getQuantity();
                    total[0] +=item.getValue()*quantity;
                    if (quantity > 1){
                        System.out.println(item.getQuantity()+" "+item.getNameplural());
                    }
                    else {
                        System.out.println(item.getQuantity()+" "+item.getName());
                    }
                }
        );
        System.out.println("The piggy bank holds "+total[0]);
        return new ResponseEntity<>(total[0], HttpStatus.OK);
    }
}
