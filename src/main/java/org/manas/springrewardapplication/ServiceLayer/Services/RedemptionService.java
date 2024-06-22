package org.manas.springrewardapplication.ServiceLayer.Services;
import org.manas.springrewardapplication.DTO.RedemptionDTO;
import org.manas.springrewardapplication.DTO.TransactionDTO;
import org.manas.springrewardapplication.DaoLayer.ItemDao;
import org.manas.springrewardapplication.DaoLayer.RedemptionDao;
import org.manas.springrewardapplication.Model.Item;
import org.manas.springrewardapplication.Model.Redemption;
import org.manas.springrewardapplication.Model.User;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IRedemptionService;
import org.manas.springrewardapplication.ServiceLayer.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RedemptionService implements IRedemptionService {

    @Autowired
    private RedemptionDao redemptionDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private IUserService userService;

    @Override
    public RedemptionDTO RedemByName(String name) {


        Optional<Item> Opitem = itemDao.findByItemName(name);
        if(Opitem.isEmpty()){
            throw new RuntimeException("Item not found");
        }
        else{
            User user = userService.getLoginUser();
            Item item = Opitem.get();
            if(user.getRewardPoints()<item.getRewardPoints()){
                throw new RuntimeException("Not enough reward points");
            }
            user.setRewardPoints(user.getRewardPoints()-item.getRewardPoints());
            Redemption redemption = new Redemption();
            redemption.setItem(item);
            redemption.setUser(user);
            redemption.setRedemptionTime(LocalDateTime.now());
            user.getRedemptions().add(redemption);
            userService.updateUser(user);
            return new RedemptionDTO(user.getUserId(),item.getItemId(),item.getItemName(),item.getRewardPoints());

        }

    }

    @Override
    public List<RedemptionDTO> getTransactions() {
        User user = userService.getLoginUser();
        return redemptionDao.findByUser(user);
    }
}
