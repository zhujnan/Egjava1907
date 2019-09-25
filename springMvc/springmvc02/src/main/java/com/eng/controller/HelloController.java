package com.eng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * HelloController是一个基于注解的控制器，
 * 可以同时处理多个请求动作，并且无须实现任何接口。
 * Created by zhujn on 2019/9/20.
 */
@Controller
public class HelloController{
    /**
     *@RequestMapping该注解用来映射请求的URL和请求的方法等
     * 当前方法用于映射/hello
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 返回一个包含视图路径和视图模型的ModelAndView对象。
     * @throws Exception
     */
    @RequestMapping(value="/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",
                "hello,SpringMvc");
        mv.setViewName("hello");
        return mv;
    }
}
