package com.miniproject0705.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter // getXXX 메서드 제공
@Setter // setXXX 메서드 제공
@NoArgsConstructor // 기본 생성자 제공
public class BoardDomain {
    private Long id;

    private String boardWriter;
    private String boardPassWord;
    private String boardTitle;
    private String boardContents;
    private int boardHits; //좋아요

    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

    private MultipartFile boardFile; //파일은 MultipartFile 타입으로 받아야한다. Controller에서 파일 담는 용도
    // 파일이름을 구분 짓는 이유는 같은 이름의 다른 사진을 올릴 때 서버가 인지하지 못하기 때문.
    private String originalFileName; // 원본 파일이름
    private String storedFileName; // 저장된 파일이름
    private int fileAttached; // 파일 첨부 여부(첨부 1, 미첨부 0)

    protected BoardDomain(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public static BoardDomain entityToDTO(BoardEntity boardEntity) {
        BoardDomain boardDomain = new BoardDomain();

        boardDomain.setId(boardEntity.getId());
        boardDomain.setBoardWriter(boardEntity.getBoardWriter());
        boardDomain.setBoardTitle(boardEntity.getBoardTitle());
        boardDomain.setBoardContents(boardEntity.getBoardContents());
        boardDomain.setBoardPassWord(boardEntity.getBoardPassWord());
        boardDomain.setBoardHits(boardEntity.getBoardHits());
        boardDomain.setBoardCreatedTime(boardEntity.getBoardCreatedTime());
        boardDomain.setBoardUpdatedTime(boardEntity.getBoardUpdatedTime());
        if(boardEntity.getFileAttached()==0){
            boardDomain.setFileAttached(boardEntity.getFileAttached());
        }
        else boardDomain.setFileAttached(boardEntity.getFileAttached());
        //파일 이름을 가져와야함
        //originalFileName, storedFileName : boardFileTable에 있는데 boardTable만 호출함.
        //따라서 호출하기 위해 join 문법을 사용
        //select * from board_table b, board_file_table bf where b.id = bf.board_id and where b.id=값

        //boardEntity의 boardFileEntityList 리스트를 가져오는데 이 리스트는 DB에서부터 왔음. 지금은 첨부파일이 한 개이기 때문에 0번째 인덱스를 호출함.
        //0번째 인덱스 데이터 중에서 originalFileName을 받음
        boardDomain.setOriginalFileName(boardEntity.getBoardFileEntityList().get(0).getOriginalFileName());
        boardDomain.setStoredFileName(boardEntity.getBoardFileEntityList().get(0).getStoredFileName());


        return boardDomain;
    }
}
