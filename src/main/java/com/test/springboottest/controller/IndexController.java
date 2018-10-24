package com.test.springboottest.controller;

import com.test.springboottest.constant.Constant;
import com.test.springboottest.model.ArticleWithBLOBs;
import com.test.springboottest.service.ArticleService;
import com.test.springboottest.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 6:42 PM 2018/10/17
 * @ Description：
 * @ Modified By：
 */
@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;
    @Autowired
    TagService tagService;

    /**
     * 前台首页
     * GET
     */
    @GetMapping(value = {"/index","/"})
    public String index(HttpServletRequest request, Model model) {
        //刷新
        //时间分类
        List<Map> archiveList=articleService.getArchive();
        if(archiveList!=null){
            model.addAttribute("archiveList",archiveList);
        }
        //标签分类
        List<Map> tagList=tagService.getTag();
        if(tagList!=null){
            model.addAttribute("tagList",tagList);
        }

        return page("1",model,"");
    }

    /**
     * 分页
     * GET
     * gmtCreateStr:时间分类入参
     */
    @GetMapping("/page/{pageNo}")
    public String page(@PathVariable String pageNo, Model model, @RequestParam(value = "gmtCreateStr",required = false,defaultValue = "") String gmtCreateStr) {
        int page_no=Integer.parseInt(pageNo);
        Map<String,Object> params=new HashMap<>();
        List<ArticleWithBLOBs> blogs=null;

        //分页数
        int counts=articleService.count(gmtCreateStr);
        model.addAttribute("pageNum",counts/Constant.PAGE_SIZE+1);


        //是否按时间分页
        model.addAttribute("gmtCreateStr",gmtCreateStr);

        //置顶博客数
        int topNum=articleService.countTop(gmtCreateStr);
        if(page_no==1){
            params.put("topNum",topNum);
            params.put("offset",0);
            params.put("limit",Constant.PAGE_SIZE-topNum>0?Constant.PAGE_SIZE-topNum:0);//置顶数限制一页文章数，否则多余的不显示
            params.put("gmtCreateStr",gmtCreateStr);
            blogs=articleService.page(params);
        }else{
            params.put("topNum",0);
            params.put("offset",(page_no-1)*Constant.PAGE_SIZE-topNum);
            params.put("limit",Constant.PAGE_SIZE);
            params.put("gmtCreateStr",gmtCreateStr);
            blogs=articleService.page(params);
        }
        model.addAttribute("blogList",blogs);
        return "index";
    }
}
