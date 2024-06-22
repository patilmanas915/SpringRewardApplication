package org.manas.springrewardapplication.ServiceLayer.Interfaces;

import org.manas.springrewardapplication.DTO.TransactionDTO;
import org.manas.springrewardapplication.Model.Transaction;

import java.util.List;

public interface ITransactionService {

    public TransactionDTO addTransaction(Double amout);
    public List<TransactionDTO> getTransactions();
}
