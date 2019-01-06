package com.moe.service.impl;

import com.moe.dao.ItemsMapper;
import com.moe.dao.Player_ItemsMapper;
import com.moe.model.Items;
import com.moe.model.Player_Items;
import com.moe.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService{

    @Autowired
    private ItemsMapper ItemsDao;

    @Autowired
    private Player_ItemsMapper Player_ItemsDao;

    @Override
    public boolean addItem(Player_Items record){
        Player_Items record2 = Player_ItemsDao.selectByPlayerid(record);
        if(record2 == null){
            Player_ItemsDao.insert(record);
            return true;
        }
        int num = record.getItem_num() + record2.getItem_num();
        record.setItem_num(num);
        Player_ItemsDao.updateByPlayerid(record);
        return true;
    }

    @Override
    public boolean delItem(Player_Items record){
        Player_Items record2 = Player_ItemsDao.selectByPlayerid(record);
        int num = record2.getItem_num() - record.getItem_num();
        record.setItem_num(num);
        Player_ItemsDao.updateByPlayerid(record);
        return true;
    }

    @Override
    public Player_Items selectByPlayerid(Player_Items record){
        return Player_ItemsDao.selectByPlayerid(record);
    }

    @Override
    public Items selectByPrimaryKey(Integer item_id){
        return ItemsDao.selectByPrimaryKey(item_id);
    }

}
