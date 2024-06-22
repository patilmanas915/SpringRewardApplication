package org.manas.springrewardapplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID itemId;
    private String itemName;
    private Integer rewardPoints;
    private String description;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Redemption> redemptions= new ArrayList<>();;

    public Item(String itemName, Integer rewardPoints, String description) {
        this.itemName = itemName;
        this.rewardPoints = rewardPoints;
        this.description = description;
    }

    public Item() {
    }

}
