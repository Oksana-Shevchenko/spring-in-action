package com.spring.mvc.controller;

import com.spring.mvc.entity.User;
import com.spring.mvc.service.IUserService;
import java.io.IOException;
import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    /*
    get GET
    list GET
    save create/edit POST
    delete DELETE
     */

    @Resource(name = "userService")
    private IUserService userService;

    @Inject
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String messages(@RequestParam("user") String username, Model model) {
        User user = userService.getUser(username);
        model.addAttribute(user);
        model.addAttribute(userService.getMessagesForUser(username));
        return "messages/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUserView(Model model) {
        model.addAttribute(new User());
        return "users/edit";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("users/user");
        modelAndView.addObject("user", userService.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult bindingResult, @RequestParam(value="image",required=false)MultipartFile image) {
        if (bindingResult.hasErrors()){
            return "users/edit";
        }
        userService.createUser(user);
        if(!image.isEmpty()) {
            validateImage(image);
            saveImage(user.getId()+".jpg", image);
        }
        return "redirect:/user/get?id=" + user.getId();
    }

    private void saveImage(String filename, MultipartFile image) {
        try {
            File file = new File("WEB-INF/resources/" + filename);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        }catch(IOException e){
            throw new RuntimeException("unable to save image");
        }
    }

    private void validateImage(MultipartFile image) {
        if(!image.getContentType().equals("image/jpeg")){
            throw new RuntimeException("only jpg ");
        }
    }

}
