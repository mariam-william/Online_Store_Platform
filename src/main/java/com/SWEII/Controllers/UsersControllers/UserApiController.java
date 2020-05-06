package com.SWEII.Controllers.UsersControllers;

import com.SWEII.Models.UsersModels.Administrator;
import com.SWEII.Models.UsersModels.NormalUser;
import com.SWEII.Models.UsersModels.StoreOwner;
import com.SWEII.Models.UsersModels.User;
import com.SWEII.Services.UsersServices.IUserServices;
import com.SWEII.Validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@RequestMapping("/home/user")
@RestController
public class UserApiController {

    @Autowired(required = true)
    IUserServices iUserServices;

    @Autowired(required = true)
    UserValidator userValidator;

    @GetMapping("/")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/register")
    public String userRegister(@RequestBody User user, BindingResult bindingResult,
                               @RequestParam(required = false) String address,
                               @RequestParam(required = false) String phoneNumber,
                               @RequestParam(required = false) String uName,
                               @RequestParam("cpassword") String cPassword) {

        user.setConfirmPassword(cPassword);
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object object : bindingResult.getFieldErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    stringBuilder.append('\n' + getErrorMessage(fieldError.getCode()));
                }
            }
            stringBuilder.append('\n' + "Registration Failed............");
            return stringBuilder.toString();
        }
        else{
            switch (user.getType().toLowerCase()) {
                case "admin":
                    User userCheck = iUserServices.findByUsername(uName);
                    if(userCheck != null && userCheck.getType().equalsIgnoreCase("Admin")){
                        if(iUserServices.saveUser(new Administrator(user)))
                            return "Admin Registration Done!";
                        return "Admin Registration Failed";
                    }
                    return ("No such administrator with username " + uName + "\nAdmin Registration Failed!");

                case "normal user":
                    if(iUserServices.saveUser(new NormalUser(user, address,phoneNumber)))
                        return "Normal User Registration Done!";
                    return "Normal User Registration Failed";

                case "store owner":
                    if(iUserServices.saveUser(new StoreOwner(user)))
                        return "Store Owner Registration Done!";
                    return "Store Owner Registration Failed";

                default:
                    return "Invalid Type....Registration Failed";
            }
        }
    }

    @GetMapping("/listAllUsers")
    public List<User> listAllUsers(){
        List<User> users = new ArrayList<>();
        users = iUserServices.listAllUsers();
        return users;
    }



    @GetMapping("/signIn")
    public String sign_in(@RequestParam("handle") String handle ,
                          @RequestParam("password")String password){
        User userCheck;
        if(handle.contains("@"))
            userCheck = iUserServices.findByEmail(handle);
        else
            userCheck = iUserServices.findByUsername(handle);
        if(userCheck != null){
            if(userCheck.getPassword().equals(password)) {
                return "Logged In Successfully";
            }
            else
                return "Incorrect Username Or Password";
        }
        return "Sorry, you are not a registered user! Please sign up first.";
    }

    //TO Return Error Message
    public String getErrorMessage(String errorCode){
        if(errorCode.equals("NotEmpty"))
            return "ALl fields are required.";
        if(errorCode.equals("Size.username"))
            return "Please username must be between 6 and 32 characters.";
        if(errorCode.equals("Duplicate.username"))
            return  "Someone already has this username.";
        if(errorCode.equals("Duplicate.email"))
            return  "Someone already has this email";
        if(errorCode.equals("Size.password"))
            return "Password must be at least 8 characters.";
        if(errorCode.equals("Diff.confirmPassword"))
            return "These passwords don't match.";
        if(errorCode.equals("confirmEmail"))
            return "Invalid Email Format.";
        return null;
    }
}
