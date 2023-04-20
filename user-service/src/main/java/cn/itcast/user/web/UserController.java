package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j  //输出日志
@RestController
@RequestMapping("user")
@RefreshScope  //配置自动刷新，在@Value注入的变量所在的类中增加@RefreshScope标注
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{userId}")
    public User queryUserById(@PathVariable("userId") Long id){
        User user=userService.queryUserById(id);
        return user;
    }

    @Value("${pattern.dateformat}")   //从配置文件中读取值的方法
    private String dateformat;

    @GetMapping("now")
    public String now(){
        System.err.println(dateformat);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat, Locale.CHINA));
    }

    @Value("${pattern.sharedDocument}")
    private String share;

    @GetMapping("prop")
    public String getSharedDocument(){
        return share;
    }
}
