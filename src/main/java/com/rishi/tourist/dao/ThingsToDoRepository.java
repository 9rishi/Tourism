package com.rishi.tourist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.tourist.model.ThingsToDo;

public interface ThingsToDoRepository extends JpaRepository<ThingsToDo,String>{

}
