package com.miniproject0705.repository;

import com.miniproject0705.domain.MemberInfoDTO;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberInfoRepoDAO{

    MemberInfoDTO save(MemberInfoDTO memberInfoDTO); // 회원정보 저장

    Optional<MemberInfoDTO> findMemberInfoDTOByIdAndPassword(MemberInfoDTO memberInfoDTO); // 회원정보 찾기

    MemberInfoDTO modifyInfo(MemberInfoDTO memberInfoDTO); // 회원정보 수정

    MemberInfoDTO delete(); // 회원정보 삭제
}
