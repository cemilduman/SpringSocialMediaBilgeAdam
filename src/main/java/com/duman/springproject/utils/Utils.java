package com.duman.springproject.utils;

import com.duman.springproject.dao.SubscriberDao;
import com.duman.springproject.dto.SubscriberDto;
import lombok.extern.log4j.Log4j2;

import java.io.*;

@Log4j2
public class Utils {
    private static SubscriberDao subDao;

    public static void subscriberSave(SubscriberDto dto){
        subDao = new SubscriberDao();
        subDao.insert(dto);
    }

    public static void writing2Doc(SubscriberDto dto){
        String path = "C:\\Spring\\subscriber.txt";
        BufferedWriter bw;
        try {
            File file = new File(path);
            if(file.createNewFile()){
                log.info("New File is created");
            }else{
                log.info("File is already exist");
            }
            bw = new BufferedWriter(new FileWriter(file));
//            bw.write("Subscriber Name: " + dto.getSubscriberId());
//            bw.write("Subscriber Name: " + dto.getSubscriberName());
//            bw.write("Subscriber Name: " + dto.getSubscriberSurname());
//            bw.write("Subscriber Name: " + dto.getSubscriberAdress());
//            bw.write("Subscriber Name: " + dto.getCreationDate());
            bw.write(dto.toString());
            bw.flush();
            bw.close();
        }catch (IOException ex){
            log.error("Something bad happened -->" +  ex.getMessage());
            ex.printStackTrace();
        }
    }
}
