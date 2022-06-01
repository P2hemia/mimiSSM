package cn.nyist.controller;

import cn.nyist.pojo.ProductInfo;
import cn.nyist.service.ProductInfoService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/17 13:23
 * @email p2hemia@nyist.edu.cn
 **/
@Controller
@RequestMapping("/prod")
public class ProductInfoAction {

    //每一页显示的记录数
    public static final int PAGE_SIZE = 5;

    @Autowired
    ProductInfoService productInfoService;

    //显示全部商品不分页
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<ProductInfo> list = productInfoService.getAll();
        model.addAttribute("list", list);
        return "product";
    }

    //显示第1页的5条记录
    @RequestMapping("/split")
    public String split(Model model){

        //得到第1页的数据
        PageInfo info = productInfoService.splitPage(1,PAGE_SIZE);
        model.addAttribute("info",info);
        return "product";

    }


    //Ajax分页翻页处理
    @ResponseBody
    @RequestMapping("/ajaxsplit")
    public void ajaxsplit(int page, HttpSession session) {
    //    取得当前page参数页面的数据
        PageInfo info = productInfoService.splitPage(page, PAGE_SIZE);
        session.setAttribute("info",info);
    }
}
