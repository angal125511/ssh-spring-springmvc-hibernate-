package com.zrzy.control;

import com.zrzy.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User2: ${和敬清寂}
 * Date: 2019/4/22
 * Time: 13:24
 */
//@Controller
//@RequestMapping
@RestController
//RestController等于Controller+ResponseBody
public class TestUserControl {

    @RequestMapping("/hello")
    public User hello(){

        User user = new User("username11","admin111");
        return user;
    }

}
