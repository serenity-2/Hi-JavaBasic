package com.jzjr.inc.java_basic;

import com.jzjr.inc.java_basic.bean.User;
import com.sun.xml.internal.bind.api.JAXBRIContext;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.PrintStream;

@SpringBootTest
public class JXABTest {

    public static void JavaToXml(User user) throws JAXBException {
        //获取JXAB上下文环境
        JAXBContext jaxbContext = JAXBRIContext.newInstance(User.class);
        //创建Marshaller实例
        Marshaller marshaller = jaxbContext.createMarshaller();
        //设置转换参数,设置序列化器是否格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        //构造输出环境，这里是标准输出，输出到控制台
        PrintStream out = System.out;
        marshaller.marshal(user,out);
    }

    public static void main(String[] args) throws JAXBException {
        User daisy = new User("Daisy", 24);
        JavaToXml(daisy);
    }
}
