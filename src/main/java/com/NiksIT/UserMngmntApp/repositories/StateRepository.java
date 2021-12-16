package com.NiksIT.UserMngmntApp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NiksIT.UserMngmntApp.entities.State;

public interface StateRepository extends JpaRepository<State, Serializable> {

}
