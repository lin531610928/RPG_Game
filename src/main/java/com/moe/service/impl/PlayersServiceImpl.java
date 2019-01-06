package com.moe.service.impl;

import com.moe.dao.Player_ExpMapper;
import com.moe.dao.PlayersMapper;
import com.moe.model.Player_Exp;
import com.moe.model.Players;
import com.moe.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {

    @Autowired
    private PlayersMapper PlayersDao;

    @Autowired
    private Player_ExpMapper Player_ExpDao;

    @Override
    public Players selectByName(String player_name){
        return PlayersDao.selectByName(player_name);
    }

    @Override
    public Player_Exp getPlayerNeedExp(Integer player_level){
        return Player_ExpDao.selectByPrimaryKey(player_level);
    }

    @Override
    public int insertSelective(Players record){
        return PlayersDao.insertSelective(record);
    }

    @Override
    public Players selectByPrimaryKey(Integer player_id){
        return PlayersDao.selectByPrimaryKey(player_id);
    }

    @Override
    public boolean levelUp(Integer player_id,Integer get_exp){
        Players record = PlayersDao.selectByPrimaryKey(player_id);
        Player_Exp record2 = Player_ExpDao.selectByPrimaryKey(record.getPlayer_level());
        if(record2.getPlayer_needexp() == 0){
            return true;
        }
        int now_exp=record.getPlayer_exp()+get_exp;
        if(now_exp<record2.getPlayer_needexp()){
            record.setPlayer_exp(now_exp);
            PlayersDao.updateByPrimaryKeySelective(record);
        }else {
            while(now_exp>=record2.getPlayer_needexp()){
                int next_level = record.getPlayer_level()+1;
                record.setPlayer_level(next_level);
                now_exp = now_exp-record2.getPlayer_needexp();
                record.setPlayer_exp(now_exp);
                //record2=new Player_Exp();
                record2=Player_ExpDao.selectByPrimaryKey(next_level);
                if(record2.getPlayer_needexp() == 0){
                    record.setPlayer_exp(0);
                    PlayersDao.updateByPrimaryKeySelective(record);
                    break;
                }
                PlayersDao.updateByPrimaryKeySelective(record);
            }
        }
        return true;
    }

    @Override
    public List<Players> searchPlayers(String player_name){
        return PlayersDao.searchPlayers(player_name);
    }

    @Override
    public boolean addMoney(Integer player_id,Integer get_money){
        Players record = PlayersDao.selectByPrimaryKey(player_id);
        record.setPlayer_money(record.getPlayer_money()+get_money);
        if(record.getPlayer_money()>999999)
            record.setPlayer_money(999999);
        int i = PlayersDao.updateByPrimaryKeySelective(record);
        if(i == 1)
            return true;
        else
            return false;
    }

    @Override
    public List<Players> selectPlayers(Integer player_id){
        return PlayersDao.selectPlayers(player_id);
    }

    @Override
    public List<Players> selectFriends(Integer player_id){
        return PlayersDao.selectFriends(player_id);
    }

}
