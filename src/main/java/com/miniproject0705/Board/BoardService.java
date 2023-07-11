package com.miniproject0705.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    void save(BoardDomain boardDomain);

    List<BoardDomain> findAll();

    BoardDomain findById(Long id);

    BoardDomain update(BoardDomain boardDomain);

    void updateHits(Long pageNum);

    void delete(Long pageNum);

    Page<BoardDomain> paging(Pageable pageable);
}
