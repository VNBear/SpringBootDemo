package com.vnbear.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.vnbear.springbootdemo.bean.LearnResource;
import com.vnbear.springbootdemo.bean.User;
import com.vnbear.springbootdemo.model.LeanQueryLeanListReq;
import com.vnbear.springbootdemo.service.LearnService;
import com.vnbear.springbootdemo.utils.Page;
import com.vnbear.springbootdemo.utils.ServletUtil;
import com.vnbear.springbootdemo.utils.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/learn")
public class LearnResourceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LearnService learnService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtil.isNull(author)) {
            result.put("message", "作者不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(title)) {
            result.put("message", "教程名称不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(url)) {
            result.put("message", "地址不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        LearnResource learnResource = new LearnResource();
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        int index = learnService.add(learnResource);
        if (index > 0) {
            result.put("message", "教程信息添加成功!");
            result.put("flag", true);
        } else {
            result.put("message", "教程信息添加失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }


    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public void selectLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        LearnResource learnResource = learnService.queryLearnResouceById(Long.valueOf(id));
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtil.isNull(author)) {
            result.put("message", "作者不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(title)) {
            result.put("message", "教程名称不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(url)) {
            result.put("message", "地址不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        result.put("message", "教程信息查询成功!");
        result.put("flag", true);

        ServletUtil.createSuccessResponse(200, result, response);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        LearnResource learnResource = learnService.queryLearnResouceById(Long.valueOf(id));
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtil.isNull(author)) {
            result.put("message", "作者不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(title)) {
            result.put("message", "教程名称不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(url)) {
            result.put("message", "地址不能为空!");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        int index = learnService.update(learnResource);
        System.out.println("修改结果=" + index);
        if (index > 0) {
            result.put("message", "教程信息修改成功!");
            result.put("flag", true);
        } else {
            result.put("message", "教程信息修改失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        JSONObject result = new JSONObject();
        //删除操作
        int index = learnService.deleteByIds(id);
        if (index > 0) {
            result.put("message", "教程信息删除成功!");
            result.put("flag", true);
        } else {
            result.put("message", "教程信息删除失败!");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }


    @RequestMapping(value = "/queryLeanList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void queryLearnList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("author", author);
        params.put("title", title);

        Page condition = new Page<LeanQueryLeanListReq>();
        condition.setPage(Integer.parseInt(page));
        condition.setRows(Integer.parseInt(rows));
        condition.setCondition(params);

        List<LearnResource> learnList = learnService.queryLearnResouceList(condition);
        PageInfo<LearnResource> pageInfo = new PageInfo<LearnResource>(learnList);
        JSONObject jo = new JSONObject();
        jo.put("rows", learnList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records", pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (!userName.equals("") && password != "") {
            User user = new User(userName, password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("result", "0");
        }
        return map;
    }

    @RequestMapping("/index")
    public ModelAndView index() {

        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");

        List<LearnResource> learnList = new ArrayList<LearnResource>();
        LearnResource bean = new LearnResource("官方参考文档", "Spring Boot Reference Guide", "http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean = new LearnResource("官方SpriongBoot例子", "官方SpriongBoot例子", "https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean = new LearnResource("龙国学院", "Spring Boot 教程系列学习", "http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean = new LearnResource("嘟嘟MD独立博客", "Spring Boot干货系列 ", "http://tengj.top/");
        learnList.add(bean);
        bean = new LearnResource("后端编程嘟", "Spring Boot教程和视频 ", "http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean = new LearnResource("程序猿DD", "Spring Boot系列", "http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean = new LearnResource("纯洁的微笑", "Sping Boot系列文章", "http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean = new LearnResource("CSDN——小当博客专栏", "Sping Boot学习", "http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean = new LearnResource("梁桂钊的博客", "Spring Boot 揭秘与实战", "http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean = new LearnResource("林祥纤博客系列", "从零开始学Spring Boot ", "http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }
}
