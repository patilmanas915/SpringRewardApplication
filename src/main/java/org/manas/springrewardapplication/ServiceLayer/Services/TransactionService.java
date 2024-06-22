package org.manas.springrewardapplication.ServiceLayer.Services;

import org.manas.springrewardapplication.DTO.TransactionDTO;
import org.manas.springrewardapplication.DaoLayer.TransactionDao;
import org.manas.springrewardapplication.Model.Transaction;
import org.manas.springrewardapplication.Model.User;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.ITransactionService;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private IUserService userService;

    @Autowired
    private TransactionDao transactionDao;



    @Autowired
    public TransactionService(IUserService userService) {
        this.userService = userService;
    }
    @Override
    @Transactional
    public TransactionDTO addTransaction(Double amount) {
        User user = userService.getLoginUser();
        int rewardPoints = (int) Math.floor(amount)/100;
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setRewardPoints(rewardPoints);
        transaction.setUser(user);
        transaction.setTransactionTime(LocalDateTime.now());
        Transaction returnTransaction = transaction;//transactionDao.save(transaction);
        List<Transaction> tempTran = user.getTransactions();
        tempTran.add(returnTransaction);
        user.setTransactions(tempTran);
        user.setRewardPoints(user.getRewardPoints()+rewardPoints);
        userService.updateUser(user);
        return new TransactionDTO(returnTransaction.getUser().getUserId(),returnTransaction.getAmount(),returnTransaction.getRewardPoints(),returnTransaction.getTransactionTime());

    }

    @Override
    public List<TransactionDTO> getTransactions() {
        User user = userService.getLoginUser();
        return transactionDao.findByUser(user);
    }
}
