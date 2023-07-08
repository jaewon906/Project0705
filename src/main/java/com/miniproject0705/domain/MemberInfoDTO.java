package com.miniproject0705.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //getter 메서드를 만들지 않아도 된다
@Setter //setter 메서드를 만들지 않아도 된다.
@NoArgsConstructor // 기본 생성자를 자동으로 만들어줌
@AllArgsConstructor // 모든 필드값을 매개변수로 받는 생성자를 만듬
public class MemberInfoDTO {

    private String id; //id

    private String password; //password

    private String nickname; // nickname

    private String email; //email

    private String address; //address


}
