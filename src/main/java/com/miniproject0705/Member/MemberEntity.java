package com.miniproject0705.Member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //@Table을 생략하면 테이블 명이 MemberInfoDTO인 곳으로 매핑
@Table(name = "memberInfo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id //기본키를 나타내기 위해 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Long 타입이면 IDENTITY가능, String 이면 AUTO or SEQUENCE
    private Long No;
    @Column(unique = true, nullable = false) //기본적으로 테이블 컬럼의 password로 매핑, name속성으로 name="user_pw" 로 지정할 수 있다.
    private String userId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String nickname;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;

    // DTO 객체를 Entity로 넘겨줘야 합니다.
    public static MemberEntity toMemberEntity(MemberInfoDTO memberInfoDTO) {
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setNo(memberInfoDTO.getNo());
        memberEntity.setUserId(memberInfoDTO.getUserId());
        memberEntity.setPassword(memberInfoDTO.getPassword());
        memberEntity.setUserName(memberInfoDTO.getUserName());
        memberEntity.setNickname(memberInfoDTO.getNickname());
        memberEntity.setEmail(memberInfoDTO.getEmail());
        memberEntity.setAddress(memberInfoDTO.getAddress());

        return memberEntity;
    }

}
