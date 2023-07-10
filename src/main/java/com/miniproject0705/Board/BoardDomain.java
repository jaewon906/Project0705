package com.miniproject0705.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter // getXXX 메서드 제공
@Setter // setXXX 메서드 제공
@NoArgsConstructor // 기본 생성자 제공
@AllArgsConstructor // 모든 핃드를 매개변수로 하는 생성자
public class BoardDomain {
    private Long id;
    private String boardWriter;
    private String boardPassWord;
    private String boardTitle;
    private String boardContents;
    private int boardHits; //좋아요
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

    public static BoardEntity DTOtoEntity(BoardDomain boardDomain) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDomain.getBoardWriter());
        boardEntity.setBoardContents(boardDomain.getBoardContents());
        boardEntity.setBoardTitle(boardDomain.getBoardTitle());
        boardEntity.setBoardPassWord(boardDomain.getBoardPassWord());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }
}
