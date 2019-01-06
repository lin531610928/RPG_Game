package com.moe.service.impl;

import com.moe.dao.Card_ExpMapper;
import com.moe.model.Card_Exp;
import com.moe.service.Card_ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Card_ExpServiceImpl implements Card_ExpService {

    @Autowired
    private Card_ExpMapper Card_ExpDao;

    @Override
    public Card_Exp selectByPrimaryKey(Integer card_level){
        return Card_ExpDao.selectByPrimaryKey(card_level);
    }

}
