package com.moe.service.impl;

import com.moe.dao.BackpackMapper;
import com.moe.dao.Card_ExpMapper;
import com.moe.dao.CardsMapper;
import com.moe.dao.Player_ExpMapper;
import com.moe.model.Backpack;
import com.moe.model.Card_Exp;
import com.moe.model.Cards;
import com.moe.model.Team;
import com.moe.service.BackpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackpackServiceImpl implements BackpackService {

    @Autowired
    private BackpackMapper BackpackDao;

    @Autowired
    private Card_ExpMapper Card_ExpDao;

    @Autowired
    private CardsMapper CardsDao;

    @Override
    public int Backpackmax(int player_id){
        return BackpackDao.selectCountByPlayerId(player_id);
    }

    @Override
    public List<Backpack> selectByPlayerId(int player_id){
        return BackpackDao.selectByPlayerId(player_id);
    }

    @Override
    public int updateTeam(Backpack record) {
        Backpack record2 = BackpackDao.selectStateByPlayerId(record);
        if (record2 != null && record.getCard_state() == record2.getCard_state() && record2.getCard_bid() != record.getCard_bid()) {
            Backpack record3 = BackpackDao.selectByCardBid(record);
            record2.setCard_state(record3.getCard_state());
            BackpackDao.updateByCardbidSelective(record2);
        }
        return BackpackDao.updateByCardbidSelective(record);
    }

    @Override
    public boolean deleteByCardbid(Backpack record) {
        Backpack record2 = BackpackDao.selectByCardBid(record);
        if (record2.getCard_state() != 0) {
            return false;
        } else {
            BackpackDao.deleteByCardbid(record);
            return true;
        }
    }

    @Override
    public boolean cardUp(Backpack record,int getexp){
        record = BackpackDao.selectByCardBid(record);
        int levelMax=0;
        if(record.getCard_id()<200){
            levelMax=70;
        }else if(record.getCard_id()<300){
            levelMax=60;
        }else levelMax=50;
        if(record.getCard_level() == levelMax){
            return false;
        }
        Card_Exp percord = Card_ExpDao.selectByPrimaryKey(record.getCard_level());
        int nowexp = record.getCard_exp() + getexp;
        if(nowexp < percord.getCard_needexp()){
            record.setCard_exp(nowexp);
            BackpackDao.updateByCardbidSelective(record);
            return true;
        }
        Cards crecord = CardsDao.selectByPrimaryKey(record.getCard_id());
        int nowlevel = record.getCard_level();
        int avgability = (crecord.getCard_ability_max()-crecord.getCard_ability_min())/levelMax;
        int nowability = record.getCard_ability();
        while(nowexp >= percord.getCard_needexp()){
            nowlevel = nowlevel+1;
            if(nowlevel == levelMax){
                record.setCard_exp(0);
                record.setCard_level(nowlevel);
                record.setCard_ability(crecord.getCard_ability_max());
                BackpackDao.updateByCardbidSelective(record);
                return true;
            }
            nowability = nowability + avgability;
            nowexp = nowexp - percord.getCard_needexp();
            percord = Card_ExpDao.selectByPrimaryKey(nowlevel);
        }
        record.setCard_exp(nowexp);
        record.setCard_ability(nowability);
        record.setCard_level(nowlevel);
        BackpackDao.updateByCardbidSelective(record);
        return true;
    }

    public List<Team> selectTeam(int player_id){
        List<Team> trecord = new ArrayList();
        for(int i = 0;i < 5;i++){
            Backpack record = new Backpack();
            record.setPlayer_id(player_id);
            record.setCard_state(i+1);
            Team record2 = BackpackDao.selectTeam(record);
            trecord.add(record2);
        }
        return trecord;
    }

}
