package com.miniproject0705.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    public List<MemberInfoDTO> findAll() { //모든 회원목록 불러오기
        List<MemberEntity> memberEntityList = memberInfoRepoDAO.findAll();
        List<MemberInfoDTO> memberDTOList = new ArrayList<>();

        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberInfoDTO.toMemberInfoDTO(memberEntity));
        }
        return memberDTOList;
    }

    @Override
    public MemberInfoDTO findById(Long id) { //특정 id에 해당하는 데이터 찾기
        Optional<MemberEntity> optionalMemberEntity = memberInfoRepoDAO.findById(id);
        //          get() 메서드로 한 번 거쳐야 Optional 객체안의 memberEntity에 접근할 수 있다.
        return optionalMemberEntity.map(MemberInfoDTO::toMemberInfoDTO).orElse(null);
    }

    @Override
    public MemberInfoDTO updateForm(String userId) {
        Optional<MemberEntity> optionalMemberEntity = memberInfoRepoDAO.findByUserId(userId);
        if (optionalMemberEntity.isPresent()) {
            return MemberInfoDTO.toMemberInfoDTO(optionalMemberEntity.get());
        } else {
            return null;
        }

    }

    @Override
    public void update(MemberInfoDTO memberInfoDTO) { // 회원정보 수정
        //save 내장 메서드는 no(pk)값이 없는 엔티티가 넘어오면 INSERT 쿼리문을 수행하고 no값이 있는 엔티티가 넘어오면 UPDATE 쿼리문을 수행
        MemberEntity updateMemberEntity = MemberEntity.toMemberEntity(memberInfoDTO);
        memberInfoRepoDAO.save(updateMemberEntity);
    }

    @Override
    public void deleteById(Long id) { //회원정보 삭제
        memberInfoRepoDAO.deleteById(id);
    }

}
