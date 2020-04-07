package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    @Override
    public List<Speaker> findAll(){ return repository.findAll(); }


    public SpeakerServiceImpl(){}

    public SpeakerServiceImpl (SpeakerRepository repository){
        this.repository = repository;
    }

    //setter for xml injection of Repository
    public void setSpeakerRepository(SpeakerRepository repository){

        this.repository = repository;
    }


}
