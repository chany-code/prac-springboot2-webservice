package com.chany.book.springboot.web;

import com.chany.book.springboot.config.auth.LoginUser;
import com.chany.book.springboot.config.auth.dto.SessionUser;
import com.chany.book.springboot.service.posts.PostsService;
import com.chany.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {
    //전체 UI만들면서 추가된 부분
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ //서버템플릿엔진에서 사용할 수 있는 객체를 저장할 수 있음. postsService.findAllDesc()로 가져온 결과를 posts로 index. mustache에 전달
        model.addAttribute("posts",postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user"); ***@LoginUser로 개선함으로서 사라진 부분
        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    /*
    @GetMapping("/")
    public String index(){
        return "index";
        //머스테치 스타터 덕분에 컨트롤러에서 문자열 반환 시 앞의 경로, 뒤 파일 확장자는 자동으로 지정
        //앞의 경로 : src/main/resources/templates, 뒤 파일확장자 : .mustache
        //src/main/resources/templates/index.mustache로 전환되어 View Resolver가 처리함
        // *View Resolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격
    }  ***전체UI만들기 전에 사용했던 부분***
    */

    @GetMapping("/posts/save")//이건살아있어야지
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
