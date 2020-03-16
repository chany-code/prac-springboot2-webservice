package com.chany.book.springboot.web;

import com.chany.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    //전체 UI만들면서 추가된 부분
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){ //서버템플릿엔진에서 사용할 수 있는 객체를 저장할 수 있음. postsService.findAllDesc()로 가져온 결과를 posts로 index. mustache에 전달
        model.addAttribute("posts",postsService.findAllDesc());
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
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }      ***전체UI만들기 전에 사용했던 부분***
     */

}