package com.moe.controller;

import com.moe.bean.GameResultBase;
import com.moe.bean.PlayerBase;
import com.moe.bean.PveBase;
import com.moe.bean.PvpBase;
import com.moe.model.*;
import com.moe.service.BackpackService;
import com.moe.service.NpcService;
import com.moe.service.PlayersService;
import com.moe.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NpcService NpcService;

    @Autowired
    private BackpackService BackpackService;

    @Autowired
    private PlayersService PlayersService;

    @Autowired
    private TaskService TaskService;

    @RequestMapping("/game")
    public String game(){
        return "game";
    }

    @RequestMapping(value = "/game/simple", method = RequestMethod.POST)
    @ResponseBody
    public List<PveBase> teamInfo(@RequestBody PveBase Playerinfo){
        List<PveBase> carrier = new ArrayList();
        List<Team> trecord = BackpackService.selectTeam(Integer.parseInt(Playerinfo.getPlayer_id()));
        List<Npc> nrecord = new ArrayList();
        switch (Integer.parseInt(Playerinfo.getMessage())){
            case 1:
                nrecord = NpcService.npcTeam(1);
                break;
            case 2:
                nrecord = NpcService.npcTeam(2);
                break;
            case 3:
                nrecord = NpcService.npcTeam(3);
                break;
        }
        Players precord = PlayersService.selectByPrimaryKey(Integer.parseInt(Playerinfo.getPlayer_id()));
        int ci=0;
        for(int i = 0;i < 5;i++){
            PveBase record = new PveBase();
            record.setPlayer_level(""+precord.getPlayer_level());
            if(trecord.get(i) != null) {
                record.setPlayer_id("" + trecord.get(i).getPlayer_id());
                record.setCard_id("" + trecord.get(i).getCard_id());
                record.setCard_rare(trecord.get(i).getCard_rare());
                record.setCard_skill_type(trecord.get(i).getCard_skill_type());
                record.setCard_path(trecord.get(i).getCard_path());
                record.setCard_bid("" + trecord.get(i).getCard_bid());
                record.setCard_ability("" + trecord.get(i).getCard_ability());
                record.setCard_state("" + trecord.get(i).getCard_state());
                record.setMessage("true");
            }
            else ci=1;
            record.setNpc_hp(""+nrecord.get(i).getNpc_hp());
            record.setNpc_ability(""+nrecord.get(i).getNpc_ability());
            record.setNpc_ability_d(""+nrecord.get(i).getNpc_ability_d());
            record.setNpc_dropexp(""+nrecord.get(i).getNpc_dropexp());
            record.setNpc_path(nrecord.get(i).getNpc_path());
            carrier.add(record);
        }
        if(ci==1){
            carrier.get(0).setMessage("no");
        }
        return carrier;
    }

    @RequestMapping(value = "/game/result", method = RequestMethod.POST)
    @ResponseBody
    public GameResultBase gameResult(@RequestBody GameResultBase Resultinfo){
        GameResultBase carrier = new GameResultBase();
        List<Team> trecord = BackpackService.selectTeam(Integer.parseInt(Resultinfo.getPlayer_id()));
        for(int i = 0;i<5;i++){
            Backpack brecord = new Backpack();
            brecord.setPlayer_id(Integer.parseInt(Resultinfo.getPlayer_id()));
            brecord.setCard_bid(trecord.get(i).getCard_bid());
            BackpackService.cardUp(brecord,Integer.parseInt(Resultinfo.getCard_gexp()));
        }
        if(Integer.parseInt(Resultinfo.getMessage()) == 1){
            PlayersService.levelUp(Integer.parseInt(Resultinfo.getPlayer_id()), Integer.parseInt(Resultinfo.getPlayer_gexp()));
            PlayersService.addMoney(Integer.parseInt(Resultinfo.getPlayer_id()),Integer.parseInt(Resultinfo.getPlayer_gmoney()));
            TaskService.taskNowAdd(Integer.parseInt(Resultinfo.getPlayer_id()));
        }
        carrier.setMessage("true");
        return carrier;
    }

    @RequestMapping(value = "/game/eventresult", method = RequestMethod.POST)
    @ResponseBody
    public GameResultBase eventResult(@RequestBody GameResultBase Resultinfo){
        GameResultBase carrier = new GameResultBase();
        List<Team> trecord = BackpackService.selectTeam(Integer.parseInt(Resultinfo.getPlayer_id()));
        for(int i = 0;i<5;i++){
            Backpack brecord = new Backpack();
            brecord.setPlayer_id(Integer.parseInt(Resultinfo.getPlayer_id()));
            brecord.setCard_bid(trecord.get(i).getCard_bid());
            BackpackService.cardUp(brecord,Integer.parseInt(Resultinfo.getCard_gexp()));
        }
        if(Integer.parseInt(Resultinfo.getMessage()) == 1){
            PlayersService.levelUp(Integer.parseInt(Resultinfo.getPlayer_id()), Integer.parseInt(Resultinfo.getPlayer_gexp()));
            PlayersService.addMoney(Integer.parseInt(Resultinfo.getPlayer_id()),Integer.parseInt(Resultinfo.getPlayer_gmoney()));
            TaskService.taskEventAdd(Integer.parseInt(Resultinfo.getPlayer_id()));
        }
        carrier.setMessage("true");
        return carrier;
    }

    @RequestMapping(value = "/game/selectfriend", method = RequestMethod.POST)
    @ResponseBody
    public List<PlayerBase> friendsinfo(@RequestBody PlayerBase playerinfo){
        List<PlayerBase> carrier = new ArrayList();
        List<Players> record = PlayersService.selectFriends(Integer.parseInt(playerinfo.getPlayer_id()));
        if(record.size() == 0){
            PlayerBase precord = new PlayerBase();
            precord.setMessage("no");
            carrier.add(precord);
            return carrier;
        }
        for(int i = 0;i < record.size();i++){
            PlayerBase precord = new PlayerBase();
            precord.setPlayer_id(""+record.get(i).getPlayer_id());
            precord.setPlayer_name(record.get(i).getPlayer_name());
            precord.setPlayer_level(""+record.get(i).getPlayer_level());
            precord.setMessage("true");
            carrier.add(precord);
        }
        return carrier;
    }

    @RequestMapping("/game/pvp")
    public String pvpgame(){
        return "pvpgame";
    }

    @RequestMapping(value = "/game/pvpplayers", method = RequestMethod.POST)
    @ResponseBody
    public List<PlayerBase> playerInfo(@RequestBody PvpBase pvpinfo){
        List<PlayerBase> carrier =new ArrayList();
        List<Players> record = PlayersService.selectPlayers(Integer.parseInt(pvpinfo.getPlayer_id()));
        for(int i = 0;i < record.size();i++){
            PlayerBase precord = new PlayerBase();
            precord.setPlayer_id(""+record.get(i).getPlayer_id());
            precord.setPlayer_name(record.get(i).getPlayer_name());
            precord.setPlayer_level(""+record.get(i).getPlayer_level());
            precord.setMessage("true");
            carrier.add(precord);
        }
        return carrier;
    }

    @RequestMapping(value = "/game/pvpgame", method = RequestMethod.POST)
    @ResponseBody
    public List<PvpBase> teaminfo2(@RequestBody PvpBase pvpinfo){
        List<PvpBase> carrier =new ArrayList();
        List<Team> trecord = BackpackService.selectTeam(Integer.parseInt(pvpinfo.getPlayer_id()));
        List<Team> trecord2 = BackpackService.selectTeam(Integer.parseInt(pvpinfo.getDplayer_id()));
        Players precord = PlayersService.selectByPrimaryKey(Integer.parseInt(pvpinfo.getPlayer_id()));
        Players precord2 = PlayersService.selectByPrimaryKey(Integer.parseInt(pvpinfo.getDplayer_id()));
        int ci=0;
        for(int i = 0;i < 5;i++){
            PvpBase record = new PvpBase();
            record.setPlayer_level(""+precord.getPlayer_level());
            record.setDplayer_level(""+precord2.getPlayer_level());
            if(trecord.get(i) != null) {
                record.setPlayer_id("" + trecord.get(i).getPlayer_id());
                record.setCard_id("" + trecord.get(i).getCard_id());
                record.setCard_rare(trecord.get(i).getCard_rare());
                record.setCard_skill_type(trecord.get(i).getCard_skill_type());
                record.setCard_path(trecord.get(i).getCard_path());
                record.setCard_bid("" + trecord.get(i).getCard_bid());
                record.setCard_ability("" + trecord.get(i).getCard_ability());
                record.setCard_state("" + trecord.get(i).getCard_state());
                record.setMessage("true");
            }
            else ci=1;
            record.setDplayer_id(""+trecord2.get(i).getPlayer_id());
            record.setDcard_id(""+trecord2.get(i).getCard_id());
            record.setDcard_rare(trecord2.get(i).getCard_rare());
            record.setDcard_skill_type(trecord2.get(i).getCard_skill_type());
            record.setDcard_path(trecord2.get(i).getCard_path());
            record.setDcard_ability(""+trecord2.get(i).getCard_ability());
            record.setDcard_state(""+trecord2.get(i).getCard_state());
            carrier.add(record);
        }
        if(ci==1){
            carrier.get(0).setMessage("no");
        }
        return carrier;
    }

}
