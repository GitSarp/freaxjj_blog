package com.test.springboottest.controller;

import com.test.springboottest.constant.Constant;
import com.test.springboottest.model.AdminUser;
import com.test.springboottest.model.AdminUserWithBLOBs;
import com.test.springboottest.model.ArticleWithBLOBs;
import com.test.springboottest.model.Tag;
import com.test.springboottest.model.dto.BlogAddForm;
import com.test.springboottest.service.AdminUserService;
import com.test.springboottest.service.ArticleService;
import com.test.springboottest.service.TagService;
import com.test.springboottest.utils.ReflectUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 4:28 PM 2018/10/18
 * @ Description：
 * @ Modified By：
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;
    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/login")
    public String admin(){
        return "admin_login";
    }

    @GetMapping("/register")
    public String register(){
        return "admin_reg";
    }

    //验证登录
    @PostMapping("index")
    public String index(@ModelAttribute("form") AdminUser adminUser, Model model, HttpServletRequest request){

        AdminUser qryResult=adminUserService.selectByUsername(adminUser.getUsername());
        if(qryResult==null || !qryResult.getPassword().equals(adminUser.getPassword())){
            model.addAttribute("msg","用户名或密码错误");
            return "admin_login";
        }
        request.getSession().setAttribute(Constant.CURR_ADMIN_USER,qryResult);
        return "admin/index";
    }

    //注册
    @PostMapping("reg_check")
    public String regCheck(@ModelAttribute("form") AdminUser adminUser,Model model){
        Date date=Calendar.getInstance().getTime();//当前时间
        //应该加入一个注册最大的审核未过值
        AdminUserWithBLOBs adminUserWithBLOBs=new AdminUserWithBLOBs();
        ReflectUtil.getPropFromAnotherClass(adminUser,adminUserWithBLOBs);
        //加密
        adminUserWithBLOBs.setPassword(DigestUtils.md5Hex(adminUserWithBLOBs.getPassword()));
        adminUserWithBLOBs.setGmtModified(date);
        adminUserWithBLOBs.setGmtCreate(date);
        adminUserService.insert(adminUserWithBLOBs);
        model.addAttribute("info","请等待超级管理员审核完成后，结果会通过邮箱告知您");
        return "admin_reg";
    }


    @GetMapping("/blogmanage")
    public String blogManage(){
        return "admin/blog_manage";
    }

    //保存或发表博客
    @PostMapping("/blogadd")
    public String addBlog(BlogAddForm blogAddForm){

        Date date=Calendar.getInstance().getTime();//当前时间
        ArticleWithBLOBs articleWithBLOBs=new ArticleWithBLOBs();
        //blogAddFo的属性赋值给articleWithBLOBs
        ReflectUtil.getPropFromAnotherClass(blogAddForm,articleWithBLOBs);
        //暂时不错校验
        Tag tag=tagService.selectByName(blogAddForm.getRawTags());
        if(tag==null){
            tag=new Tag();
            tag.setName(blogAddForm.getRawTags());
            tag.setGmtCreate(date);
            tag.setGmtModified(date);
            tagService.insert(tag);
            tag=tagService.selectByName(blogAddForm.getRawTags());
        }
        articleWithBLOBs.setTagId(tag.getId());

        articleWithBLOBs.setGmtCreate(date);
        articleWithBLOBs.setGmtModified(date);

        articleService.insert(articleWithBLOBs);

        return "blogadd";
    }
}
