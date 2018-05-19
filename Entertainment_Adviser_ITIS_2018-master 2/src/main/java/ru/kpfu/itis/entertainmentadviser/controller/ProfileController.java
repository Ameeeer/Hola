package ru.kpfu.itis.entertainmentadviser.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.entertainmentadviser.dao.UserDao;
import ru.kpfu.itis.entertainmentadviser.model.CurrentUser;
import ru.kpfu.itis.entertainmentadviser.model.User;

import java.util.List;

@Controller
public class ProfileController {
@Autowired
UserDao userDao;

    @GetMapping("/user/{id}")
    String showProfile(Model model, Authentication authentication){
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User user = currentUser.getUser();
        Long id = user.getId();
        List<User> user_profile = userDao.showProfile(id);
        model.addAttribute("user_profile",user_profile);
        return "profile";
    }

    @PostMapping("/create")
    String correctProfile(Authentication authentication,@RequestParam String username,String firstname,String secondname){
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User mainUser = currentUser.getUser();
        Long id =mainUser.getId();
      userDao.update( username, firstname,secondname,id);
     return "redirect:/user/" + mainUser.getId();
    }
}
