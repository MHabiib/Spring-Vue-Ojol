package com.future.jpa.service.serviceImpl;

import com.future.jpa.model.Booking;
import com.future.jpa.model.Driver;
import com.future.jpa.model.Member;
import com.future.jpa.model.Transaction;
import com.future.jpa.repository.BookingRepository;
import com.future.jpa.repository.DriverRepository;
import com.future.jpa.repository.MemberRepository;
import com.future.jpa.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    DriverRepository driverRepository;
/*    @Autowired
    TransactionRepository transactionRepository;*/

    @Override
    public boolean createTransaction(@RequestBody Transaction transaction) {
        Booking bookingData=bookingRepository.findById(transaction.getBookingId());
        Driver driverData=driverRepository.findByStnk(transaction.getStnk());
        Member memberData=memberRepository.findByName(transaction.getName());

        if (bookingData==null||driverData==null||memberData==null)
            return false;
        else{
            if (transaction.getStatus().equals("ACCEPTED")) {
                if (transaction.getPaymentMethod().equals("BLIPAY")){
                    memberData.setBalance(memberData.getBalance()-bookingData.getPrice());
                    driverData.setBalance(driverData.getBalance() + bookingData.getPrice());
                }
                bookingData.setStatus("ACCEPTED");
                memberRepository.save(memberData);
                driverRepository.save(driverData);
                bookingRepository.save(bookingData);
                return true;
            }
            else if (transaction.getStatus().equals("REJECTED")) {
                bookingData.setStatus("REJECTED");
                bookingRepository.save(bookingData);
                return true;
            }
        }
        return false;
    }
}
