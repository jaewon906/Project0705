package com.miniproject0705.Board;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component // @Service, @Repository를 포함하는 개념
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final  BoardFileRepository boardFileRepository;

    @Override
    public BoardDomain findById(Long id) { // 해당하는 게시글을 누르면 id에 맞는 내용을 뽑아냄
        Optional<BoardEntity> foundId = boardRepository.findById(id);

        return foundId.map(BoardDomain::entityToDTO).orElse(null);
    }

    @Override
    public List<BoardDomain> findAll() { // 모든 목록 불러오기
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDomain> boardDomainList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntityList) {
            boardDomainList.add(BoardDomain.entityToDTO(boardEntity));
        }
        return boardDomainList;
    }

    @Override
    public void save(BoardDomain boardDomain) throws IOException { // 게시글 저장 기능
        // 파일 첨부 여부에 따라 로직을 분리해야 한다.
        if (boardDomain.getBoardFile().isEmpty()) {
            BoardEntity boardEntity = BoardEntity.DTOtoEntity(boardDomain);
            boardRepository.save(boardEntity);
        } else {
            /*
            1. DTO에 담긴 파일을 꺼냄
            2. 파일의 이름 가져옴
            3. 서버 저장용 이름을 만듦 -> 내사진.jpg -> 21890371293_내사진.jpg로 변경
            4. 저장 경로 설정
            5. 해당 경로에 파일 저장
            6. board_table에 해당 데이터 save 처리 (게시물)
            7. board_file_table에 해당 데이터 save 처리 (파일)
             */
            MultipartFile boardFile = boardDomain.getBoardFile(); //.1
            String originalFilename = boardFile.getOriginalFilename(); //.2
            String storedFileName = System.currentTimeMillis() + "_" + originalFilename; //.3 currentTimeMillis는 1970년부터 지금까지 시간의 밀리초를 리턴
            String savePath="C:\\Users\\Administrator\\Desktop\\store\\" + storedFileName; //.4
            boardFile.transferTo(new File(savePath)); //.5  transferTo에서는 예외 핸들링을 해야되기 때문에 IOException 예외처리 함.

            BoardEntity boardEntity = BoardEntity.toSaveFileEntity(boardDomain); // DB에 파일 엔티티 저장

            Long saveId = boardRepository.save(boardEntity).getId(); // 게시판 id를 가져옴
            BoardEntity boardEntity1 = boardRepository.findById(saveId).get(); // ''

            BoardFileEntity boardFileEntity = BoardFileEntity.toBoardFileEntity(boardEntity1, originalFilename, storedFileName);
            boardFileRepository.save(boardFileEntity);

        }

    }

    @Override
    public BoardDomain update(BoardDomain boardDomain) {
        BoardEntity boardEntity = BoardEntity.DTOtoEntity(boardDomain);
        //save를 통해 update나 insert를 한다. id가 존재한다면 update, 존재 안하면 insert 실행
        boardRepository.save(boardEntity);
        return findById(boardDomain.getId());
    }

    @Override
    @Transactional // 쿼리문을 직접 작j성해서 사용할 땐 spring data JPA에서 트랜잭션 관리해주지 않는다
    // 따라서 영속성 컨텍스트에서 데이터의 일관성을 위해 @Transactional을 붙혀준다.
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Page<BoardDomain> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; //1을 빼는 이유는 PageRequest에서 page는 인덱스처럼 0부터 시작하기 때문
        int pageLimit = 3;
        Page<BoardEntity> boardEntities = // 1 페이지당 3개씩 글을 보여주고 id기준 내림차순. id은 Entity 명
                boardRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
        Page<BoardDomain> boardDomains = boardEntities.map(entity -> new BoardDomain(entity.getId(), entity.getBoardWriter(), entity.getBoardTitle(), entity.getBoardHits(), entity.getBoardCreatedTime()));
        /*
         * boardEntities (Page 인터페이스) 에서 제공하는 주요 메서드
         * getContent() : 요청 페이지에 해당하는 글
         * getTotalElements() : 전체 글 갯수
         * getNumber() : DB로 요청한 페이지 번호
         * getTotalPages() : 전체 페이지 갯수
         * getSize() : 한 페이지에 보여지는 글 갯수
         * hasPrevious() : 이전 페이지 존재 여부
         * isFirst() : 첫 페이지 여부
         * isLast() : 마지막 페이지 여부
         * map() : 타입을 변환시켜줄 수 있다. 여기서는 Entity <-> DTO 변환
         * */
        return boardDomains;
    }
}
