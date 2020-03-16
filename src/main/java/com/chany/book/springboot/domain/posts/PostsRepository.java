package com.chany.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long>{
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    //SpringDataJpa에서 제공하지 않는 메소드는 @Query를 이용하려 쿼리로 작성
    //조회용 프레임워크로는 querydsl추천함
}
