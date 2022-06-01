package cn.nyist.test;

import cn.nyist.utils.MD5Util;
import org.junit.Test;

/**
 * Description:
 *
 * @author 张志鹏
 * @date 2022/4/16 16:47
 * @email p2hemia@nyist.edu.cn
 **/
public class MyTest {
    @Test
    public void testMD5() {
        String mi = MD5Util.getMD5("000000");
        System.out.println(mi);
    }
}
