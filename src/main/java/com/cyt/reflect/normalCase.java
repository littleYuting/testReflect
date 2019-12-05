package com.cyt.reflect;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 需求：写一个“框架”，在不改变任何代码的前提下，可以创建任意类的对象，并且执行其中任意方法
 * 实现： 1）配置文件；  2）反射；
 * 步骤：
 *      1）将需要创建的对象的全类名和需要执行的方法定义在配置文件中；
 *      2）在程序中加载读取配置文件；
 *      3）使用反射技术来加载类文件进内存；
 *      4）创建对象；
 *      5）执行方法；
 */
public class normalCase {

    public static void main(String[] args) throws Exception {
        // 1. 加载配置文件
        // 1.1 创建 Properties 对象
        Properties properties = new Properties();
        // 1.2 加载配置文件，转换为 一个 集合
        // 1.2.1 获取 class 目录下的配置文件
        ClassLoader load = normalCase.class.getClassLoader();
        InputStream in = load.getResourceAsStream("pro.properties");
        // 在寻找某个文件的时候，一般要找到该类的类加载器，然后使用此类加载器在类路径下搜索要查找的文件
        properties.load(in);
        // 2. 获取配置文件中的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        // 3. 加载该类进内存
        Class cls = Class.forName(className);
        // 4. 创建对象
        Object obj = cls.newInstance();
        // 5. 获取方法对象
        Method method = cls.getMethod(methodName);
        // 6. 方法执行
        method.invoke(obj);
    }

}
