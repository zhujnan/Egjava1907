package com.eng.controller;

import com.eng.dao.daoimpl.UserDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.eng.entity.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhujn on 2019/9/23.
 */
@Controller
public class UserController {
    @Resource
    private UserDaoImpl userDao;
    @RequestMapping("list")
    public String userList(HttpServletRequest req){
        ArrayList<User> list
                = userDao.findAll();
        System.out.println(list.toString());
        req.setAttribute("userList",list);
        return "userList";
    }
    @RequestMapping(value = "del/{id}",method = RequestMethod.DELETE)
    public String userDelete(@PathVariable("id") Integer id){
        System.out.println("删除"+id);
        boolean bool = userDao.deleteById(id);
        if(bool){
            return "redirect:/list";
        }
        /**
         * 删除成功，要重定向到查询所有页面
         *
         * 删除失败，还在当前页面
         *   "redirect:/list/id"
         */
    return  "redirect:/del/id";
    }

    /**
     * 跳转到新增页面
     * @param
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(Map<String,Object> map){
        map.put("u", new User());
        System.out.println("跳转新增页面method = RequestMethod.GET");
        return "add";
    }
    //执行新增操作
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(User u,HttpServletRequest req){
        System.out.println("post请求的添加");
        System.out.println(u.getLoginname()+u.getPassword());
        userDao.save(u);
        return "redirect:/list";
    }
    /**
     * 跳转到修改页面
     * @param
     * @return
     */
    @RequestMapping(value = "add/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id,
                         Map<String,Object> map){
        /**
         * 根据ID查询得到一个对象，
         * 然后将对象绑定到map中
         */
        User u = (User)userDao.findById(id);
        System.out.println(u.toString());
        map.put("u",u );
        return  "add";
    }
    /**
     * 执行修改方法
     */
    @RequestMapping(value = "add",method = RequestMethod.PUT)
    public String toDoUpdate(User u){
        /**
         *
         */
        System.out.println(u.toString());
        System.out.println("1111111");
        userDao.update(u);
        return  "redirect:/list";
    }
    /*@ModelAttribute
    public void getUser(
            @RequestParam(value="id",required=false)
                    Integer id,
            Map<String,Object> map){
        if(id!=null){
            final Object user = map.put("user",
                    userDao.findById(id));
        }
    }*/

}
