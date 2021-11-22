package com.jzjr.inc.java_basic;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@SpringBootTest
public class MailTest {

    @Test
    public void sendMail() {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        //用户名，默认为发件人邮箱前缀，还可以填发件人邮箱，其他情况不支持会导致邮件发送失败
        account.setFrom("756974950@qq.com");
        account.setUser("756974950@qq.com");
        account.setPass("nptpjiwciirvbcbf");
        account.setCharset(StandardCharsets.UTF_8);
        MailUtil.send(account,"tt22555550@163.com", "Hello2021", "今年的小目标实现了吗", false);
    }
}
