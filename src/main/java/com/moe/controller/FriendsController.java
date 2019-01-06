package com.moe.controller;

import com.moe.bean.FriendBase;
import com.moe.bean.PlayerBase;
import com.moe.model.Friends;
import com.moe.model.MyFriends;
import com.moe.model.Players;
import com.moe.service.FriendsService;
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
public class FriendsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayersService PlayersService;

    @Autowired
    private FriendsService FriendsService;

    @RequestMapping("/friends")
    private String myFriends(){
        return "friends";
    }

    @RequestMapping(value = "/friends/searchplayers", method = RequestMethod.POST)
    @ResponseBody
    public List<PlayerBase> searchPlayers(@RequestBody PlayerBase Playerinfo) {
        List<PlayerBase> carrier = new ArrayList();
        List<Players> record = PlayersService.searchPlayers(Playerinfo.getPlayer_name());
        Friends frecord=new Friends();
        frecord.setPlayer_id(Integer.parseInt(Playerinfo.getPlayer_id()));
        if(record == null){
            PlayerBase record2 = new PlayerBase();
            record2.setMessage("no");
            carrier.add(record2);
            return carrier;
        }
        for(int i = 0;i < record.size();i++){
            PlayerBase record2 = new PlayerBase();
            record2.setMessage("true");
            frecord.setFriend_id(record.get(i).getPlayer_id());
            Friends record3 = FriendsService.selectByPFid(frecord);
            if(record.get(i).getPlayer_id()!=Integer.parseInt(Playerinfo.getPlayer_id())&&record3==null) {
                record2.setPlayer_id("" + record.get(i).getPlayer_id());
                record2.setPlayer_name(record.get(i).getPlayer_name());
                record2.setPlayer_level("" + record.get(i).getPlayer_level());
                carrier.add(record2);
            }
        }
        return carrier;
    }

    @RequestMapping(value = "/friends/addfriend", method = RequestMethod.POST)
    @ResponseBody
    public FriendBase addFriend(@RequestBody FriendBase Friendinfo){
        FriendBase carrier = new FriendBase();
        FriendsService.addFriend(Integer.parseInt(Friendinfo.getPlayer_id()),Integer.parseInt(Friendinfo.getFriend_id()));
        return carrier;
    }

    @RequestMapping(value = "/friends/waitfriends", method = RequestMethod.POST)
    @ResponseBody
    public List<PlayerBase> waitFriends(@RequestBody PlayerBase Playerinfo){
        List<PlayerBase> carrier = new ArrayList();
        Friends record = new Friends();
        record.setPlayer_id(Integer.parseInt(Playerinfo.getPlayer_id()));
        record.setFriend_state(0);
        List<MyFriends> record2 = FriendsService.myFriends(record);
        if(record2 == null){
            PlayerBase precord = new PlayerBase();
            precord.setMessage("no");
            carrier.add(precord);
            return carrier;
        }
        for (int i = 0;i<record2.size();i++){
            PlayerBase precord = new PlayerBase();
            precord.setPlayer_id(""+record2.get(i).getFriend_id());
            precord.setPlayer_name(record2.get(i).getPlayer_name());
            precord.setPlayer_level(""+record2.get(i).getPlayer_level());
            precord.setMessage("true");
            carrier.add(precord);
        }
        return carrier;
    }

    @RequestMapping(value = "/friends/deletewait", method = RequestMethod.POST)
    @ResponseBody
    public FriendBase deleteWait(@RequestBody FriendBase Friendinfo){
        FriendBase carrier = new FriendBase();
        Friends record = new Friends();
        record.setPlayer_id(Integer.parseInt(Friendinfo.getPlayer_id()));
        record.setFriend_id(Integer.parseInt(Friendinfo.getFriend_id()));
        int a = FriendsService.deleteFriend(record);
        if(a == 1){
            carrier.setMessage("true");
        }else carrier.setMessage("false");
        return carrier;
    }

    @RequestMapping(value = "/friends/waitme", method = RequestMethod.POST)
    @ResponseBody
    public List<FriendBase> waitMe(@RequestBody PlayerBase Playerinfo){
        List<FriendBase> carrier = new ArrayList();
        Friends record = new Friends();
        record.setFriend_id(Integer.parseInt(Playerinfo.getPlayer_id()));
        record.setFriend_state(0);
        List<MyFriends> frecord = FriendsService.selectWaitAgree(record);
        if(frecord == null){
            FriendBase record2 = new FriendBase();
            record2.setMessage("no");
            return carrier;
        }
        for (int i = 0;i<frecord.size();i++){
            FriendBase record2 = new FriendBase();
            record2.setMessage("true");
            record2.setFriend_id(""+frecord.get(i).getPlayer_id());
            record2.setPlayer_name(frecord.get(i).getPlayer_name());
            record2.setPlayer_level(""+frecord.get(i).getPlayer_level());
            carrier.add(record2);
        }
        return carrier;
    }

    @RequestMapping(value = "/friends/agreefriend", method = RequestMethod.POST)
    @ResponseBody
    public FriendBase agreeFreiend(@RequestBody FriendBase Friendinfo){
        FriendBase carrier = new FriendBase();
        boolean b = FriendsService.okFriend(Integer.parseInt(Friendinfo.getFriend_id()),Integer.parseInt(Friendinfo.getPlayer_id()));
        carrier.setMessage(""+b);
        return carrier;
    }

    @RequestMapping(value = "/friends/myfriends", method = RequestMethod.POST)
    @ResponseBody
    public List<FriendBase> myFriends(@RequestBody FriendBase Friendinfo){
        List<FriendBase> carrier = new ArrayList();
        Friends record = new Friends();
        record.setPlayer_id(Integer.parseInt(Friendinfo.getPlayer_id()));
        record.setFriend_state(1);
        List<MyFriends> mrecord = FriendsService.myFriends(record);
        if(mrecord == null){
            FriendBase record2 = new FriendBase();
            record2.setMessage("no");
            carrier.add(record2);
            return carrier;
        }
        for(int i = 0;i<mrecord.size();i++){
            FriendBase record2 = new FriendBase();
            record2.setMessage("true");
            record2.setFriend_id(""+mrecord.get(i).getFriend_id());
            record2.setPlayer_name(mrecord.get(i).getPlayer_name());
            record2.setPlayer_level(""+mrecord.get(i).getPlayer_level());
            carrier.add(record2);
        }
        return carrier;
    }

    @RequestMapping(value = "/friends/deletefriend", method = RequestMethod.POST)
    @ResponseBody
    public FriendBase deleteFriend(@RequestBody FriendBase Friendinfo){
        FriendBase carrier = new FriendBase();
        Friends record = new Friends();
        record.setPlayer_id(Integer.parseInt(Friendinfo.getPlayer_id()));
        record.setFriend_id(Integer.parseInt(Friendinfo.getFriend_id()));
        int a = FriendsService.deleteFriend(record);
        record.setPlayer_id(Integer.parseInt(Friendinfo.getFriend_id()));
        record.setFriend_id(Integer.parseInt(Friendinfo.getPlayer_id()));
        int b = FriendsService.deleteFriend(record);
        if(a==1&&b==1){
            carrier.setMessage("true");
        }else carrier.setMessage("false");
        return carrier;
    }
}
