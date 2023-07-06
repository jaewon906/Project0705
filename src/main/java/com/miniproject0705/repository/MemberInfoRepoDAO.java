package com.miniproject0705.repository;

import com.miniproject0705.domain.MemberInfoDTO;

public interface MemberInfoRepoDAO {
    MemberInfoDTO saveInfo(MemberInfoDTO memberInfoDTO); // 회원정보 저장

    MemberInfoDTO findInfo(MemberInfoDTO memberInfoDTO); // 회원정보 찾기

    MemberInfoDTO deleteInfo(MemberInfoDTO memberInfoDTO); // 회원정보 삭제
}
