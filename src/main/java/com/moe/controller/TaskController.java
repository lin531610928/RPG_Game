package com.moe.controller;

import com.moe.bean.TaskBase;
import com.moe.model.Player_Items;
import com.moe.model.Player_Task;
import com.moe.model.Task;
import com.moe.service.ItemsService;
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
public class TaskController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskService TaskService;

    @Autowired
    private PlayersService PlayersService;

    @Autowired
    private ItemsService ItemsService;

    @RequestMapping("/task")
    private String task(){
        return "task";
    }

    @RequestMapping(value = "/task/all", method = RequestMethod.POST)
    @ResponseBody
    public List<TaskBase> allTask(@RequestBody TaskBase playerinfo){
        List<TaskBase> carrier = new ArrayList();
        List<Player_Task> ptrecord = TaskService.allTask(Integer.parseInt(playerinfo.getPlayer_id()));
        for(int i = 0;i < ptrecord.size();i++){
            Task trecord = TaskService.selectByPrimaryKey(ptrecord.get(i).getTask_id());
            TaskBase record =new TaskBase();
            record.setPlayer_id(playerinfo.getPlayer_id());
            record.setTask_id(""+trecord.getTask_id());
            record.setTask_name(trecord.getTask_name());
            record.setTask_award_desc(trecord.getTask_award_desc());
            record.setTask_aim(""+trecord.getTask_aim());
            record.setTask_now(""+ptrecord.get(i).getTask_now());
            record.setTask_complete(""+ptrecord.get(i).getTask_complete());
            record.setTask_type(""+trecord.getTask_type());
            record.setMessage("true");
            carrier.add(record);
        }
        return carrier;
    }

    @RequestMapping(value = "/task/complete", method = RequestMethod.POST)
    @ResponseBody
    public TaskBase taskComplete(@RequestBody TaskBase playerinfo){
        TaskBase carrier = new TaskBase();
        Player_Task ptrecord = new Player_Task();
        ptrecord.setPlayer_id(Integer.parseInt(playerinfo.getPlayer_id()));
        ptrecord.setTask_id(Integer.parseInt(playerinfo.getTask_id()));
        boolean b = TaskService.missionComplete(ptrecord);
        if(b==false){
            carrier.setMessage("false");
            return carrier;
        }
        if(ptrecord.getTask_id()==33){
            boolean b2 = TaskService.addEventCard(Integer.parseInt(playerinfo.getPlayer_id()));
            if(b2 == false){
                carrier.setMessage("no2");
                return carrier;
            }
            carrier.setMessage("true");
            return carrier;
        }
        Task trecord = TaskService.selectByPrimaryKey(Integer.parseInt(playerinfo.getTask_id()));
        String award = ""+trecord.getTask_award();
        Player_Items record = new Player_Items();
        record.setPlayer_id(Integer.parseInt(playerinfo.getPlayer_id()));
        record.setItem_id(11);
        record.setItem_num(Integer.parseInt(award.substring(6)));
        PlayersService.levelUp(Integer.parseInt(playerinfo.getPlayer_id()), Integer.parseInt(award.substring(0,3)));
        ItemsService.addItem(record);
        PlayersService.addMoney(Integer.parseInt(playerinfo.getPlayer_id()),Integer.parseInt(award.substring(3,6)));
        carrier.setMessage("true");
        return carrier;
    }

}
