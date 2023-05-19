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
import com.jxxt.entity.TGardener;
import com.jxxt.mapper.TGardenerMapper;



@Controller
@RequestMapping ( "/TGardener" )
public class TGardenerController extends Tools{
  




    @Autowired
    TGardenerMapper tgardenerMapper;

	
	
    @RequestMapping(value="TGardenerHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("TGardener");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(TGardener obj) {
    	List list = tgardenerMapper.findList(obj);
        return list;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/findOrderby")
    public List findOrderby() {
    	List list = tgardenerMapper.findOrderby();
        return list;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTGardenerPage( Page page , TGardener obj) {
    	page.setSearchParam(obj);
    	tgardenerMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTGardener")
    public Map<String,Object> addTGardener(TGardener obj) {
    	TGardener ga = new TGardener();
    	ga.setGardenerIdentity(obj.getGardenerIdentity());
    	List list = tgardenerMapper.findList(ga);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
       if(list.size()>0) {
    	   returnMap.put("showInfo", "身份证已经重复，请重新添加！");
       }else{
    	int i =tgardenerMapper.insertSelective(obj);
    	
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
       }
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTGardener")
    public Map<String,Object> updateTGardener(TGardener obj) {
    	int i =tgardenerMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTGardener")
    public Map<String,Object> deleteTGardener(int id) {
    	int i =tgardenerMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
