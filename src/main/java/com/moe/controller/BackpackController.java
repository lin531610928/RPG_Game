package com.moe.controller;

import com.moe.bean.CardsBase;
import com.moe.bean.ItemBase;
import com.moe.bean.PlayerBase;
import com.moe.model.*;
import com.moe.service.BackpackService;
import com.moe.service.Card_ExpService;
import com.moe.service.CardsService;
import com.moe.service.ItemsService;
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
public class BackpackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BackpackService BackpackService;

    @Autowired
    private CardsService CardsService;

    @Autowired
    private Card_ExpService Card_ExpService;

    @Autowired
    private ItemsService ItemsService;

    @RequestMapping("/backpack")
    private String backpack(){
        return "backpack";
    }

    @RequestMapping(value = "/backpack/playercards", method = RequestMethod.POST)
    @ResponseBody
    public List<CardsBase> playerCards(@RequestBody PlayerBase playerinfo){
        List<CardsBase> carrier = new ArrayList();
        List<Backpack> record = BackpackService.selectByPlayerId(Integer.parseInt(playerinfo.getPlayer_id()));
        for(int i = 0;i<record.size();i++){
            CardsBase a = new CardsBase();
            Cards crecord = new Cards();
            Card_Exp cerecord = new Card_Exp();
            crecord = CardsService.selectByPrimaryKey(record.get(i).getCard_id());
            cerecord = Card_ExpService.selectByPrimaryKey(record.get(i).getCard_level());
            a.setCard_id(""+record.get(i).getCard_id());
            a.setCard_bid(""+record.get(i).getCard_bid());
            a.setCard_level(""+record.get(i).getCard_level());
            a.setCard_ability(""+record.get(i).getCard_ability());
            a.setCard_exp(""+record.get(i).getCard_exp());
            a.setCard_state(""+record.get(i).getCard_state());
            a.setCard_ability_min(""+crecord.getCard_ability_min());
            a.setCard_ability_max(""+crecord.getCard_ability_max());
            a.setCard_name(crecord.getCard_name());
            a.setCard_rare(crecord.getCard_rare());
            a.setCard_skill_desc(crecord.getCard_skill_desc());
            a.setCard_path(crecord.getCard_path());
            int levelMax=0;
            if(crecord.getCard_id()<200){
                levelMax=70;
            }else if(crecord.getCard_id()<300){
                levelMax=60;
            }else levelMax=50;
            if(record.get(i).getCard_level() == levelMax){
                a.setCard_needexp(""+0);
            }else a.setCard_needexp(""+cerecord.getCard_needexp());
            carrier.add(a);
        }
        return carrier;
    }

    @RequestMapping(value = "/backpack/update", method = RequestMethod.POST)
    @ResponseBody
    public CardsBase updateTeam(@RequestBody Backpack record){
        CardsBase carrier = new CardsBase();
        System.out.println(record.getCard_state()+""+record.getCard_bid());
        BackpackService.updateTeam(record);
        carrier.setMessage("true");
        return carrier;
    }

    @RequestMapping(value = "/backpack/delete", method = RequestMethod.POST)
    @ResponseBody
    public CardsBase deleteCard(@RequestBody List<CardsBase> record){
        CardsBase carrier = new CardsBase();
        for(int i = 0;i<record.size();i++){
            Backpack brecord = new Backpack();
            brecord.setPlayer_id(Integer.parseInt(record.get(i).getPlayer_id()));
            brecord.setCard_bid(Integer.parseInt(record.get(i).getCard_bid()));
            BackpackService.deleteByCardbid(brecord);
        }
        carrier.setMessage("true");
        return carrier;
    }

    @RequestMapping(value = "/backpack/item", method = RequestMethod.POST)
    @ResponseBody
    public ItemBase myItem(@RequestBody ItemBase playerinfo){
        ItemBase carrier = new ItemBase();
        Player_Items record = new Player_Items();
        record.setPlayer_id(Integer.parseInt(playerinfo.getPlayer_id()));
        record.setItem_id(11);
        Player_Items record2 = ItemsService.selectByPlayerid(record);
        if(record2 == null){
            carrier.setItem_num("0");
            return carrier;
        }else carrier.setItem_num(""+record2.getItem_num());
        carrier.setMessage("true");
        return carrier;
    }

    @RequestMapping(value = "/backpack/cardup", method = RequestMethod.POST)
    @ResponseBody
    public ItemBase cardUp(@RequestBody ItemBase upinfo){
        ItemBase carrier = new ItemBase();
        Items irecord = ItemsService.selectByPrimaryKey(11);
        int getexp = irecord.getItem_exp()*Integer.parseInt(upinfo.getItem_num());
        Backpack brecord = new Backpack();
        brecord.setPlayer_id(Integer.parseInt(upinfo.getPlayer_id()));
        brecord.setCard_bid(Integer.parseInt(upinfo.getCard_bid()));
        boolean b = BackpackService.cardUp(brecord,getexp);
        if(b == true){
            Player_Items pirecord = new Player_Items();
            pirecord.setPlayer_id(Integer.parseInt(upinfo.getPlayer_id()));
            pirecord.setItem_id(11);
            pirecord.setItem_num(Integer.parseInt(upinfo.getItem_num()));
            ItemsService.delItem(pirecord);
            carrier.setMessage("true");
        }else carrier.setMessage("false");
        return carrier;
    }

}
