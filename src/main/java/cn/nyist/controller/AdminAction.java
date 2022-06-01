package cn.nyist.controller;

import cn.nyist.pojo.Admin;
import cn.nyist.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/16 17:12
 * @email p2hemia@nyist.edu.cn
 **/
@Controller
@RequestMapping("/admin")
public class AdminAction {
    //controller调service调dao
    //切记:在所有的界面层,一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    //实现登陆判断,并进行相应的跳转
    //此处是使用HttpServletRequest传参
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        String msg = adminService.login(name, pwd);
        if (msg != "no") {
            //登录成功
            request.setAttribute("name", name);
            return "main";
        } else {
            //登陆失败
            request.setAttribute("errmsg", "用户名或密码不正确");
            return "login";
        }
    }

    //实现登陆判断,并进行相应的跳转
    //此处是使用Model进行传参
    //@RequestMapping("/login")
    //public String login(String name, String pwd, Model model){
    //    //此处传递参数,可以使用HttpServletRequest也可以使用model
    //    Admin admin = adminService.login(name,pwd);
    //    if (admin != null) {
    //        //登录成功
    //        model.addAttribute("admin", admin);
    //        return "main";
    //    } else {
    //        //登陆失败
    //        model.addAttribute("errmsg", "用户名或密码不正确");
    //        return "login";
    //    }
    //}


}
