package com.moe;

import com.moe.model.*;
import com.moe.service.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MyTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TaskService cc;

    @Autowired
    private BackpackService dd;

    @Test
    public void aa(){
        List<Player_Task> ad = cc.allTask(10001);
        for(int i = 0;i < ad.size(); i++){
            System.out.println(ad.get(i).getTask_id());
        }
    }

    @Test
    public void bb(){
        Calendar cal= Calendar.getInstance();
        cal.setTime(new Date());
        int week=cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(week);
    }
}
