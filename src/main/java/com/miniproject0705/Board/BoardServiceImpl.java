package com.miniproject0705.Board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component // @Service, @Repository를 포함하는 개념
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    @Override
    public void save(BoardDomain boardDomain) {
        BoardEntity boardEntity = BoardDomain.DTOtoEntity(boardDomain);
        boardRepository.save(boardEntity);

    }
}
