package com.miniproject0705.service;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.repository.MemberInfoRepoDAO;
import com.miniproject0705.repository.MemberInfoRepoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepoDAO memberInfoRepoDAO;
    private final MemberInfoDTO memberInfoDTO;

    @Autowired
    public MemberServiceImpl(MemberInfoRepoDAO memberInfoRepoDAO, MemberInfoDTO memberInfoDTO) {
        this.memberInfoRepoDAO = memberInfoRepoDAO;
        this.memberInfoDTO = memberInfoDTO;
    }


    @Override
    public void signUp() {


        memberInfoRepoDAO.findMemberInfoDTOByIdAndPassword(memberInfoDTO);

        memberInfoRepoDAO.save(memberInfoDTO);
    }

    @Override
    public void signIn() {

    }

    @Override
    public void findMyAccount() {

    }

    @Override
    public void withdrawal() {

    }
}
