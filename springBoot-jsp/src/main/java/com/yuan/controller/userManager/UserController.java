package com.yuan.controller.userManager;

import com.yuan.model.User;
import com.yuan.service.userManager.UserService;
import com.yuan.utils.CommonsUtil;
import com.yuan.utils.SessionInfo;
import com.yuan.utils.UserIPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-08
 * Time: 11:30
 * description:
 **/
@SuppressWarnings("MagicConstant")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    private JavaMailSender javaMailSender;

   /* @RequestMapping("/getUsers")
    public List<User> getUsers(){
        List<User> userList = userService.getLoginUser()
        userList.forEach(user -> {
            System.out.println("id:"+user.getId()+"----userName:"+user.getUserName());
        });
        return userList;
    }*/

   @GetMapping(value = "login")
   public String login(){
       return "login";
   }

    @PostMapping(value = "/userLogin")
    @ResponseBody
    public ModelMap userLogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest request, HttpSession session){
        ModelMap modelMap = new ModelMap();
        if(!email.equals("") && !password.equals("")){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            User loginUser = userService.getLoginUser(user);
            if(loginUser!=null){
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.setUser(loginUser);
                sessionInfo.setUserIPAddress(UserIPUtil.getUserIPAddress(request));
                session.setAttribute("sessionInfo",sessionInfo);
                session.setAttribute("userName",loginUser.getUserName());
                modelMap.addAttribute("userName",loginUser.getUserName());

            }else{
                modelMap.addAttribute("userName",null);
            }
        }
        return  modelMap;
    }

    @RequestMapping("/userRegister")
    public String userRegister(User user) throws MessagingException {
        user.setId(CommonsUtil.getLowerUUID());
        int i = userService.insertSelective(user);
        /*if(i>0){
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);

            helper.setFrom("23013774@qq.com");
            helper.setSubject("邮件开发程序测试");
            helper.setText("<b><span style='color:red'>"+user.getUserName()+" 您好，欢迎注册小袁宝记账系统，<a href='http://192.168.31.247:8080/ssmm/'>请点击这里登录系统！</a></span></b>",true);

            //上传文件
            //helper.addAttachment("小袁宝1.jpg",new File("C:\\Users\\Administrator\\Desktop\\xiaoyuanbao.jpg"));
            //helper.addAttachment("小袁宝2.jpg",new File("C:\\Users\\Administrator\\Desktop\\xiaoYuanBao2.jpg"));

            helper.setTo(user.getEmail());//发送给谁写谁的邮箱，可以多个

            javaMailSender.send(mimeMailMessage);
            System.out.println("邮件已发送成功");
        }*/
        return "login";
    }

    @GetMapping("/index")
    public String redirectIndex(){
        return "index";
    }

    @GetMapping("/userRegisterInit")
    public String userRegisterInit(){
        return "userRegister";
    }

    @GetMapping("/userList")
    @ResponseBody
    public List<User> userList(){
        return userService.selectAll();
    }
}
