package com.chany.book.springboot.web;
import com.chany.book.springboot.service.posts.PostsService;
import com.chany.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor//final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성. @Autowired 대신함
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping //("/api/vi/posts") PutMapping일땐 ()붙이고 PostMapping일땐 때고
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

}
