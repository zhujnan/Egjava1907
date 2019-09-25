package com.eng.controller;

import com.eng.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

/**
 * Created by zhujn on 2019/9/.
 */
@SessionAttributes("user")
@Controller
@RequestMapping("/hello")
public class SessionController {
    /**
     * 在方法上定义，指的是SpringMVC
     * 在调用目标处理方法前，会琢个调用
     * 在方法级上标注了@ModelAttribute的方法
     * 然后把返回的对象存放在Model中。
     *
     * 如果同时在控制器类上使用
     * @SessionAttributes()，也保存在session中。
     * 属性名称可以使用  @ModelAttribute("user")，在
     * 标记方法的时候指定。如果没有指定，则使用返回类型的
     * 名称（首字母小写）作为属性名称。
     * @return
     */
    @ModelAttribute("user")
    public User getUser(){
        User u = new User();
        u.setLoginname("zs");
        u.setPassword("123");
        return u;
    }
    /**
     * @ModelAttribute如果放在方法参数前，
     * 可以从隐含对象中获取隐含的模型数据中获取对象，
     * 或者从session中取对应的属性值，
     * 可以通过@ModelAttribute("user")名称指定，
     * 若未指定，使用参数类型的名称（首字母小写）作为
     * 属性名称
     * 再将请求参数绑定到对象中，再传入入参
     * 将方法入参对象添加到模型中
     * @param user
     * @return
     */
    @RequestMapping("/handle")
    public String
    handle(@ModelAttribute("user") User user){
     user.setLoginname("zs2");
     return "redirect:/hello/handle2";
    }
    @RequestMapping("/handle2")
    public String handle2(Map<String,Object> map,
                          SessionStatus sessionStatus){
        User u = (User)map.get("user");
        u.setPassword("1232");
        return "success";
    }

}
