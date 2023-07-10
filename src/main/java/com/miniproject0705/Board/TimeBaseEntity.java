package com.miniproject0705.Board;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 부모 클래스로 사용할 때 붙힘
                  // 하위 클래스에서 매핑 정보를 상속 받는다.
@EntityListeners(AuditingEntityListener.class) // JPA가 엔티티의 변경 이벤트를 감지하고, 감사 정보(생성일, 수정일 등)를 자동으로 관리할 수 있게 됩니다.
@Getter
public class TimeBaseEntity {  // 나중에 시간에 관련된 작업이 굉장히 많기 때문에 따로 분리해서 사용하는것이 좋다.
    @CreationTimestamp // 해당 데이터를 테이블에 적용했을 때 시간을 자동으로 생성해준다
    @Column(updatable = false) // 게시판 생성시에만 시간을 생성
    private LocalDateTime boardCreatedTime;

    @CreationTimestamp
    @Column(insertable = false) // 게시판 업데이트 시에만 데이터 수정
    private LocalDateTime boardUpdatedTime;
}
