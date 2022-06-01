package cn.nyist.service.impl;

import cn.nyist.mapper.ProductInfoMapper;
import cn.nyist.pojo.ProductInfo;
import cn.nyist.pojo.ProductInfoExample;
import cn.nyist.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/17 13:20
 * @email p2hemia@nyist.edu.cn
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    //切记：业务逻辑层中一定有数据访问层的对象
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    //SELECT * FROM product_info LIMIT 起始记录数=（（当前页-1）*每一页的条数），每页取几条
    //SELECT * FROM product_info LIMIT 10,5
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum, pageSize);

        //进行PageInfo的数据封装
        //进行有条件的查询操作,必须要创建ProductInfoExample对象
        ProductInfoExample example = new ProductInfoExample();
        //设置排序,按照主键降序排序,
        //SELECT * FROM product_info ORDER BY p_id DESC
        example.setOrderByClause("p_id desc");
        //设置完排序后,取集合,切记切记,一定要取集合,设置PageHelper.startPage(pageNum, pageSize)
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查到的集合封装到PageInfo对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }
}
