package com.moe.service;

import com.moe.model.Items;
import com.moe.model.Player_Items;

public interface ItemsService {

    boolean addItem(Player_Items record);

    boolean delItem(Player_Items record);

    Player_Items selectByPlayerid(Player_Items record);

    Items selectByPrimaryKey(Integer item_id);

}
