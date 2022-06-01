package cn.nyist.service.impl;

import cn.nyist.mapper.ProductTypeMapper;
import cn.nyist.pojo.ProductType;
import cn.nyist.pojo.ProductTypeExample;
import cn.nyist.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/5/11 15:15
 * @email p2hemia@nyist.edu.cn
 **/
@Service("productTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    //在业务逻辑层一定会有数据访问层的对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {

        return productTypeMapper.selectByExample(new ProductTypeExample());

    }
}
