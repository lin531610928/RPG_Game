package com.moe.service.impl;

import com.moe.dao.SigninMapper;
import com.moe.model.Signin;
import com.moe.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SignServiceImpl implements SigninService {

    @Autowired
    private SigninMapper SigninDao;

    @Override
    public boolean canSignin(int player_id){
        Signin record = SigninDao.selectByPlayerid(player_id);
        java.util.Date d=new java.util.Date();
        java.sql.Date d2=new java.sql.Date(d.getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        if(record == null){
            return true;
        }else{
            java.sql.Date d1=new java.sql.Date(record.getChat_date().getTime());
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(d1);
            if(cal1.get(0)!=cal2.get(0)||cal1.get(1)!=cal2.get(1)||cal1.get(6)!=cal2.get(6)){
                if(d1.before(d2))
                return true;
                else return false;
            }else return false;
        }
    }

    @Override
    public boolean okSignin(int player_id){
        Signin record = new Signin();
        Signin record2 = SigninDao.selectByPlayerid(player_id);
        java.util.Date d=new java.util.Date();
        java.sql.Date d1=new java.sql.Date(d.getTime());
        record.setPlayer_id(player_id);
        record.setChat_date(d1);
        record.setSign_type(1);
        if(record2 == null){
            int a=SigninDao.insert(record);
            if(a == 1){
                return true;
            }else return false;
        }else {
            int a=SigninDao.updateByPlayerid(record);
            if(a == 1){
                return true;
            }else return false;
        }
    }

}
