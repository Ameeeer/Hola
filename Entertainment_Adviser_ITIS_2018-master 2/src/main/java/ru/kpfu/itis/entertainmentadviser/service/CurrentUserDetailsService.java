package ru.kpfu.itis.entertainmentadviser.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entertainmentadviser.dao.UserDao;
import ru.kpfu.itis.entertainmentadviser.model.CurrentUser;
import ru.kpfu.itis.entertainmentadviser.model.User;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user with username = " + username + " found");
        }
        CurrentUser currentUser = new CurrentUser(user);
        return currentUser;
    }

}
