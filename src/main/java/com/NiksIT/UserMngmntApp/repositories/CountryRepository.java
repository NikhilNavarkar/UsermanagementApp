package com.NiksIT.UserMngmntApp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NiksIT.UserMngmntApp.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Serializable> {

}
