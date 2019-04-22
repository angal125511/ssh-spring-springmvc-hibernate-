package com.zrzy.control;

import com.zrzy.entity.User;
import com.zrzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/22
 * Time: 17:22
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public String add(User user){
        if(user.getId()==null){
            userService.add(user);
        }
        userService.update(user);
        return "redirect:/user/findAll";
    }
    @RequestMapping("toadd")
    public String queryOne(){
        return "forward:/WEB-INF/view/add.jsp";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
    List<User> list=userService.findAll();

    model.addAttribute("list",list);
        return "query";
    }

    @RequestMapping("findById/{id}")
    public ModelAndView findById(@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/add");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Integer id){
        User user= userService.findById(id);
        userService.delete(user);
        return "redirect:/user/findAll";
    }

    @RequestMapping("/findOne/{id}")
    public User findOne(@PathVariable(name = "id")Integer id){

        return userService.findOne(id);
    }

}
