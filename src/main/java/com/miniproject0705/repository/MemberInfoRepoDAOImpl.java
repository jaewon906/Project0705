package com.miniproject0705.repository;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MemberInfoRepoDAOImpl implements MemberInfoRepoDAO {

    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em = emf.createEntityManager();
    //EntityManager를 사용하여 데이터를 변경하는 경우, 일반적으로 트랜잭션 내에서 작업해야 합니다. 따라서 트랜잭션을 시작하고 커밋 또는 롤백하는 작업을 추가해야 합니다.
    EntityTransaction transaction = em.getTransaction();
    private final MemberService memberService;

    public MemberInfoRepoDAOImpl(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public MemberInfoDTO save(MemberInfoDTO memberInfoDTO) {
        transaction.begin();
        em.persist(memberInfoDTO);
        transaction.commit();
        return null;
    }

    @Override
    public Optional<MemberInfoDTO> findMemberInfoDTOByIdAndPassword(MemberInfoDTO memberInfoDTO) {
        String id = memberInfoDTO.getId();
        return null;
    }

    @Override
    public MemberInfoDTO modifyInfo(MemberInfoDTO memberInfoDTO) {
        return null;
    }

    @Override
    public MemberInfoDTO delete() {
        return null;
    }
}
