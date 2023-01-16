package com.andrew.SpringSecurity.services;

import com.andrew.SpringSecurity.models.Person;
import com.andrew.SpringSecurity.repositories.PeopleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    private final PeopleRepositories peopleRepositories;

    @Autowired
    public RegistrationService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    @Transactional
    public void register(Person person){
        peopleRepositories.save(person);
    }
}
