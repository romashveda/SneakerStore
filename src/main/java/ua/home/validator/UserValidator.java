package ua.home.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.home.entity.User;
import ua.home.service.UserService;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator{
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    //pattern for email
    private Pattern pattern1 = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." +
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09" +
            "\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)" +
            "+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4]4" +
            "[0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|" +
            "\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

    //pattern for phoneNumber
    private Pattern pattern2 = Pattern.compile("^(039|050|063|0[6-8]{2}|09[1-9]{1})-([0-9]{3})-([0-9]{2}-([0-9]{2}))$");

    @Autowired
    UserService userService;

    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","username.required","Enter your username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","email.required","Enter your Email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","phone.required","Enter your phone number");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.required","Enter your password");

        if (!user.getPassword().equals(user.getConfirmationpass())){
            errors.rejectValue("confirmationpass","password.confirm.wrong","Password doesn't match!");
        }

        Matcher matcher;
//        if (!(matcher= pattern1.matcher(user.getEmail())).matches() && !user.getEmail().isEmpty()){
//            errors.rejectValue("email","bad.email","Incorrect email");
//        }

        if (!(matcher=pattern2.matcher(user.getPhone())).matches()){
            errors.rejectValue("phone","bad.phone","Incorrect phone");
        }

        List<User> users = userService.findAll();
        for (User u: users){
            if (u.getUsername().equals(user.getUsername()))
                errors.rejectValue("username","bad.username","user with this username already exist");
            if(u.getEmail().equals(user.getEmail()))
                errors.rejectValue("email","bad.email","user with this email already exists");
        }

    }
}
