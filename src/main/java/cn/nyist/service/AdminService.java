package cn.nyist.service;

import cn.nyist.pojo.Admin;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/16 16:52
 * @email p2hemia@nyist.edu.cn
 **/
public interface AdminService {
    //完成登录判断
    String login(String name, String pwd);
}
