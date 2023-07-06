package com.miniproject0705.repository;

import com.miniproject0705.domain.MemberInfoDTO;

public class MemberInfoRepoDAOClass implements MemberInfoRepoDAO{

    @Override
    public MemberInfoDTO saveInfo(MemberInfoDTO memberInfoDTO) { //회원 정보 저장 구현
        MemberInfoRepoDAO asdf = new MemberInfoRepoDAOClass();
        memberInfoDTO.getId();
        memberInfoDTO.getNickname();
        memberInfoDTO.getPassword();
       return null;
    }

    @Override
    public MemberInfoDTO findInfo(MemberInfoDTO memberInfoDTO) { // 회원 정보 찾기 구현
        return null;
    }

    @Override
    public MemberInfoDTO deleteInfo(MemberInfoDTO memberInfoDTO) { // 회원 정보 삭제 구현
        return null;
    }
}
