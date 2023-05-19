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
import com.jxxt.entity.TGuardian;
import com.jxxt.entity.TOld;
import com.jxxt.mapper.TGuardianMapper;



@Controller
@RequestMapping ( "/TGuardian" )
public class TGuardianController extends Tools{
  




    @Autowired
    TGuardianMapper tguardianMapper;

	
	
    @RequestMapping(value="TGuardianHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("TGuardian");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(TGuardian obj) {
    	List list = tguardianMapper.findList(obj);
        return list;
    }
    @ResponseBody
    @RequestMapping(value= "/findListAll")
    public List findListAll() {
    	List list = tguardianMapper.findListAll();
        return list;
    }
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTGuardianPage( Page page , TGuardian obj) {
    	page.setSearchParam(obj);
    	tguardianMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTGuardian")
    public Map<String,Object> addTGuardian(TGuardian obj) {
    	
    	
    	TGuardian ga = new TGuardian();
    	ga.setGuardianIdentity(obj.getGuardianIdentity());
    	List list = tguardianMapper.findList(ga);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
       if(list.size()>0) {
    	   returnMap.put("showInfo", "身份证已经重复，请重新添加！");
       }else{
    		obj.setCreateTime(nowTime());
    	int i =tguardianMapper.insertSelective(obj);
    	
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
       }
   
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTGuardian")
    public Map<String,Object> updateTGuardian(TGuardian obj) {
    	int i =tguardianMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTGuardian")
    public Map<String,Object> deleteTGuardian(int id) {
    	int i =tguardianMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
