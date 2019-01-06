package com.moe.controller;

import com.moe.bean.PlayerBase;
import com.moe.model.Player_Exp;
import com.moe.model.Players;
import com.moe.service.PlayersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayersService PlayersService;

    @RequestMapping("/login")
    private String Login(){
        return "login";
    }

    @RequestMapping("/register")
    private String Register(){
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public PlayerBase playerLogin(@RequestBody PlayerBase Playerinfo){
        PlayerBase carrier = new PlayerBase();
        System.out.println(Playerinfo.getPlayer_name());
        Players record=PlayersService.selectByName(Playerinfo.getPlayer_name());
        if (record== null) {
            carrier.setMessage("no");
            return carrier;
        }else if(record.getPlayer_password().equals(Playerinfo.getPlayer_password())==false){
            carrier.setMessage("false");
            return carrier;
        }else {
            Player_Exp record2=PlayersService.getPlayerNeedExp(record.getPlayer_level());
            carrier.setInfo(""+record.getPlayer_id(),record.getPlayer_name(),record.getPlayer_password(),""+record.getPlayer_money(),""+record.getPlayer_level(),""+record.getPlayer_exp(),""+record2.getPlayer_needexp(),"true");
            return carrier;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public PlayerBase playerRegister(@RequestBody PlayerBase Playerinfo){
        PlayerBase carrier = new PlayerBase();
        Players record=PlayersService.selectByName(Playerinfo.getPlayer_name());
        if(record!=null){
            carrier.setMessage("false");
            return carrier;
        }else {
            Players record2 = new Players();
            record2.setPlayer_name(Playerinfo.getPlayer_name());
            record2.setPlayer_password(Playerinfo.getPlayer_password());
            int a =PlayersService.insertSelective(record2);
            if(a==1){
                carrier.setMessage("true");
                return carrier;
            }else {
                carrier.setMessage("no");
                return carrier;
            }
        }
    }

}
