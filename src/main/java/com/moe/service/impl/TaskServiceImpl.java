package com.moe.service.impl;

import com.moe.dao.BackpackMapper;
import com.moe.dao.CardsMapper;
import com.moe.dao.Player_TaskMapper;
import com.moe.dao.TaskMapper;
import com.moe.model.Backpack;
import com.moe.model.Cards;
import com.moe.model.Player_Task;
import com.moe.model.Task;
import com.moe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private Player_TaskMapper Player_TaskDao;

    @Autowired
    private TaskMapper TaskDao;

    @Autowired
    private CardsMapper CardsDao;

    @Autowired
    private BackpackMapper BackpackDao;

    @Override
    public List<Player_Task> allTask(int player_id){
        List<Player_Task> record = Player_TaskDao.selectAllTask(player_id);
        int taskNum = TaskDao.selectNum();
        if(record == null || taskNum > record.size()){
            java.util.Date d=new java.util.Date();
            java.sql.Date d1=new java.sql.Date(d.getTime());
            List<Task> trecord = TaskDao.selectAll();
            for(int i = 0;i < trecord.size();i++){
                Player_Task ptrecord = new Player_Task();
                ptrecord.setPlayer_id(player_id);
                ptrecord.setTask_id(trecord.get(i).getTask_id());
                ptrecord.setTask_now(0);
                ptrecord.setTask_date(d1);
                ptrecord.setTask_complete(0);
                Player_TaskDao.insert(ptrecord);
            }
        }else {
            java.util.Date d=new java.util.Date();
            java.sql.Date d1=new java.sql.Date(d.getTime());
            Calendar cal1 = Calendar.getInstance();
            cal1.setFirstDayOfWeek(Calendar.MONDAY);
            cal1.setTime(d1);
            for(int i = 0;i < record.size();i++){
                Task trecord = TaskDao.selectByPrimaryKey(record.get(i).getTask_id());
                java.sql.Date d2=new java.sql.Date(record.get(i).getTask_date().getTime());
                Calendar cal2 = Calendar.getInstance();
                cal2.setFirstDayOfWeek(Calendar.MONDAY);
                cal2.setTime(d2);
                if(cal1.get(0)!=cal2.get(0)||cal1.get(1)!=cal2.get(1)||cal1.get(6)!=cal2.get(6)){
                    if(trecord.getTask_type() == 1) {
                        if (d2.before(d1)) {
                            record.get(i).setTask_date(d1);
                            record.get(i).setTask_now(0);
                            record.get(i).setTask_complete(0);
                            Player_TaskDao.updateByPlayerid(record.get(i));
                        }
                    }
                    else if(trecord.getTask_type() == 2){
                        if(cal1.get(Calendar.WEEK_OF_YEAR) != cal2.get(Calendar.WEEK_OF_YEAR) && d2.before(d1)){
                            record.get(i).setTask_date(d1);
                            record.get(i).setTask_now(0);
                            record.get(i).setTask_complete(0);
                            Player_TaskDao.updateByPlayerid(record.get(i));
                        }
                    }
                }
            }
        }
        return Player_TaskDao.selectAllTask(player_id);
    }

    @Override
    public Task selectByPrimaryKey(Integer task_id){
        return TaskDao.selectByPrimaryKey(task_id);
    }

    @Override
    public boolean taskNowAdd(int player_id){
        List<Player_Task> ptrecord = Player_TaskDao.selectAllTask(player_id);
        int taskNum = TaskDao.selectNum();
        if(ptrecord == null || taskNum > ptrecord.size()){
            java.util.Date d=new java.util.Date();
            java.sql.Date d1=new java.sql.Date(d.getTime());
            List<Task> trecord = TaskDao.selectAll();
            for(int i = 0;i < trecord.size();i++){
                Player_Task ptrecord2 = new Player_Task();
                ptrecord2.setPlayer_id(player_id);
                ptrecord2.setTask_id(trecord.get(i).getTask_id());
                ptrecord2.setTask_now(1);
                if(trecord.get(i).getTask_type()==3)
                    ptrecord2.setTask_now(0);
                ptrecord2.setTask_date(d1);
                ptrecord2.setTask_complete(0);
                Player_TaskDao.insert(ptrecord2);
            }
        }else {
            java.util.Date d=new java.util.Date();
            java.sql.Date d1=new java.sql.Date(d.getTime());
            Calendar cal1 = Calendar.getInstance();
            cal1.setFirstDayOfWeek(Calendar.MONDAY);
            cal1.setTime(d1);
            for(int i = 0;i < ptrecord.size();i++){
                Task trecord = TaskDao.selectByPrimaryKey(ptrecord.get(i).getTask_id());
                java.sql.Date d2=new java.sql.Date(ptrecord.get(i).getTask_date().getTime());
                Calendar cal2 = Calendar.getInstance();
                cal2.setFirstDayOfWeek(Calendar.MONDAY);
                cal2.setTime(d2);
                if(cal1.get(0)!=cal2.get(0)||cal1.get(1)!=cal2.get(1)||cal1.get(6)!=cal2.get(6)){
                    if(trecord.getTask_type() == 1) {
                        if (d2.before(d1)) {
                            ptrecord.get(i).setTask_date(d1);
                            ptrecord.get(i).setTask_now(0);
                            ptrecord.get(i).setTask_complete(0);
                            Player_TaskDao.updateByPlayerid(ptrecord.get(i));
                        }
                    }
                    else if(trecord.getTask_type() == 2){
                        if(cal1.get(Calendar.WEEK_OF_YEAR) != cal2.get(Calendar.WEEK_OF_YEAR) && d2.before(d1)){
                            ptrecord.get(i).setTask_date(d1);
                            ptrecord.get(i).setTask_now(0);
                            ptrecord.get(i).setTask_complete(0);
                            Player_TaskDao.updateByPlayerid(ptrecord.get(i));
                        }
                    }
                }
                if(trecord.getTask_aim() > ptrecord.get(i).getTask_now() && trecord.getTask_type() !=3) {
                    ptrecord.get(i).setTask_now(ptrecord.get(i).getTask_now() + 1);
                    Player_TaskDao.updateByPlayerid(ptrecord.get(i));
                }
            }
        }
        return true;
    }

    @Override
    public boolean missionComplete(Player_Task record){
        Player_Task ptrecord = Player_TaskDao.selectTask(record);
        Task trecord = TaskDao.selectByPrimaryKey(record.getTask_id());
        if(trecord.getTask_aim() > ptrecord.getTask_now())
            return false;
        if(ptrecord.getTask_complete() != 0)
            return false;
        ptrecord.setTask_complete(1);
        int a = Player_TaskDao.updateByPlayerid(ptrecord);
        if(a != 1)
            return false;
        return true;
    }

    @Override
    public boolean taskEventAdd(int player_id){
        List<Player_Task> ptrecord = Player_TaskDao.selectAllTask(player_id);
        int taskNum = TaskDao.selectNum();
        if(ptrecord == null || taskNum > ptrecord.size()){
            java.util.Date d=new java.util.Date();
            java.sql.Date d1=new java.sql.Date(d.getTime());
            List<Task> trecord = TaskDao.selectAll();
            for(int i = 0;i < trecord.size();i++){
                Player_Task ptrecord2 = new Player_Task();
                ptrecord2.setPlayer_id(player_id);
                ptrecord2.setTask_id(trecord.get(i).getTask_id());
                ptrecord2.setTask_now(1);
                ptrecord2.setTask_date(d1);
                ptrecord2.setTask_complete(0);
                Player_TaskDao.insert(ptrecord2);
            }
        }else {
            java.util.Date d=new java.util.Date();
            java.sql.Date d1=new java.sql.Date(d.getTime());
            Calendar cal1 = Calendar.getInstance();
            cal1.setFirstDayOfWeek(Calendar.MONDAY);
            cal1.setTime(d1);
            for(int i = 0;i < ptrecord.size();i++){
                Task trecord = TaskDao.selectByPrimaryKey(ptrecord.get(i).getTask_id());
                java.sql.Date d2=new java.sql.Date(ptrecord.get(i).getTask_date().getTime());
                Calendar cal2 = Calendar.getInstance();
                cal2.setFirstDayOfWeek(Calendar.MONDAY);
                cal2.setTime(d2);
                if(cal1.get(0)!=cal2.get(0)||cal1.get(1)!=cal2.get(1)||cal1.get(6)!=cal2.get(6)){
                    if(trecord.getTask_type() == 1) {
                        if (d2.before(d1)) {
                            ptrecord.get(i).setTask_date(d1);
                            ptrecord.get(i).setTask_now(0);
                            ptrecord.get(i).setTask_complete(0);
                            Player_TaskDao.updateByPlayerid(ptrecord.get(i));
                        }
                    }
                    else if(trecord.getTask_type() == 2){
                        if(cal1.get(Calendar.WEEK_OF_YEAR) != cal2.get(Calendar.WEEK_OF_YEAR) && d2.before(d1)){
                            ptrecord.get(i).setTask_date(d1);
                            ptrecord.get(i).setTask_now(0);
                            ptrecord.get(i).setTask_complete(0);
                            Player_TaskDao.updateByPlayerid(ptrecord.get(i));
                        }
                    }
                }
                if(trecord.getTask_aim() > ptrecord.get(i).getTask_now()) {
                    ptrecord.get(i).setTask_now(ptrecord.get(i).getTask_now() + 1);
                    Player_TaskDao.updateByPlayerid(ptrecord.get(i));
                }
            }
        }
        return true;
    }

    @Override
    public boolean addEventCard(int player_id){
        int backpackmax = BackpackDao.selectCountByPlayerId(player_id);
        if(backpackmax == 100){
            Player_Task record = new Player_Task();
            record.setTask_id(33);
            record.setPlayer_id(player_id);
            Player_Task ptrecord = Player_TaskDao.selectTask(record);
            ptrecord.setTask_complete(0);
            Player_TaskDao.updateByPlayerid(ptrecord);
            return false;
        }
        Cards record2 = CardsDao.selectByPrimaryKey(106);
        Backpack brecord = new Backpack();
        brecord.setCard_id(record2.getCard_id());
        brecord.setPlayer_id(player_id);
        brecord.setCard_ability(record2.getCard_ability_min());
        int MBid = BackpackDao.selectMBidByPlayerId(player_id);
        if (MBid < 100) {
            brecord.setCard_bid(MBid + 1);
            BackpackDao.insertSelective(brecord);
        } else {
            List<Backpack> allBid = BackpackDao.selectBidByPlayerId(player_id);
            for (int o = 0; o < allBid.size(); o++) {
                if ((allBid.get(o)).getCard_bid() != o + 1) {
                    brecord.setCard_bid(o + 1);
                    break;
                }
            }
            BackpackDao.insertSelective(brecord);
        }
        return true;
    }

}
