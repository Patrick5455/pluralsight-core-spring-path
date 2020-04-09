package com.pluralsight.conferencedemo.repositories;


import com.pluralsight.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositories are interfaces
public interface SpeakerSession extends JpaRepository <Speaker, Long> {
}
