package com.jxxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jxxt.common.pojo.Page;
import com.jxxt.controller.tools.Tools;
import com.jxxt.entity.TOldGuardian;
import com.jxxt.mapper.TOldGuardianMapper;



@Controller
@RequestMapping ( "/TOldGuardian" )
public class TOldGuardianController extends Tools{
  




    @Autowired
    TOldGuardianMapper toldguardianMapper;

	
	
    @RequestMapping(value="TOldGuardianHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("TOldGuardian");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(TOldGuardian obj) {
    	List list = toldguardianMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTOldGuardianPage( Page page , TOldGuardian obj) {
    	page.setSearchParam(obj);
    	toldguardianMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTOldGuardian")
    public Map<String,Object> addTOldGuardian(TOldGuardian obj) {
    	int i =toldguardianMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTOldGuardian")
    public Map<String,Object> updateTOldGuardian(TOldGuardian obj) {
    	int i =toldguardianMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTOldGuardian")
    public Map<String,Object> deleteTOldGuardian(int id) {
    	int i =toldguardianMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
