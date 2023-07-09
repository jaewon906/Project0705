package com.miniproject0705.service;

import com.miniproject0705.domain.MemberInfoDTO;
import com.miniproject0705.entity.MemberEntity;
import com.miniproject0705.repository.MemberInfoRepoDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepoDAO memberInfoRepoDAO;


    @Override
    public MemberInfoDTO save(MemberInfoDTO memberInfoDTO) {
        // static이라서 생성자 없이 만들 수 있다
        // DTO값을 엔티티로 변환한 후 JPARepository의 save메서드에 입력.
        // alt + enter 하면 리턴값을 담아주는 객체 자동 생성해줌

        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberInfoDTO);
        memberInfoRepoDAO.save(memberEntity);

        return memberInfoDTO;
    }

    @Override
    public MemberInfoDTO signIn(MemberInfoDTO memberInfoDTO) {
        Optional<MemberEntity> byUserId = memberInfoRepoDAO.findByUserId(memberInfoDTO.getUserId());
//        isPresent()를 통해 id가 존재하는지 존재하지 않는지 판단.
        if (byUserId.isPresent()) {
            MemberEntity memberEntity = byUserId.get();
            //비밀번호가 일치할 때
            if (memberInfoDTO.getPassword().equals(memberInfoDTO.getPassword())) {
                //엔티티를 DTO로 변환 후 리턴
                MemberInfoDTO dto = MemberInfoDTO.toMemberInfoDTO(memberEntity);

                return dto;

            }
            //비밀번호가 일치하지 않을 때
            else {
                return null;
            }

        }
        // 해당하는 id가 없을때
        else {
            return null;
        }

    }

    @Override
    public void findMyAccount() {

    }

    @Override
    public void withdrawal() {

    }
}
