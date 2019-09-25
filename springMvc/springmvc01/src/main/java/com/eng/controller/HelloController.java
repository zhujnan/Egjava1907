package com.eng.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Created by zhujn on 2019/9/20.
 */
public class HelloController implements Controller{
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return 返回一个包含视图路径和视图模型的ModelAndView对象。
     * @throws Exception
     */
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest,
                                      javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",
                "hello,SpringMvc");
        mv.setViewName("hello");
        return mv;
    }
}
