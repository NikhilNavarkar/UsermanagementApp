package com.NiksIT.UserMngmntApp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NiksIT.UserMngmntApp.entities.UserAccounts;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccounts, Serializable> {

    public UserAccounts findByEmailAndPassword(String email,String password);
    
    public UserAccounts findByEmail(String email);

}
