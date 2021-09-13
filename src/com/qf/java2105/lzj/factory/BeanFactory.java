package com.qf.java2105.lzj.factory;

import com.alibaba.druid.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 工厂模式
 * @Author lzj
 * @Date 2021/9/13
 */
public class BeanFactory {
    /**
     *实例化子类 时properties在读的时候有序
     */
    private static final Properties PROPERTIES = new OrderedProperties();

    /**
     * 创建一个存放容器的实例
     */
    private static Map<String,Object> ioc = new HashMap<>();
    //创建静态代码块 使其在该类创建的时候加载一次
    static {
        try {
            PROPERTIES.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            //获取配置文件中所有的keys
            //foodDao=com.qf.java2105.ghy.dao.impl.FoodDaoImpl
            //foodDao
            Set<String> names = PROPERTIES.stringPropertyNames();
            for (String name : names) {
                //获取value
                //取 com.qf.java2105.ghy.dao.impl.FoodDaoImpl
                String className = PROPERTIES.getProperty(name);
                //判断是否为空
                if (!StringUtils.isEmpty(className)) {
                    //通过反射调用获取类对象
                    Class<?> clazz = Class.forName(className);
                    //通过该类对象调用构造器得到返回值
                    Object instance = clazz.newInstance();
                    //添加到map容器中
                    ioc.put(name,instance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName){
        return ioc.get(beanName);
    }
}
