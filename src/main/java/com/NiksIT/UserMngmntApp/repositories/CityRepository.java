package com.NiksIT.UserMngmntApp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NiksIT.UserMngmntApp.entities.City;

public interface CityRepository extends JpaRepository<City, Serializable> {

}
