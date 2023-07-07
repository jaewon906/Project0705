package com.miniproject0705.domain;

import jakarta.persistence.*;

@Entity //@Table을 생략하면 테이블 명이 MemberInfoDTO인 곳으로 매핑
@Table(name = "MEMBER_INFO")
public class MemberInfoDTO {
    @Id //기본키를 나타내기 위해 사용
    @GeneratedValue(strategy = GenerationType.AUTO) // Long 타입이면 IDENTITY가능, String 이면 AUTO or SEQUENCE
    private String id;
    @Column(nullable = false) //기본적으로 테이블 컬럼의 password로 매핑, name속성으로 name="user_pw" 로 지정할 수 있다.
    private String password;
    @Column(nullable = false)
    private String nickname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
