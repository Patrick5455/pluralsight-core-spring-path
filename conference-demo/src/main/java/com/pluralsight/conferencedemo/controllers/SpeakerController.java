package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    public SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list(){
       return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping({"id"})
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create (@RequestBody final  Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //Also need to check for children records before deleting.
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update (@PathVariable Long id, Speaker speaker){

        Speaker existingSpeaker = speakerRepository.getOne(id);
//TODO:
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");

        return speakerRepository.saveAndFlush(existingSpeaker);


    }

}
