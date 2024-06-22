package org.manas.springrewardapplication.ServiceLayer.Interfaces;

import org.manas.springrewardapplication.DTO.RedemptionDTO;

import java.util.List;

public interface IRedemptionService {

    public RedemptionDTO RedemByName(String name);
    List<RedemptionDTO> getTransactions();
}
