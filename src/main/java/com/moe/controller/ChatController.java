package com.moe.controller;

import com.moe.bean.ChatBase;
import com.moe.model.Chat;
import com.moe.model.ChatA;
import com.moe.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ChatService ChatService;

    @RequestMapping("/chatroom")
    public String chatRoom(){
        return "chatroom";
    }

    @RequestMapping(value = "/chatroom/sendmessage", method = RequestMethod.POST)
    @ResponseBody
    public ChatBase sendMessage(@RequestBody ChatBase Chatinfo){
        ChatBase carrier = new ChatBase();
        Chat record = new Chat();
        record.setPlayer_id(Integer.parseInt(Chatinfo.getPlayer_id()));
        record.setChat_message(Chatinfo.getChat_message());
        int a = ChatService.insert(record);
        if(a == 1){
            carrier.setMessage("true");
        }else carrier.setMessage("false");
        return carrier;
    }

    @RequestMapping(value = "/chatroom/getmessageh", method = RequestMethod.POST)
    @ResponseBody
    public List<ChatBase> getMessageH(){
        List<ChatBase> carrier = new ArrayList();
        List<ChatA> crecord = ChatService.selectHour();
        if(crecord == null){
            ChatBase record = new ChatBase();
            record.setMessage("no");
            carrier.add(record);
            return carrier;
        }
        for (int i = 0;i < crecord.size();i++){
            ChatBase record = new ChatBase();
            SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
            record.setMessage("true");
            record.setPlayer_name(crecord.get(i).getPlayer_name());
            record.setChat_message(crecord.get(i).getChat_message());
            record.setChat_date(""+ft.format(crecord.get(i).getChat_date()));
            carrier.add(record);
        }
        return carrier;
    }

    @RequestMapping(value = "/chatroom/getmessages", method = RequestMethod.POST)
    @ResponseBody
    public List<ChatBase> getMessageS(){
        List<ChatBase> carrier = new ArrayList();
        List<ChatA> crecord = ChatService.selectSecond();
        if(crecord == null){
            ChatBase record = new ChatBase();
            record.setMessage("no");
            carrier.add(record);
            return carrier;
        }
        for (int i = 0;i < crecord.size();i++){
            ChatBase record = new ChatBase();
            SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss");
            record.setMessage("true");
            record.setPlayer_name(crecord.get(i).getPlayer_name());
            record.setChat_message(crecord.get(i).getChat_message());
            record.setChat_date(""+ft.format(crecord.get(i).getChat_date()));
            carrier.add(record);
        }
        return carrier;
    }

}
