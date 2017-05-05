package com.practice.userController;

import com.practice.entity.User;
import com.practice.repository.UserRepository;
import com.practice.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 05-05-2017.
 */

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


@RequestMapping(value = "/home",method = RequestMethod.GET)
    void displayHome(Model model, HttpSession httpSession){
        User user = userService.getUserDetails(1);

    //model.addAttribute("user",user);
    /*model.addAttribute("userName",user.getUserName());
    model.addAttribute("userEmail",user.getEmailId());
    model.addAttribute("userEmpId",user.getEmployeeId());
    model.addAttribute("userDesig",user.getDesignation());*/
    httpSession.setAttribute("user",user);
    }

}
