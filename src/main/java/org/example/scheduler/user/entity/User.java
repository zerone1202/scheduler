package org.example.scheduler.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.scheduler.common.entity.BaseEntity;

@Getter // 모든 필드에 getter 메서드 자동 생성
@Entity // 해당 클래스가 DB 테이블과 매핑되는 엔티티
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*
@NoArgsConstructor는 파라미터가 없는 기본 생성자 자동 생성,
(access = AccessLevel.PROTECTED)는 외부에서 직접적으로 엔티티를 생성하는 것을 제한하는 용도
 */
@Table(name = "users") // 엔티티가 매핑될 테이블 이름을 설정
public class User extends BaseEntity {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  @GeneratedValue은 자동으로 값이 생성되도록 설정, (strategy = GenerationType.IDENTITY)은 DB에서 자동으로 증가
    private Long id;
    @Column(length = 10, nullable = false) //length = 10 최대 10자까지 저장 가능, nullable = false: null 값 저장 불가
    private String username;
    @Column(length = 30, nullable = false) //length = 30 최대 30자까지 저장 가능, nullable = false: null 값 저장 불가
    private String email;
    @Column(length = 255, nullable = false) //length = 255 최대 255자까지 저장 가능, nullable = false: null 값 저장 불가
    private String password;

    // 생성자
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
