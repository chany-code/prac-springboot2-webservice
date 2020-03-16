package com.chany.book.springboot.service.posts;
import com.chany.book.springboot.domain.posts.Posts;
import com.chany.book.springboot.domain.posts.PostsRepository;
import com.chany.book.springboot.web.dto.PostsResponseDto;
import com.chany.book.springboot.web.dto.PostsSaveRequestDto;
import com.chany.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
