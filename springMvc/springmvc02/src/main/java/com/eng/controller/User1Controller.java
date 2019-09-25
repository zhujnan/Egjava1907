package com.eng.controller;

import com.eng.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhujn on 2019/9/20.
 */
@Controller
public class User1Controller {
    /**
     * 该注解修饰的方法会优于login调用，
     *用于接收前台jsp页面传入的参数。
     * @param loginname
     * @param password
     * @param model
     */
    @ModelAttribute
    public void userModel(String loginname,String password,
                          Model model){
        User u = new User();
        u.setLoginname(loginname);
        u.setPassword(password);
        model.addAttribute("user",u);
    }
    @RequestMapping(value = "/login1")
    public String login(Model model){
     User u = (User)model.asMap().get("user");
     System.out.println(u.getLoginname()+","+u.getPassword());
        return "result1";
    }

}
