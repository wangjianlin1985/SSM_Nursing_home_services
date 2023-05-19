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
import com.jxxt.mapper.TEvaluationMapper;
import com.jxxt.mapper.TGardenerMapper;
import com.jxxt.mapper.TOldMapper;



@Controller
@RequestMapping ( "/TEvaluation" )
public class TEvaluationController extends Tools{
  




    @Autowired
    TEvaluationMapper tevaluationMapper;
    @Autowired
    TGardenerMapper tgardenerMapper;
    
    @Autowired
    TOldMapper toldMapper;
	
	
    @RequestMapping(value="TEvaluationHtml")
   	public ModelAndView getMainPage(HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("TEvaluation");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findList")
    public List findList(TEvaluation obj) {
    	List list = tevaluationMapper.findList(obj);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/getTEvaluation")
    public TEvaluation getTEvaluation(TEvaluation obj) {
    	TEvaluation list = tevaluationMapper.findList(obj).get(0);
        return list;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTEvaluationPage( Page page , TEvaluation obj) {
    	page.setSearchParam(obj);
    	tevaluationMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTEvaluation")
    public Map<String,Object> addTEvaluation(TEvaluation obj) {
    	int i =tevaluationMapper.insertSelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTEvaluation")
    public Map<String,Object> updateTEvaluation(TEvaluation obj) {
    	
    	TEvaluation te =tevaluationMapper.selectByPrimaryKey(obj.getId());
    	//评价完   将园丁设置空闲状态
    	TGardener  ga  = new TGardener();
    	ga.setId(te.getGardenerId());
    	ga.setGardenerStatus(1);
    	tgardenerMapper.updateByPrimaryKeySelective(ga);
    	//评价完  设置老人健康状况
    	TOld old=new TOld ();
    	old.setId(obj.getOldId());
    	old.setHealthStatus(obj.getHealthStatus());
    	toldMapper.updateByPrimaryKeySelective(old);
    	
    	
    	obj.setEndTime(nowTime());
    	int i =tevaluationMapper.updateByPrimaryKeySelective(obj);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "评价失败！");
        else
        	returnMap.put("showInfo", "评价成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTEvaluation")
    public Map<String,Object> deleteTEvaluation(int id) {
    	int i =tevaluationMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
