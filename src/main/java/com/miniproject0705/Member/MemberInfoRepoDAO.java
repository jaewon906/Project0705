package com.miniproject0705.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInfoRepoDAO extends JpaRepository<MemberEntity, Long>{ //<T,ID> T = 엔티티 , ID = id type

    Optional<MemberEntity> findByUserId(String UserId);

}
