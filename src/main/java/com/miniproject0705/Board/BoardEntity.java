package com.miniproject0705.Board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "boardTable")
public class BoardEntity extends TimeBaseEntity { //DB 역할을 하는 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false) //길이 20, not null
    private String boardWriter;

    @Column(length = 20, nullable = false) // 길이 = 255(default), null 가능
    private String boardPassWord;

    @Column(nullable = false)
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;

    @Column
    private int fileAttached;

    //두 엔티티간 매핑을 할 때 반드시 양방향 매핑을 해줘야 합니다.
    //여기에서는 boardTable(one) : boardFileTable(many) 관계이므로 boardTable은 @OneToMany, boardFileTable은 @ManyToOne
    //@OnetoMamy = 현재 부모 엔티티(boardTable)와 자식 엔티티(boardFileTable)와 1대다 관계이기 때문에 1에 해당하는 부모엔티티에 적용
    //mappedBy = 어떤 엔티티랑 메핑할 것이냐. 자식 엔티티에 선언된 부모 엔티티가 있을 텐데 그 객체명을 적어줍니다.
    //cascade = CascadeType.REMOVE -> 부모 테이블이 삭제될 때 참조하고 있는 자식 테이블을 자동으로 같이 삭제해줍니다.
    //cascade = CascadeType.PERSIST -> 부모 테이블이 자식 테이블의 전체 생명주기를 관리합니다. (All = REMOVE + PERSIST)
    //orphanRemoval = true -> 부모 엔티티를 삭제할 땐 CasCadeType.REMOVE와 동일하다 (부모 삭제시 자식도 삭제)
    //cascadeType.REMOVE vs orphanRemoval = true
    //부모 엔티티 삭제 시 둘 다 자식도 지운다. 하지만 부모 엔티티에서부터 자식 엔티티를 삭제할 때 전자는 자식 엔티티를 남기지만, 후자는 자식 엔티티를 지워준다.
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    List<BoardFileEntity> boardFileEntityList = new ArrayList<>(); // 한 개의 게시글에 여러개의 파일이 올 수 있기 때문.


    public static BoardEntity DTOtoEntity(BoardDomain boardDomain) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setId(boardDomain.getId());
        boardEntity.setBoardWriter(boardDomain.getBoardWriter());
        boardEntity.setBoardContents(boardDomain.getBoardContents());
        boardEntity.setBoardTitle(boardDomain.getBoardTitle());
        boardEntity.setBoardPassWord(boardDomain.getBoardPassWord());
        boardEntity.setBoardHits(boardDomain.getBoardHits());
        boardEntity.setFileAttached(0);

        return boardEntity;
    }


    public static BoardEntity toSaveFileEntity(BoardDomain boardDomain) {
        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setId(boardDomain.getId());
        boardEntity.setBoardWriter(boardDomain.getBoardWriter());
        boardEntity.setBoardContents(boardDomain.getBoardContents());
        boardEntity.setBoardTitle(boardDomain.getBoardTitle());
        boardEntity.setBoardPassWord(boardDomain.getBoardPassWord());
        boardEntity.setBoardHits(boardDomain.getBoardHits());
        boardEntity.setFileAttached(1);

        return boardEntity;
    }
}
