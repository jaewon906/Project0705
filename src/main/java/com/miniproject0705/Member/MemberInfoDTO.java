package com.miniproject0705.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //getter 메서드를 만들지 않아도 된다
@Setter //setter 메서드를 만들지 않아도 된다.
@NoArgsConstructor // 기본 생성자를 자동으로 만들어줌
@AllArgsConstructor // 모든 필드값을 매개변수로 받는 생성자를 만듬
public class MemberInfoDTO {

    private Long No; //PK

    private String userId; //id

    private String password; //password

    private String userName; //이름

    private String nickname; // nickname

    private String email; //email

    private String address; //address

    public static MemberInfoDTO toMemberInfoDTO(MemberEntity memberEntity) {
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();

        memberInfoDTO.setNo(memberEntity.getNo());
        memberInfoDTO.setUserId(memberEntity.getUserId());
        memberInfoDTO.setPassword(memberEntity.getPassword());
        memberInfoDTO.setUserName(memberEntity.getUserName());
        memberInfoDTO.setNickname(memberEntity.getNickname());
        memberInfoDTO.setEmail(memberEntity.getEmail());
        memberInfoDTO.setAddress(memberEntity.getAddress());

        return memberInfoDTO;
    }


}
