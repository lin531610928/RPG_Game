package com.moe.controller;

import com.moe.bean.CardsBase;
import com.moe.bean.PlayerBase;
import com.moe.model.Cards;
import com.moe.model.Players;
import com.moe.service.BackpackService;
import com.moe.service.CardsService;
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
import java.util.List;

@Controller
public class CardsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CardsService CardsService;

    @Autowired
    private PlayersService PlayersService;

    @Autowired
    private BackpackService BackpackService;

    @RequestMapping("/drawcard")
    private String drawCard(){
        return "drawcard";
    }

    @RequestMapping(value = "/drawcard/singledraw", method = RequestMethod.POST)
    @ResponseBody
    public CardsBase singleDraw(@RequestBody PlayerBase playerinfo){
        CardsBase carrier = new CardsBase();
        Players precord = PlayersService.selectByPrimaryKey(Integer.parseInt(playerinfo.getPlayer_id()));
        int backpackmax = BackpackService.Backpackmax(Integer.parseInt(playerinfo.getPlayer_id()));
        if(precord.getPlayer_money()<250){
            carrier.setMessage("nomoney");
            return carrier;
        }else if(backpackmax>99){
            carrier.setMessage("noplace");
            return carrier;
        } else {
            List<Cards> record = CardsService.DrawCard(1,precord,backpackmax);
            carrier.setCard_path(record.get(0).getCard_path());
            carrier.setMessage("true");
            return carrier;
        }
    }

    @RequestMapping(value = "/drawcard/tendraw", method = RequestMethod.POST)
    @ResponseBody
    public List<CardsBase> tenDraw(@RequestBody PlayerBase playerinfo){
        List<CardsBase> carrier = new ArrayList();
        Players precord = PlayersService.selectByPrimaryKey(Integer.parseInt(playerinfo.getPlayer_id()));
        int backpackmax = BackpackService.Backpackmax(Integer.parseInt(playerinfo.getPlayer_id()));
        if(precord.getPlayer_money()<2500){
            CardsBase b = new CardsBase();
            b.setMessage("nomoney");
            carrier.add(b);
            return carrier;
        }else if(backpackmax>90){
            CardsBase c = new CardsBase();
            c.setMessage("noplace");
            carrier.add(c);
            return carrier;
        } else {
            List<Cards> record = CardsService.DrawCard(10,precord,backpackmax);
            for (int i = 0; i < 10; i++) {
                CardsBase a = new CardsBase();
                a.setCard_path(record.get(i).getCard_path());
                a.setMessage("true");
                carrier.add(a);
            }
            return carrier;
        }
    }

}
