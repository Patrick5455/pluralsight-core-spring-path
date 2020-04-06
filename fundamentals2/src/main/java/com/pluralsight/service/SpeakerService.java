package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface SpeakerService {

    public List<Speaker> findAll ();
}
