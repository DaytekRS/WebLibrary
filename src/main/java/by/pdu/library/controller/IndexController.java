package by.pdu.library.controller;

import by.pdu.library.domain.User;
import by.pdu.library.repository.UserMapper;
import by.pdu.library.util.PasswordGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("registerMessageUpdatePassword")
    private SimpleMailMessage simpleMailMessageUpdate;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
        try {
            String password = PasswordGen.generate(12);
            SimpleMailMessage templateMessage = simpleMailMessageUpdate;
            userMapper.updateUser(user.getEmail(), passwordEncoder.encode(password));
            SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);
            mailMessage.setTo(user.getEmail());
            mailMessage.setText("Hello you new password: " + password);
            mailSender.send(mailMessage);
            return "redirect:/login?registration=" + user.getLogin();
        } catch (MailException mailException) {
            System.out.println("Mail send failed.");
            mailException.printStackTrace();
        }
        return "redirect:/registration?error";
    }


    @GetMapping("/changePassword")
    public String changePrimaryPassword(Model model) {

        model.addAttribute("newPassword", new User());
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePrimaryPassword(@ModelAttribute("newPassword") User user) {
        User authUser = userMapper.searchUser(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(authUser.getEmail());
        userMapper.updatePassword(authUser.getEmail(), passwordEncoder.encode(user.getPassword()));
        return "redirect:/";
    }

}







