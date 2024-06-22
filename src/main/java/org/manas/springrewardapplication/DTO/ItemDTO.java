package org.manas.springrewardapplication.DTO;

import java.util.UUID;
import lombok.Data;

@Data
public class ItemDTO {
    private UUID itemId;
    private String name;
    private Integer pointsRequired;
}
