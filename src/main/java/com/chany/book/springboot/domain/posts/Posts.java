package com.chany.book.springboot.domain.posts;

import com.chany.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor //기본생성자 자동추가 public Posts() {}
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id//해당 테이블의 Primary Key필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK의 생성규칙. GT.IDT -> auto_increment위하여
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;//@Column 선언 않더라도 Posts 클래스의 필드는 모두 칼럼이 됨. 변경필요할때 @Column 사용

    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
