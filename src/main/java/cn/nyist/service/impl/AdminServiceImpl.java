package cn.nyist.service.impl;

import cn.nyist.mapper.AdminMapper;
import cn.nyist.pojo.Admin;
import cn.nyist.pojo.AdminExample;
import cn.nyist.service.AdminService;
import cn.nyist.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/16 16:54
 * @email p2hemia@nyist.edu.cn
 **/
@Service
public class AdminServiceImpl implements AdminService {

    //在业务逻辑层，一定会有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;



    @Override
    public String login(String name, String pwd) {
        //根据传入的用户或到DB中查询相应用户对象
        //如果有条件,则一定要创建AdminExample的对象,用来封装条件
        AdminExample example = new AdminExample();
        /**如何添加条件
         * select * from admin where a_name = 'admin'
         */
        //条件用户名a_name条件
        example.createCriteria().andANameEqualTo(name);
        String msg = "no";
        List<Admin> list = adminMapper.selectByExample(example);
        if(list.size() > 0) {
            Admin admin = list.get(0);
            //如果查到用户对象,再进行密码的比对,注意密码是密文
            /**
            * 分析:
            * admin.getApass==>c984aed014aec7623a54f0591da07a85fd4b762d
            * pwd===>000000
            * 在进行密码比对时,要将传入的pwd进行md5加密,再与数据库中查到的对象的密码进行比对
            **/
            String miPwd = MD5Util.getMD5(pwd);
            if (miPwd.equals(admin.getaPass())){
                msg = "ok";
            }
            //if(pwd.equals(admin.getaPass())) {
            //    //return admin;
            //    msg = "ok";
            //}
        }
        //return null;
        return msg;
    }
}
