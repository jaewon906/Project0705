package com.miniproject0705.service;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.repository.MemberInfoRepoDAO;
import com.miniproject0705.repository.MemberInfoRepoDAOImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepoDAO memberInfoRepoDAO;
    private final MemberInfoDTO memberInfoDTO;


    @Override
    public MemberInfoDTO save(MemberInfoDTO memberInfoDTO) {

        return memberInfoDTO;
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
