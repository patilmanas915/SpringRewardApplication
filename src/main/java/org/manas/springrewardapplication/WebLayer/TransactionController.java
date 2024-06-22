package org.manas.springrewardapplication.WebLayer;

import org.aspectj.bridge.Message;
import org.manas.springrewardapplication.DTO.TransactionDTO;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;


    @PostMapping("Transaction/{amount}")
    public ResponseEntity<?> createTransaction(@PathVariable Double amount){
        System.out.println("Transaction amount: "+amount);
        TransactionDTO Message = transactionService.addTransaction(amount);
        return new ResponseEntity<>(Message, HttpStatus.OK);

    }

    @GetMapping("TransactionHistory")
    public ResponseEntity<?> getTransactionHistory(){
        return new ResponseEntity<>(transactionService.getTransactions(), HttpStatus.OK);
    }


}
