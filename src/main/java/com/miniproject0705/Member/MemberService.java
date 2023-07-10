package com.miniproject0705.Member;

import java.util.List;

public interface MemberService {
    MemberInfoDTO save(MemberInfoDTO memberInfoDTO); // 회원가입 로직
    MemberInfoDTO signIn(MemberInfoDTO memberInfoDTO); // 로그인 로직

    List<MemberInfoDTO> findAll();

    MemberInfoDTO findById(Long id);

    MemberInfoDTO updateForm(String userId);

    void update(MemberInfoDTO memberInfoDTO);

    void deleteById(Long id);
}
