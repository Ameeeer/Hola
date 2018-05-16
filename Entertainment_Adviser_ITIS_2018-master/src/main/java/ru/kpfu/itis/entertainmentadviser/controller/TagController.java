package ru.kpfu.itis.entertainmentadviser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.entertainmentadviser.dao.EventDao;
import ru.kpfu.itis.entertainmentadviser.dao.EventDaoimpl;
import ru.kpfu.itis.entertainmentadviser.model.CurrentUser;
import ru.kpfu.itis.entertainmentadviser.model.Event;
import ru.kpfu.itis.entertainmentadviser.model.User;
import ru.kpfu.itis.entertainmentadviser.model.UserTag;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TagController {
//    @Autowired
//    TagDao tagDao;

    @GetMapping("/tags")
    String getUserTags(Model model, Authentication authentication) {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        User user = currentUser.getUser();
//        List<UserTag> userTagList = tagDao.getUserTags(user);

        UserTag userTag1 = new UserTag(1L, "кино", true);
        UserTag userTag2 = new UserTag(2L, "театр", false);
        List<UserTag> userTagList = new ArrayList<>();
        userTagList.add(userTag1);
        userTagList.add(userTag2);
        model.addAttribute("userTagList", userTagList);
        return "userTags";
    }
}
