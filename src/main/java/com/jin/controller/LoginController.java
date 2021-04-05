package com.jin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jin
 * @Description
 * @date 2021/4/5 15:27
 */

@Controller
public class LoginController {

    //当请求这个页面时，使用 ResponseBody返回ok
    // html index页面会请求这个页面


//    @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
//数据，需要注意的呢，在使用此注解之后不会再走试图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
//
//    @ResponseBody

//    提取出，index表单提交的相应信息, 还需要Model model
@RequestMapping("/user/login")
    public String login(
            //html 页面中 属性的name
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model){
        //具体的业务,
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //返回dashboard，如何返回到dashboard页面?为什么只返回String.. 因为加了ResponseBody 跳不到视图
            return "redirect:/main.html";
        }else{
            //返回此消息
            model.addAttribute("msg","wrong username or password");
            return "index";
        }

    }
}
