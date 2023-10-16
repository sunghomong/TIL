package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello"; // hello.html로 이동해서 실행 시켜라
        // 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버 ('viewResolver')가 화면을 찾아서 처리한다.
        // 스프링 부트 템플릿엔진 기본 viewName 매핑
        // resources:templates/ViewName.html
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name",name);

        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http 바디부에 내용을 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name) {
        return  "hello " + name; // "hello name"
    }


    @GetMapping("hello-api")
    @ResponseBody // viewResolver 대신에 HttpMessageConverter가 동작
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 제이슨으로 변환해서 반환
    }

    static class Hello {
        private  String name;
        // 단축키 alt + insert -> gettter and setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
