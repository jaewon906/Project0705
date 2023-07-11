package com.miniproject0705.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Modifying // update나 modify와 같은 작업을 할 때 붙혀준다.
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.pageNum=:pageNum")
    // boardEntity 기준으로 쿼리문을 작성. 네이티브 쿼리문을 작성하고 싶으면 @Query 속성에 nativeQuery=true
    void updateHits(@Param("pageNum") Long pageNum); // DB의 다수의 변수를 전달할 때 붙혀준다.

}
