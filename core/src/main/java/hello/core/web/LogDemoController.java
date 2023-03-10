package hello.core.web;


import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
    //ObjectProvider를 통해서 getObject()메서드를 실행하긴전까지 request 빈 생성을 지연시킬수있다.
    @RequestMapping("log-demo")//log-demo라는 요청이 오면?
    @ResponseBody             //ResponseBody는  String을 그대로 응답으로 보낼수있다.
    public String logDemo(HttpServletRequest request){
        //getObject..
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }

}
