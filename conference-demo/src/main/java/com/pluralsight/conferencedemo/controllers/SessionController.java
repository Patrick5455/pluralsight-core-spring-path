package com.pluralsight.conferencedemo.controllers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;


    @GetMapping
    public List<Session> list(){

        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping({"id"})
    public Session get(@PathVariable Long id){

        return sessionRepository.getOne(id);
    }

   @PostMapping
    public Session create (@RequestBody final  Session session){
        return sessionRepository.saveAndFlush(session);
   }

   @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id){
        //ALso need to check for children records before deleting
       sessionRepository.deleteById(id);
   }

   @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, Session session){

        Session existingSession = sessionRepository.getOne(id);

       BeanUtils.copyProperties(session, existingSession, "session_id");

      return sessionRepository.saveAndFlush(existingSession);

   }
}
