package com.miniproject0705.service;

import com.miniproject0705.domain.MemberInfoDTO;

import java.util.List;

public interface MemberService {
    MemberInfoDTO save(MemberInfoDTO memberInfoDTO); // 회원가입 로직
    MemberInfoDTO signIn(MemberInfoDTO memberInfoDTO); // 로그인 로직
    void findMyAccount(); //계정 찾기 로직
    void withdrawal(); //회원 탈퇴 로직

    List<MemberInfoDTO> findAll();

    MemberInfoDTO findById(Long id);

    MemberInfoDTO updateForm(String userId);

    void update(MemberInfoDTO memberInfoDTO);

    void deleteById(Long id);
}
