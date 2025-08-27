package org.example.scheduler.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // 해당 필드에 getter 메서드 자동 생성
@MappedSuperclass // 해당 클래스의 필드를 상속받는 엔티티에 매핑 정보로 제공
@EntityListeners(AuditingEntityListener.class) // 엔티티 생성과 수정 시점에 자동으로 날짜를 설정, 계속해서 감시
public abstract class BaseEntity {             // abstract: 틀만 있고 직접 객체 생성 불가능, 상속받는 클래스에서 가능

    // 작성일
    @CreatedDate // 저장 시점에 현재 시간 자동으로 설정
    @Column(updatable = false) // 한 번 저장된 후 수정되지 않도록 설정
    @Temporal(TemporalType.TIMESTAMP) // 날짜와 시간을 모두 저장
    private LocalDateTime createdAt;

    // 수정일
    @LastModifiedDate // 수정 시점에 현재 시간을 설정
    @Temporal(TemporalType.TIMESTAMP) // 날짜와 시간 모두 저장
    private LocalDateTime updatedAt;
}
