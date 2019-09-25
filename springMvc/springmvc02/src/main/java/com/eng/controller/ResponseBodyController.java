package com.eng.controller;

import com.eng.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujn on 2019/9/23.
 */
@Controller
public class ResponseBodyController {

    /**
     * 返回单个值
     * 返回多个值 Map<String ,Object>
     *  返回List结果List<String>
     *  返回对象/集合 Object
     * @return
     */
    @RequestMapping("/repbody")
    @ResponseBody
    public boolean getJson() {
   /*     List<User> list =
                new ArrayList<User>();
        list.add(new User("zs", "123"));
        list.add(new User("ls", "456"));*/
        return true;
    }


}
