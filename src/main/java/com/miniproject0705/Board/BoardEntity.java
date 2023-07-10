package com.miniproject0705.Board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column // 길이 = 255(default), null 가능
    private String boardPassWord;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits;




}
