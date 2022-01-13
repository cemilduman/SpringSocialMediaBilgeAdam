package com.duman.springproject.controller;

import com.duman.springproject.dto.SubscriberDto;
import com.duman.springproject.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@Log4j2
public class SubscriberController {

    @GetMapping("/firstUygulama")
    @ResponseBody
    public String getFirstApplication(){
        return "Merhabalar";
    }
    @GetMapping("/birinci")
    @ResponseBody
    public String getQuery(){
        return "yukleniyor...";
    }

    @GetMapping("/ikinci")
    public String secondMethod(){
        return "subscriber";
    }

    //Only a static text is printed on subscriber.jsp
    @GetMapping("/ucuncu")
    public String thirdMethod(Model model){
        model.addAttribute("staticText","Hello, I am a Static Text");
        return "subscriber";
    }

    //SubscriberDto printed on subscriber.jsp
    @GetMapping("/dorduncu")
    public String fourthMethod(Model model){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(1L).
                subscriberName("Cemil").
                subscriberSurname("Duman").
                subscriberAdress("Pendik/İstanbul").
                creationDate(new Date(System.currentTimeMillis())).
                build();
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    //SubscriberDto and some Static Text printed on subscriber.jsp
    @GetMapping("/besinci")
    public String fifthMethod(Model model){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(1L).
                subscriberName("Cemil").
                subscriberSurname("Duman").
                subscriberAdress("Pendik/İstanbul").
                creationDate(new Date(System.currentTimeMillis())).
                build();
        model.addAttribute("staticText","Hello, I am a Static Text");
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    //With Path Variable
    @GetMapping("/altıncı/{param}")
    public String sixthMethod(Model model, @PathVariable(name = "param") Integer id){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(id).
                subscriberName("Cemil").
                subscriberSurname("Duman").
                subscriberAdress("Pendik/İstanbul").
                creationDate(new Date(System.currentTimeMillis())).
                build();
        model.addAttribute("staticText","Hello, I am a Static Text");
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    //With Path Variable and Validation
    @GetMapping({"/yedinci","/yedinci/{param}"})
    public String seventhMethod(Model model, @PathVariable(name = "param", required = false) Integer id){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(1L).
                subscriberName("Cemil").
                subscriberSurname("Duman").
                subscriberAdress("Pendik/İstanbul").
                creationDate(new Date(System.currentTimeMillis())).
                build();
        if(id != null){
            subscriber.setSubscriberId(id);
        }
        model.addAttribute("staticText","Hello, I am a Static Text");
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    //With RequestParam
    @GetMapping("/sekizinci/")
    public String eighthMethod(Model model, @RequestParam(name = "id") Integer id){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(id).
                subscriberName("Cemil").
                subscriberSurname("Duman").
                subscriberAdress("Pendik/İstanbul").
                creationDate(new Date(System.currentTimeMillis())).
                build();
        model.addAttribute("staticText","Hello, I am a Static Text");
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    //With requstParam and Validation
    @GetMapping("/dokuzuncu")
    public String ninthMethod(Model model, @RequestParam(name = "id", required = false, defaultValue = "52") Integer id){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(id).
                subscriberName("Cemil").
                subscriberSurname("Duman").
                subscriberAdress("Pendik/İstanbul").
                creationDate(new Date(System.currentTimeMillis())).
                build();
        model.addAttribute("staticText","Hello, I am a Static Text");
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    //With Path Variable and Validation
    @GetMapping("/onuncu")
    public String tenthMethod(Model model,
                        @RequestParam(name = "id", required = false, defaultValue = "52") Integer id,
                        @RequestParam(name = "name", required = false, defaultValue = "Cemil") String name,
                        @RequestParam(name = "surname", required = false, defaultValue = "Duman") String surname,
                        @RequestParam(name = "adress", required = false, defaultValue = "Pendik/İstanbul") String adress){
        SubscriberDto subscriber = SubscriberDto.builder().
                subscriberId(id).
                subscriberName(name).
                subscriberSurname(surname).
                subscriberAdress(adress).
                creationDate(new Date(System.currentTimeMillis())).
                build();
        model.addAttribute("staticText","Hello, I am a Static Text");
        model.addAttribute("subscriber_print",subscriber);
        return "subscriber";
    }

    @GetMapping("/subscription")
    public String getFormApplication(Model model) {
        //Database select işlemlerimi burdan yapıcam
        SubscriberDto subscriberDto = SubscriberDto.builder()
                .subscriberId(0)
                .subscriberName("Name...")
                .subscriberSurname("Surname...")
                .subscriberAdress("Adress...")
                .creationDate(new Date(System.currentTimeMillis()))
                .build();
        model.addAttribute("form_key", subscriberDto);
        return "subscriberForm";
    }

    //With Path Variable and Validation
    @PostMapping("/subscription")
    public String formApplication(Model model, SubscriberDto subscriber) {
        SubscriberDto subscriberDto = SubscriberDto.builder().
                subscriberId(subscriber.getSubscriberId()).
                subscriberName(subscriber.getSubscriberName()).
                subscriberSurname(subscriber.getSubscriberSurname()).
                subscriberAdress(subscriber.getSubscriberAdress()).
                creationDate(new Date(System.currentTimeMillis())).
                build();
        log.info(subscriberDto.getSubscriberId());
        log.info(subscriberDto.getSubscriberName());
        log.info(subscriberDto.getSubscriberSurname());
        log.info(subscriberDto.getSubscriberAdress());
        log.info(subscriberDto.getCreationDate());
        model.addAttribute("form_key",subscriber);
        Utils.subscriberSave(subscriberDto);
        Utils.writing2Doc(subscriberDto);
        return "subscriberForm";
    }

}
