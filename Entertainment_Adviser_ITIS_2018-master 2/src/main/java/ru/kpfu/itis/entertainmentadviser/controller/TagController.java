package ru.kpfu.itis.entertainmentadviser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.entertainmentadviser.model.CurrentUser;
import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;
import ru.kpfu.itis.entertainmentadviser.service.UserTagService;

import java.util.List;

@Controller
public class TagController {
    @Autowired
    UserTagService userTagService;

    @GetMapping("/tags")
    String getUserTags(Model model, Authentication authentication) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User user = currentUser.getUser();
        List<UserTag> userTagList = userTagService.getAllUserTags(user);
        model.addAttribute("userTagList", userTagList);
        return "userTags";
    }

    @PostMapping("/tags")
    String saveUserTags(Model model, Authentication authentication, @RequestParam(name = "userTag") List<Long> userTagIds) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User user = currentUser.getUser();
        List<UserTag> oldUserTagList = userTagService.getAllUserTags(user);
        for (UserTag userTag : oldUserTagList) {
            if (userTagIds.contains(userTag.getId())) {
                //пользователь выбрал, но до этого выбран не был
                if (!userTag.getChosen()) {
                    userTagService.addTagToUser(user, userTag);
                }
            } else {
                //пользователь не выбрал, но до этого был выбран
                if (userTag.getChosen()) {
                    userTagService.deleteTagForUser(user, userTag);
                }
            }
        }
        return "redirect:/tags";
    }
}
