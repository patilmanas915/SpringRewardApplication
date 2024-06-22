package org.manas.springrewardapplication.DaoLayer;

import org.manas.springrewardapplication.DTO.TransactionDTO;
import org.manas.springrewardapplication.Model.Transaction;
import org.manas.springrewardapplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TransactionDao extends JpaRepository<Transaction, UUID> {
    @Query("SELECT new org.manas.springrewardapplication.DTO.TransactionDTO(t.user.userId, t.amount, t.rewardPoints, t.transactionTime) " +
            "FROM Transaction t WHERE t.user = :user")
    List<TransactionDTO> findByUser(@Param("user") User user);
}
