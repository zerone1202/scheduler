package org.example.scheduler.comment.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.scheduler.common.entity.BaseEntity;

@Getter // 모든 필드에 getter 메서드 자동 생성
@Entity // 해당 클래스가 데이터베이스 테이블과 매핑되는 엔티티
/*
@NoArgsConstructor는 파라미터가 없는 기본 생성자 자동 생성,
(access = AccessLevel.PROTECTED)는 외부에서 직접적으로 엔티티를 생성하는 것을 제한하는 용도
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Table(name = "comments") // 엔티티가 매핑될 테이블 이름을 설정
public class Comment extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  @GeneratedValue은 자동으로 값이 생성되도록 설정, (strategy = GenerationType.IDENTITY)은 DB에서 자동으로 증가
    private Long id;

    /*
     댓글이 달린 일정의 ID,
     아직 Schedule 객체와의 연관관계 설정 전, 추후 @ManyToOne으로 변경 예정
     */
    @Column(nullable = false)
    private Long scheduleId;
    /*
     댓글 작성자의 ID,
     아직 User 객체와의 연관관계 설정 전, 추후 @ManyToOne으로 변경 예정
     */
    @Column(nullable = false)
    private Long userId;
    @Column(length = 100, nullable = false) //length = 100 최대 100자까지 저장 가능, nullable = false: null 값 저장 불가
    private String comment;

    // 생성자
    public Comment(String comment) {
        this.comment = comment;
    }
}
