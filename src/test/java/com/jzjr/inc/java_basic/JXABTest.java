package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.User;
import com.sun.xml.internal.bind.api.JAXBRIContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 文档参考：https://www.w3cschool.cn/jaxb2
 */
@SpringBootTest
public class JXABTest {

    public static void JavaToXml(User user) throws JAXBException {
        //获取JXAB上下文环境
        JAXBContext jaxbContext = JAXBRIContext.newInstance(User.class);
        //创建Marshaller实例
        Marshaller marshaller = jaxbContext.createMarshaller();
        //设置转换参数,设置序列化器是否格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //构造输出环境，这里是标准输出，输出到控制台
        PrintStream out = System.out;
        marshaller.marshal(user, out);
    }

    public static void XmlToJava() throws JAXBException {
        // 获取JAXB的上下文环境，需要传入具体的 Java bean -> 这里使用Student
        JAXBContext context = JAXBContext.newInstance(User.class);
        // 创建 UnMarshaller 实例
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // 加载需要转换的XML数据 -> 这里使用InputStream，还可以使用File，Reader等
        InputStream stream = User.class.getClassLoader().getResourceAsStream("User.xml");
        // 将XML数据序列化 -> 该方法的返回值为Object基类，需要强转类型
        User user = (User) unmarshaller.unmarshal(stream);
        // 将结果打印到控制台
        System.out.println(user);
    }

    /**
     * JAXB 转换对象必须属于JAXBElement类型，或者使用 @XmlRootElement注解
     * JAXB 转换对象必须拥有无参数构造器
     * 可以有多种方式加载XML数据，从文件中加载只是其中的一种
     * getResourceAsStream("file.xml")方法需要将该XML文件放置于/resources目录下
     *
     * @param args
     * @throws JAXBException
     */
    public static void main(String[] args) throws JAXBException {
        User daisy = new User("Daisy", 24);
        JavaToXml(daisy);
        XmlToJava();
    }
}
