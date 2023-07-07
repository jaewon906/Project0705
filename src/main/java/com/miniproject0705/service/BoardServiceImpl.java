package com.miniproject0705.service;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.repository.MemberInfoRepoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardServiceImpl implements BoardService{

    private final MemberInfoRepoDAO memberInfoRepoDAO;

    @Autowired
    public BoardServiceImpl(MemberInfoRepoDAO memberInfoRepoDAO){
        this.memberInfoRepoDAO = memberInfoRepoDAO;

    }
    @Override
    public void addBoard() {
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();


    }

    @Override
    public void deleteBoard() {

    }

    @Override
    public void modifyBoard() {

    }

    @Override
    public void searchBoard() {

    }
}
