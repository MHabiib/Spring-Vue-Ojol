package com.future.jpa.service.serviceImpl;

import com.future.jpa.model.Member;
import com.future.jpa.repository.MemberRepository;
import com.future.jpa.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> loadAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member createMember(Member member) {
        memberRepository.save(member);
        member.setId(member.getId());
        member.setBalance(member.getBalance());
        member.setName(member.getName());
        member.setEmail(member.getEmail());
        member.setPassword(member.getPassword());
        return memberRepository.save(member);
    }


    @Override
    public ResponseEntity<Member> updatedmember(int id, Member member) {
        
            Member memberData = memberRepository.findById(id);
            if (member == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            memberData.setBalance(member.getBalance());
            memberData.setName(member.getName());
            memberData.setEmail(member.getEmail());
            memberData.setPassword(memberData.getPassword());
            Member updatedmember = memberRepository.save(memberData);
            return new ResponseEntity<>(updatedmember, HttpStatus.OK);
        }
    }


