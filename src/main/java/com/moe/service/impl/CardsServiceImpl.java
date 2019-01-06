package com.moe.service.impl;

import com.moe.dao.BackpackMapper;
import com.moe.dao.CardsMapper;
import com.moe.dao.PlayersMapper;
import com.moe.model.Backpack;
import com.moe.model.Cards;
import com.moe.model.Players;
import com.moe.other.Roll;
import com.moe.other.RollCard;
import com.moe.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardsMapper CardsDao;

    @Autowired
    private PlayersMapper PlayersDao;

    @Autowired
    private BackpackMapper BackpackDao;

    @Override
    public List<Cards> DrawCard(int num,Players record3,int backpackmax){
        RollCard r = new RollCard();
        Roll roll = new Roll();
        List<Cards> record = new ArrayList();
        Cards record2=new Cards();
        int money=record3.getPlayer_money()-(num*250);
        record3.setPlayer_money(money);
        PlayersDao.updateByPrimaryKeySelective(record3);
        for(int i = 0; i < num; ++i) {
            backpackmax = BackpackDao.selectCountByPlayerId(record3.getPlayer_id());
            String[] rare = r.rRare();
            if (i == 9 && rare[0].equals("R")) {
                rare[0] = "SR";
                rare[1] = "2";
            }
            int cardmax = this.CardsDao.selectCardCount(rare[0]);
            int c = roll.roll(cardmax);
            if(rare[1] == "1"){
                c = roll.roll(cardmax-1);
                if(c == 6){
                    c = 14;
                }
            }
            record2=CardsDao.selectByPrimaryKey(Integer.parseInt(rare[1]) * 100 + c);
            record.add(record2);
            Backpack brecord = new Backpack();
            brecord.setCard_id(record2.getCard_id());
            brecord.setPlayer_id(record3.getPlayer_id());
            brecord.setCard_ability(record2.getCard_ability_min());
            if(backpackmax==0){
                brecord.setCard_bid(1);
                BackpackDao.insertSelective(brecord);
            }else {
                int MBid = BackpackDao.selectMBidByPlayerId(record3.getPlayer_id());
                if (MBid < 100) {
                    brecord.setCard_bid(MBid + 1);
                    BackpackDao.insertSelective(brecord);
                } else {
                    List<Backpack> allBid = BackpackDao.selectBidByPlayerId(record3.getPlayer_id());
                    for (int o = 0; o < allBid.size(); o++) {
                        if ((allBid.get(o)).getCard_bid() != o + 1) {
                            brecord.setCard_bid(o + 1);
                            break;
                        }
                    }
                    BackpackDao.insertSelective(brecord);
                }
            }
        }
        return record;
    }

    @Override
    public Cards selectByPrimaryKey(Integer card_id){
        return CardsDao.selectByPrimaryKey(card_id);
    }

}
