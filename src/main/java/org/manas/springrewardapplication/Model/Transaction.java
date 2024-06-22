package org.manas.springrewardapplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID transactionid;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    private Double amount;
    private Integer rewardPoints;
    private LocalDateTime transactionTime;
}
