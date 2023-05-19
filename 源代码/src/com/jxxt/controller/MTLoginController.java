package com.jxxt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jxxt.controller.tools.Tools;
import com.jxxt.entity.TLogin;
import com.jxxt.mapper.TLoginMapper;



@Controller
@RequestMapping ( "/login" )
public class MTLoginController extends Tools{
    /**
     * 日志系统
     */
	


  /*  @Autowired
    TNoticeMapper tNoticeMapper;*/
	@Autowired
	TLoginMapper tLoginMapper;
	
	
	
	
	@ResponseBody
    @RequestMapping(value="login")
	public Map<String, Object>   adminLogin(TLogin tLogin,HttpSession session,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String,Object>();
	
		TLogin tAdmin  = tLoginMapper.login(tLogin);
	
			if(tAdmin!=null) {
					if(tAdmin.getPassword().equals(tLogin.getPassword())) {
						
						session.setAttribute("user", tAdmin);
						map.put("isFlag", 0);
					}else {
						map.put("isFlag", 1);
					}
				
			}else {
				map.put("isFlag", 2);
			}
	
		
    	/*
		if(user != null){
			if(tuser.getPassword().equals(user.getPassword())){
				session.setAttribute("user", user);
 				return "main";
			}else{
				request.setAttribute("error_password", "密码错误！");
			}
		}else{
			request.setAttribute("error_username", "用户名不存在！");
		}*/
		return map;
	}
	
    @RequestMapping(value="main")
   	public String getMainPage(HttpSession session,HttpServletRequest request){
   		

   		return "main";
   	}

    
	@RequestMapping(value="editPassword")
	public Map<String,Object> editPassword(String password,HttpSession session){
		TLogin login = 	(TLogin) session.getAttribute("user");
		login.setPassword(password);
		int i =tLoginMapper.updateByPrimaryKeySelective(login);
		Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
	}
    
	@RequestMapping(value="logout")
	public ModelAndView loginoutAdmin(HttpSession session){
		ModelAndView mv = new ModelAndView("index");
		
		session.removeAttribute("user");
		return mv;
	}
	
	@RequestMapping(value="userLogot")
	public ModelAndView userLogot(HttpSession session){
		ModelAndView mv = new ModelAndView("jx/index");
		
		session.removeAttribute("user");
		return mv;
	}
	
	

	@RequestMapping(value="index")
	public String index(HttpSession session){
		
		return "index";
	}
	@RequestMapping(value="home")
	public ModelAndView home(HttpSession session){
		
		ModelAndView mv =new ModelAndView("home");
		
	
		return mv;
	}
	
	
	
	

	
}
