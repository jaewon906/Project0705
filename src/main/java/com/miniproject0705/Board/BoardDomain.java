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
    private Long pageNum;
    private String boardWriter;
    private String boardPassWord;
    private String boardTitle;
    private String boardContents;
    private int boardHits; //좋아요
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

    protected BoardDomain(Long pageNum, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.pageNum = pageNum;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public static BoardDomain entityToDTO(BoardEntity boardEntity) {
        BoardDomain boardDomain = new BoardDomain();

        boardDomain.setPageNum(boardEntity.getPageNum());
        boardDomain.setBoardWriter(boardEntity.getBoardWriter());
        boardDomain.setBoardTitle(boardEntity.getBoardTitle());
        boardDomain.setBoardContents(boardEntity.getBoardContents());
        boardDomain.setBoardPassWord(boardEntity.getBoardPassWord());
        boardDomain.setBoardHits(boardEntity.getBoardHits());
        boardDomain.setBoardCreatedTime(boardEntity.getBoardCreatedTime());
        boardDomain.setBoardUpdatedTime(boardEntity.getBoardUpdatedTime());

        return boardDomain;
    }
}
