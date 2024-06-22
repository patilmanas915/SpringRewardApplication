package org.manas.springrewardapplication.DaoLayer;


import org.manas.springrewardapplication.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemDao extends JpaRepository<Item, UUID> {

    public Optional<Item> findByItemName(String name);
}
