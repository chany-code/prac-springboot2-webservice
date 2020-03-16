package com.chany.book.springboot.web;
import com.chany.book.springboot.service.posts.PostsService;
import com.chany.book.springboot.web.dto.PostsResponseDto;
import com.chany.book.springboot.web.dto.PostsSaveRequestDto;
import com.chany.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor//final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성. @Autowired 대신함
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping //("/api/vi/posts") PutMapping일땐 ()붙이고 PostMapping일땐 때고 *Post_등록된다()
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}") //*Post_수정된다()
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
