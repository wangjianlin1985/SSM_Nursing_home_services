package com.jxxt.controller;

import java.util.ArrayList;
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
import com.jxxt.entity.TOld;
import com.jxxt.mapper.TOldMapper;



@Controller
@RequestMapping ( "/TOld" )
public class TOldController extends Tools{
  




    @Autowired
    TOldMapper toldMapper;

	
	
    @RequestMapping(value="TOldHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("TOld");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList( TOld obj) {
    	List list = toldMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/findStatistical")
    public  List<Map<String ,Object>> findStatistical() {
    	 List<TOld> list = toldMapper.findStatistical();
    	
    	 List<Map<String ,Object>> list2 = new ArrayList<Map<String ,Object>>();
    	 for (TOld tOld : list) {
    		 Map<String ,Object> map = new HashMap<String ,Object>();
    		 map.put("value", tOld.getNum());
			if(tOld.getHealthStatus()==1) {
				//tOld.setOldName("健康");
				map.put("name", "健康");
			}
			if(tOld.getHealthStatus()==2) {
				
				map.put("name", "良好");
			}
			if(tOld.getHealthStatus()==3) {
				//tOld.setOldName("需要陪护");
				map.put("name", "需要陪护");
			}
			if(tOld.getHealthStatus()==4) {
				//tOld.setOldName("重点监护");
				map.put("name", "重点监护");
			}
			list2.add(map);
		}
        return list2;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/findListAll")
    public List findListAll() {
    	List list = toldMapper.findListAll();
        return list;
    }
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTOldPage( Page page , TOld obj) {
    	page.setSearchParam(obj);
    	toldMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTOld")
    public Map<String,Object> addTOld(TOld obj) {
    	
    	
    	TOld ga = new TOld();
    	ga.setOldIdentity(obj.getOldIdentity());
    	List list = toldMapper.findList(ga);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
       if(list.size()>0) {
    	   returnMap.put("showInfo", "身份证已经重复，请重新添加！");
       }else{
    		obj.setCreateTime(nowTime());
    	int i =toldMapper.insertSelective(obj);
    	
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
       }
    	
    	
    
    	/*int i =toldMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");*/
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTOld")
    public Map<String,Object> updateTOld(TOld obj) {
    	int i =toldMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTOld")
    public Map<String,Object> deleteTOld(int id) {
    	int i =toldMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
