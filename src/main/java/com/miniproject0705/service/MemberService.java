package com.miniproject0705.service;

import com.miniproject0705.domain.MemberInfoDTO;

public interface MemberService {
    public MemberInfoDTO save(MemberInfoDTO memberInfoDTO); // 회원가입 로직
    public MemberInfoDTO signIn(MemberInfoDTO memberInfoDTO); // 로그인 로직
    public void findMyAccount(); //계정 찾기 로직
    public void withdrawal(); //회원 탈퇴 로직
}
