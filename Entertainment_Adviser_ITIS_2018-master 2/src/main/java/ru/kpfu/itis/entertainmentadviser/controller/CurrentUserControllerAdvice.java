package ru.kpfu.itis.entertainmentadviser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kpfu.itis.entertainmentadviser.model.CurrentUser;

@ControllerAdvice
public class CurrentUserControllerAdvice {
    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else {
            return (CurrentUser) authentication.getPrincipal();
        }
    }
}
