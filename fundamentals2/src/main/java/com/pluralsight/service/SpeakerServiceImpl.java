package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {


    private SpeakerRepository repository;


    //constructors
    public SpeakerServiceImpl (SpeakerRepository repository){
        System.out.println("SpeakerServiceImpl repository constructor ");
        this.repository = repository;
    }

    public SpeakerServiceImpl (){
        System.out.println("SpeakerServiceImpl no args constructor ");
    }

    //setter for repository
    @Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("We are in the setter");
        this.repository = repository;
    }


   @Override
    public List<Speaker> findAll(){

        return repository.findAll();

    }


}
