package org.manas.springrewardapplication.DTO;

import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.manas.springrewardapplication.Model.Redemption;
import org.manas.springrewardapplication.Model.Transaction;

@Data
public class UserResponseDTO {
    private UUID userId;
    private String name;
    private String email;
    private Integer rewardPoints;
    private List<Transaction> transactions;
    private List<Redemption> redemptions;



    public UserResponseDTO(UUID userId, String name, String email, Integer rewardPoints, List<Redemption> redemptions, List<Transaction> transactions) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.rewardPoints = rewardPoints;
    }
}

