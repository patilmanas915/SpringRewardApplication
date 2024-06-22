package org.manas.springrewardapplication.DTO;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data

public class TransactionDTO {
    private UUID userId;
    private Double amount;
    private Integer rewardPoints;
    private LocalDateTime transactionTime;

    public TransactionDTO(UUID userId, Double amount, Integer rewardPoints, LocalDateTime transactionTime) {
        this.userId = userId;
        this.amount = amount;
        this.rewardPoints = rewardPoints;
        this.transactionTime = transactionTime;
    }
}
