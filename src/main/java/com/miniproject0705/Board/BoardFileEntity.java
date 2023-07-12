package com.miniproject0705.Board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// 여기 엔티티에서는 파일의 이름, 저장될 파일의 이름, 그리고 부모 테이블인 boardTable에서부터 id를 참조 받아서
// 사용합니다.
@Entity
@Getter
@Setter
@Table(name = "boardFileTable")
public class BoardFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;
    //게시글과 파일의 관계는 1:n의 관계이다. boardFile기준으로는 n:1관계이므로 @ManyToOne 어노테이션을 붙혀준다.
    //fetch 타입은 보통 아래와 같이 사용. 부모 엔티티를 조회했을 때 자식 엔티티를 같이 조회할 수 있다. 패치타입을 EAGER로 설정하면 부모를 가져오면 자식도 자동으로 딸려오기 때문에
    //궅이 사용하지 않을거를 가져온다 해서 보통 LAZY를 많이 씁니다. LAZY는 내가 자식 엔티티를 사용하고 싶을 때만 불러올 수 있습니다.
    //@JoinColumn은 정의한 컬럼명을 토대로 컬럼을 정의합니다. 단순히 이름만 정의하는데 어떻게 매핑이 되냐면 referencedColumnName 속성 때문입니다.
    //해당 속성을 생략하면 자동적으로 대상 테이블의 PK값을 참조합니다.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private BoardEntity boardEntity; //반드시 부모 엔티티를 입력해서 관계를 맺어줘야함.

    public static BoardFileEntity toBoardFileEntity(BoardEntity boardEntity, String originalFileName, String storedFileName) {
        BoardFileEntity boardFileEntity = new BoardFileEntity();

        boardFileEntity.setOriginalFileName(originalFileName);
        boardFileEntity.setStoredFileName(storedFileName);
        boardFileEntity.setBoardEntity(boardEntity);
        return boardFileEntity;
    }
}
