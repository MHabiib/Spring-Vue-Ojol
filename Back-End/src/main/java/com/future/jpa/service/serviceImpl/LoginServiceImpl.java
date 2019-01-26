package com.future.jpa.service.serviceImpl;

import com.future.jpa.model.Driver;
import com.future.jpa.model.Member;
import com.future.jpa.model.requestResponse.LoginRequest;
import com.future.jpa.model.requestResponse.LoginResponse;
import com.future.jpa.repository.DriverRepository;
import com.future.jpa.repository.MemberRepository;
import com.future.jpa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DriverRepository driverRepository;

    public LoginResponse authenticate(@RequestBody LoginRequest request) {
        LoginResponse a = new LoginResponse();
        Member memberData = memberRepository.findByEmail(request.getEmail());
        System.out.println(request.getEmail());
        System.out.println(memberData);
        if(memberData!=null){
            if (request.getEmail().equals(memberData.getEmail())&& request.getPassword().equals(memberData.getPassword())){
                a.setSuccess(true);
                a.setName(memberData.getName());
                a.setBalance(memberData.getBalance());
                a.setRole("MEMBER");
                a.setEmail(memberData.getEmail());
                a.setId(memberData.getId());
                return a;
            }
            else {
                a.setSuccess(false);
                return a;
            }
        }
        Driver driverData=driverRepository.findByEmail(request.getEmail());
        if (driverData!=null){
            if (request.getEmail().equals(driverData.getEmail())&& request.getPassword().equals(driverData.getPassword())){
                a.setSuccess(true);
                a.setName(driverData.getName());
                a.setBalance(driverData.getBalance());
                a.setRole("DRIVER");
                a.setEmail(driverData.getEmail());
                a.setId(driverData.getId());
                return a;
            }
            else {
                a.setSuccess(false);
                return a;
            }
        }
        else {
            a.setSuccess(false);
            return a;
        }
    }
}
