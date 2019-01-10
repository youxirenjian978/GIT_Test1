package com.wwk.git.controller;

import com.google.gson.Gson;
import com.wwk.git.entity.User;
import com.wwk.git.entity.Users;
import com.wwk.git.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private IUserService uService;

    @RequestMapping("userMana")
    public String toOrgMana(){
        return "user/userMana";
    }

    @RequestMapping("queryUserPage")
    public ModelAndView queryUserPage(HttpServletRequest request){
        Map<String, Object> param = this.getParam(request);
        int startIndex = Integer.parseInt(param.get("startIndex").toString());//9
        int pageSize = Integer.parseInt(param.get("pageSize").toString());//3
        param.put("startIndex",startIndex);
        param.put("pageSize",pageSize);
        List<User> userList = uService.queryUserPage(param);
        int total = uService.getCount(param);
        ModelAndView modelAndView = new ModelAndView("user/userList");
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("total",total);
        return modelAndView;
    }


    @RequestMapping("getPageNumber")
    public ModelAndView getPageNumber(HttpServletRequest request){
        Map<String, Object> param = this.getParam(request);

        int total = Integer.parseInt(param.get("total").toString());//17
        int startIndex = Integer.parseInt(param.get("startIndex").toString());//9
        int pageSize = Integer.parseInt(param.get("pageSize").toString());//3
        ModelAndView result = new ModelAndView("user/userPageNumber");
        return this.getPageNumberInfo(total,startIndex,pageSize,result);
    }
    @RequestMapping("add")
    public void add(User user, HttpServletResponse response){
        int result = uService.add(user);
        this.flushResponse(response,String.valueOf(result));
    }
    @RequestMapping("update")
    public void update(User user, HttpServletResponse response){
        System.out.println(user+",user");
        int result = uService.update(user);
        this.flushResponse(response,String.valueOf(result));
    }
    @RequestMapping("delete")
    public void delete(long userId, HttpServletResponse response){
        int result = uService.delete(userId);
        this.flushResponse(response,String.valueOf(result));
    }

    @RequestMapping("getById")
    public void getById(long userId, HttpServletResponse response){
        Users users = uService.getById(userId);
        String s = new Gson().toJson(users);
        this.flushResponse(response,s);
    }

    /**
     * 获取各个省的男女人数
     * @param response
     */
    @RequestMapping("getSexNum")
    public void getSexNum(HttpServletResponse response){
        List<Map<String,Object>> list = uService.getSexNum();
        String s = new Gson().toJson(list);
        this.flushResponse(response,s);
    }
    /**
     * 获取各个省的人数
     * @param response
     */
    @RequestMapping("getNum")
    public void getNum(HttpServletResponse response){
        List<Map<String,Object>> list = uService.getNum();
        String s = new Gson().toJson(list);
        this.flushResponse(response,s);
    }

    public void get(){
        System.out.println("the new people I want to use it,w j s,j s,j s,j s!");
        System.out.println("测试的东西！");
        System.out.println("i am wwk1,i wangt to remove some one");
    }
}
