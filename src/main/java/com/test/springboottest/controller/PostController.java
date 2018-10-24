package com.test.springboottest.controller;

import com.test.springboottest.model.ArticleWithBLOBs;
import com.test.springboottest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 9:52 AM 2018/10/23
 * @ Description：
 * @ Modified By：
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/{id}")
    public String getPost(@PathVariable String id,Model model){
        ArticleWithBLOBs blog=articleService.selectByPrimaryKey(Integer.parseInt(id));
        if(blog==null){
            model.addAttribute("error","未找到此博客页！");
            return "index";
        }
        model.addAttribute("blogDetail",blog);
        return "post";
    }
}
