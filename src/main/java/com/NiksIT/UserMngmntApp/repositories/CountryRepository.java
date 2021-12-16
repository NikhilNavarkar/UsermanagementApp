package com.NiksIT.UserMngmntApp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NiksIT.UserMngmntApp.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {

}
