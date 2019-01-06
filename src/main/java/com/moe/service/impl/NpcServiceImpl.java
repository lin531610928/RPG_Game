package com.moe.service.impl;

import com.moe.dao.NpcMapper;
import com.moe.model.Npc;
import com.moe.service.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NpcServiceImpl implements NpcService {

    @Autowired
    private NpcMapper NpcDao;

    @Override
    public List<Npc> npcTeam(int type){
        List<Npc> nrecord = new ArrayList();
        if(type == 1){
            Npc record = NpcDao.selectByPrimaryKey(701);
            for (int i = 0;i < 5;i++){
                nrecord.add(record);
            }
        }
        else if(type == 2){
            Npc record2 = NpcDao.selectByPrimaryKey(701);
            for (int i = 0;i < 3;i++){
                nrecord.add(record2);
            }
            Npc record = NpcDao.selectByPrimaryKey(702);
            for (int i = 0;i < 2;i++){
                nrecord.add(record);
            }
        }
        else if(type == 3){
            Npc record2 = NpcDao.selectByPrimaryKey(702);
            for (int i = 0;i < 4;i++){
                nrecord.add(record2);
            }
            Npc record = NpcDao.selectByPrimaryKey(703);
            nrecord.add(record);
        }
        else if(type == 4){
            Npc record2 = NpcDao.selectByPrimaryKey(702);
            for (int i = 0;i < 3;i++){
                nrecord.add(record2);
            }
            Npc record = NpcDao.selectByPrimaryKey(703);
            nrecord.add(record);
            Npc record3 = NpcDao.selectByPrimaryKey(704);
            nrecord.add(record3);
        }
        return nrecord;
    }

}
