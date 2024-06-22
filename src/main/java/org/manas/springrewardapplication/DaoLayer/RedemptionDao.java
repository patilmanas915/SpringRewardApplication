package org.manas.springrewardapplication.DaoLayer;

import org.manas.springrewardapplication.DTO.RedemptionDTO;
import org.manas.springrewardapplication.Model.Redemption;
import org.manas.springrewardapplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RedemptionDao extends JpaRepository<Redemption, UUID> {

    @Query("SELECT new org.manas.springrewardapplication.DTO.RedemptionDTO(r.user.userId, r.item.itemId, r.item.itemName, r.redemptionTime, r.item.rewardPoints) " +
            "FROM Redemption r WHERE r.user = :user")
    List<RedemptionDTO> findByUser(@Param("user") User user);
}

