package com.moe.controller;

import com.moe.bean.PlayerBase;
import com.moe.model.Player_Items;
import com.moe.service.ItemsService;
import com.moe.service.PlayersService;
import com.moe.service.SigninService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signin")
public class SigninController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SigninService SigninService;

    @Autowired
    private PlayersService PlayersService;

    @Autowired
    private ItemsService ItemsService;

    @RequestMapping(value = "/can", method = RequestMethod.POST)
    @ResponseBody
    public PlayerBase signinCan(@RequestBody PlayerBase Playerinfo){
        PlayerBase carrier = new PlayerBase();
        boolean b =SigninService.canSignin(Integer.parseInt(Playerinfo.getPlayer_id()));
        if(b == true){
            carrier.setMessage("true");
            return carrier;
        }else {
            carrier.setMessage("false");
            return carrier;
        }
    }

    @RequestMapping(value = "/day", method = RequestMethod.POST)
    @ResponseBody
    public PlayerBase signinDay(@RequestBody PlayerBase Playerinfo){
        PlayerBase carrier = new PlayerBase();
        boolean b3 = SigninService.canSignin(Integer.parseInt(Playerinfo.getPlayer_id()));
        boolean b = SigninService.okSignin(Integer.parseInt(Playerinfo.getPlayer_id()));
        if(b3 == true) {
            if (b == true) {
                Player_Items record = new Player_Items();
                record.setPlayer_id(Integer.parseInt(Playerinfo.getPlayer_id()));
                record.setItem_id(11);
                record.setItem_num(1);
                boolean b2 = PlayersService.levelUp(Integer.parseInt(Playerinfo.getPlayer_id()), 100);
                boolean b4 = ItemsService.addItem(record);
                if (b2 == true && b4 == true) {
                    carrier.setMessage("true");
                } else carrier.setMessage("false");
            } else carrier.setMessage("false");
        }
        else carrier.setMessage("false");
        return carrier;
    }
}
