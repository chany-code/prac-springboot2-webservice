package com.chany.book.springboot.service.posts;
import com.chany.book.springboot.domain.posts.Posts;
import com.chany.book.springboot.domain.posts.PostsRepository;
import com.chany.book.springboot.web.dto.PostsListResponseDto;
import com.chany.book.springboot.web.dto.PostsResponseDto;
import com.chany.book.springboot.web.dto.PostsSaveRequestDto;
import com.chany.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.List;

@RequiredArgsConstructor//final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성. @Autowired 대신함
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)//*readOnly=true : 트랜잭션의 범위는 유지, 조회기능만 남겨 조회속도 개선
    public List<PostsListResponseDto> findAllDesc(){//하단에 람다식 사용, 실제코드:.map(posts->new PostsListResponseDto(posts))
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);//JpaRepository에 이미 delete 메소드를 지원/ 엔티티를 파라미터로 삭제하거나 deleteById면 id로 삭제가능
    }
}
