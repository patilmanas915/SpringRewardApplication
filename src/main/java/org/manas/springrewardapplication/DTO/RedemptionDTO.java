package org.manas.springrewardapplication.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.manas.springrewardapplication.Model.Redemption;

@Data
public class RedemptionDTO {
    private UUID userId;
    private UUID itemId;
    private String itemName;
    private LocalDateTime redemptionTime;
    private Integer pointsRequired;

    public RedemptionDTO(UUID userId, UUID itemId, String itemName,LocalDateTime time ,Integer rewardPoints) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.redemptionTime = time;
        this.pointsRequired = rewardPoints;
    }

    public RedemptionDTO(UUID userId, UUID itemId, String itemName) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public RedemptionDTO(UUID userId, UUID itemId, String itemName, Integer rewardPoints) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.pointsRequired = rewardPoints;
    }
}

