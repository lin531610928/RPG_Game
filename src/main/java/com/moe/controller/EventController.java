package com.moe.controller;

import com.moe.bean.PlayerBase;
import com.moe.bean.PveBase;
import com.moe.model.Npc;
import com.moe.model.Players;
import com.moe.model.Team;
import com.moe.service.BackpackService;
import com.moe.service.NpcService;
import com.moe.service.PlayersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class EventController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NpcService NpcService;

    @Autowired
    private BackpackService BackpackService;

    @Autowired
    private PlayersService PlayersService;

    @RequestMapping("/event")
    public String event(){
        return "event";
    }

    @RequestMapping(value = "/event/can", method = RequestMethod.POST)
    @ResponseBody
    public PlayerBase eventCan(){
        PlayerBase carrier = new PlayerBase();
        Calendar cal= Calendar.getInstance();
        cal.setTime(new Date());
        int week=cal.get(Calendar.DAY_OF_WEEK);
        if(week == 1 || week == 7)
            carrier.setMessage("true");
        else carrier.setMessage("false");
        return carrier;
    }

    @RequestMapping("/eventgame")
    public String eventGame(){
        return "eventgame";
    }

    @RequestMapping(value = "/eventgame/start", method = RequestMethod.POST)
    @ResponseBody
    public List<PveBase> teamInfo(@RequestBody PveBase Playerinfo){
        List<PveBase> carrier = new ArrayList();
        Calendar cal= Calendar.getInstance();
        cal.setTime(new Date());
        int week=cal.get(Calendar.DAY_OF_WEEK);
        if(week !=1 && week !=7){
            PveBase record = new PveBase();
            record.setMessage("false");
            carrier.add(record);
            return carrier;
        }
        List<Team> trecord = BackpackService.selectTeam(Integer.parseInt(Playerinfo.getPlayer_id()));
        List<Npc> nrecord = NpcService.npcTeam(4);
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

}
