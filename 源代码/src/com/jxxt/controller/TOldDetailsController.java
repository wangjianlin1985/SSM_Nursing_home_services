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
import com.jxxt.entity.TEvaluation;
import com.jxxt.entity.TGardener;
import com.jxxt.entity.TOld;
import com.jxxt.entity.TOldDetails;
import com.jxxt.mapper.TEvaluationMapper;
import com.jxxt.mapper.TGardenerMapper;
import com.jxxt.mapper.TOldDetailsMapper;
import com.jxxt.mapper.TOldMapper;



@Controller
@RequestMapping ( "/TOldDetails" )
public class TOldDetailsController extends Tools{
  




    @Autowired
    TOldDetailsMapper tolddetailsMapper;

    @Autowired
    TOldMapper toldMapper;
	
    @Autowired
    TGardenerMapper tgardenerMapper;
    
    @Autowired
    TEvaluationMapper tevaluationMapper;
	
    @RequestMapping(value="TOldDetailsHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("TOldDetails");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(TOldDetails obj) {
    	List list = tolddetailsMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTOldDetailsPage( Page page , TOldDetails obj) {
    	page.setSearchParam(obj);
    	tolddetailsMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTOldDetails")
    public Map<String,Object> addTOldDetails(TOldDetails obj) {
    	obj.setCreateTime(nowTime());
    	TGardener gd = new TGardener();
    	gd.setId(obj.getOldId());
    	gd.setGardenerStatus(2);
    	if(obj.getHealthStatus()==3 || obj.getHealthStatus()==4) {
    		tgardenerMapper.updateByPrimaryKeySelective(gd);
    	}
    	TEvaluation et = new TEvaluation();
    	et.setBeginTime(obj.getCreateTime());
    	et.setGardenerId(obj.getGardenerId());
    	et.setOldId(obj.getOldId());
    	TOld old = toldMapper.selectByPrimaryKey(obj.getOldId());
    	et.setOldIdentity(old.getOldIdentity());
    	et.setOldName(old.getOldName());
    	tevaluationMapper.insertSelective(et);
    	
    	old.setHealthStatus(obj.getHealthStatus());
    	toldMapper.updateByPrimaryKeySelective(old);
    	int i =tolddetailsMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTOldDetails")
    public Map<String,Object> updateTOldDetails(TOldDetails obj) {
    	int i =tolddetailsMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTOldDetails")
    public Map<String,Object> deleteTOldDetails(int id) {
    	int i =tolddetailsMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
