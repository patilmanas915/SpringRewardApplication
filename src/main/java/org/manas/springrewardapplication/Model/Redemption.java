package org.manas.springrewardapplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Redemption {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID RedemptionId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Item item;

    private LocalDateTime redemptionTime;
}
