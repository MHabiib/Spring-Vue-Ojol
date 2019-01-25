package com.future.jpa.controller;

import com.future.jpa.model.Transaction;
import com.future.jpa.repository.BookingRepository;
import com.future.jpa.repository.DriverRepository;
import com.future.jpa.repository.MemberRepository;
import com.future.jpa.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

/*    private static final Integer i =500;
    @Async
    @Scheduled(fixedDelay=i)
    public void doSomething() {

    }*/
    @PostMapping("/transaction/process")
    public boolean createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }
}
