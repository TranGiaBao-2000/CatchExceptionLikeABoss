package com.example.onetomany.controller;

import com.example.onetomany.entity.Account;
import com.example.onetomany.entity.Role;
import com.example.onetomany.handleException.exception.RoleNotFoundException;
import com.example.onetomany.repository.AccountRepo;
import com.example.onetomany.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@RestController
public class AccountController {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    RoleRepo roleRepo;

    @PostMapping("/create")
    public ResponseEntity<?> create(){
        Account newAcc = null;
        List<Role> listRole = roleRepo.findAll();
        long roleID =5;
//        boolean checkRole = listRole.stream().filter(i->i.getId() == roleID).any;
        boolean checkRole = listRole.stream().anyMatch(i->i.getId() == roleID);
        if(checkRole){
            Account acc = new Account(-1,"giabao","123456","Tran Gia Bao","0923781212","Thanh Da",null);
            newAcc = accountRepo.save(acc);
            int a = Integer.parseInt("a");
            return new ResponseEntity<Account>(newAcc,HttpStatus.OK);
        }else{
            throw new RoleNotFoundException("Role id does not exits");
        }
    }

}
