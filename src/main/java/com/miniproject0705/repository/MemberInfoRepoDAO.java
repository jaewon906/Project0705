package com.miniproject0705.repository;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberInfoRepoDAO extends JpaRepository<MemberEntity, Long>{ //<T,ID> T = 엔티티 , ID = id type

    Optional<MemberEntity> findByUserId(String UserId);

}
