package cn.nyist.service;

import cn.nyist.pojo.ProductInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/17 13:19
 * @email p2hemia@nyist.edu.cn
 **/
public interface ProductInfoService {

    // 显示全部商品，不分页
    List<ProductInfo> getAll();

    //分页功能实现
    PageInfo splitPage(int pageNum, int pageSize);
}
