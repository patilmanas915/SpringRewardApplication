package org.manas.springrewardapplication.WebLayer;

import org.manas.springrewardapplication.DTO.RedemptionDTO;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IItemService;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IRedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedemptionController {

    @Autowired
    private IRedemptionService redemptionService;


    @PostMapping("Redem/{name}")
    public ResponseEntity<?> redeemItem(@PathVariable("name") String name){
        RedemptionDTO item = redemptionService.RedemByName(name);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("RedemHistory")
    public ResponseEntity<?> getTransactionHistory(){
        return new ResponseEntity<>(redemptionService.getTransactions(), HttpStatus.OK);
    }
}
