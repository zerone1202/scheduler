package org.example.scheduler.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.scheduler.common.entity.BaseEntity;

@Getter // 모든 필드에 getter 메서드 자동 생성
@Entity // 해당 클래스가 데이터베이스 테이블과 매핑되는 엔티티
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*
@NoArgsConstructor는 파라미터가 없는 기본 생성자 자동 생성,
(access = AccessLevel.PROTECTED)는 외부에서 직접적으로 엔티티를 생성하는 것을 제한하는 용도
 */
@Table(name = "schedules") // 엔티티가 매핑될 테이블 이름을 설정
public class Schedule extends BaseEntity {
    @Id // 해당 필드가 테이블의 기본 키임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  @GeneratedValue은 자동으로 값이 생성되도록 설정, (strategy = GenerationType.IDENTITY)은 DB에서 자동으로 증가
    private Long id;
    /*
     댓글 작성자의 ID
     아직 User 객체와의 연관관계 설정 전, 추후 @ManyToOne으로 변경 예정
     */
    @Column(nullable = false)
    private Long userId;
    @Column(length = 50, nullable = false) //length = 50 최대 50자까지 저장 가능, nullable = false: null 값 저장 불가
    private String title;
    @Column(length = 255, nullable = false) //length = 255 최대 255자까지 저장 가능, nullable = false: null 값 저장 불가
    private String content;

    // 생성자 (객체를 만들 때 title과 content를 초기화할 수 있도록 도와줌)
    public Schedule(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
