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

    @PostMapping("/api/v1/posts") //*Post_등록된다() **@PostMapping뒤에 ()인자값 누락으로 405error남*
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

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
