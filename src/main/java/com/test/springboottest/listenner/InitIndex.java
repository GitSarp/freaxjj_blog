package com.test.springboottest.listenner;

import com.test.springboottest.service.ArticleService;
import com.test.springboottest.service.TagService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：freaxjj.
 * @ Date       ：Created in 2:56 PM 2018/10/22
 * @ Description：初始化所有博客信息
 * @ Modified By：
 */
@WebListener
public class InitIndex implements ServletContextListener,ApplicationContextAware {
    private static ApplicationContext applicationContext;//获取bean
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("开始初始化博客信息...");
        ServletContext servletContext=servletContextEvent.getServletContext();//获取ServletContext

        ArticleService articleService=(ArticleService) applicationContext.getBean("articleService");
        TagService tagService=(TagService)applicationContext.getBean("tagService");

        //时间分类
        List<Map> archiveList=articleService.getArchive();
        if(archiveList!=null){
            servletContext.setAttribute("archiveList",archiveList);
        }
        //标签分类
        List<Map> tagList=tagService.getTag();
        if(tagList!=null){
            servletContext.setAttribute("tagList",tagList);
        }
        System.out.println("初始化博客信息完成...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitIndex.applicationContext=applicationContext;
    }
}
