package ua.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.home.entity.User;
import ua.home.service.MailService;
import ua.home.service.UserService;
import ua.home.validator.UserValidator;

import javax.validation.Valid;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @Autowired
    MailService mailService;

    // new rest registration
    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUserRest(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()){
            return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
        }else {
            userService.add(user);
        mailService.send(user);

            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    @InitBinder
    public void bind(WebDataBinder dataBinder){
        dataBinder.addValidators(userValidator);
    }
}
