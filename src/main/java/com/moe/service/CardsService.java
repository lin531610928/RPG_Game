package com.moe.service;

import com.moe.model.Cards;
import com.moe.model.Players;

import java.util.List;

public interface CardsService {

    List<Cards> DrawCard(int num,Players record3,int backpackmax);

    Cards selectByPrimaryKey(Integer card_id);

}
