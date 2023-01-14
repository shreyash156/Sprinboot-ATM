package com.project.springbootATM.service;



import org.springframework.data.repository.query.Param;

import com.project.springbootATM.model.Account;
import com.project.springbootATM.model.User;

public interface AccountService {

    User createAccount(User newuser);

   



}