package com.jxxt.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TGardener {

  

	
		     /**
		     * Id
		     * 
		     */
		
			private Integer id;
		
		     /**
		     * 姓名
		     * 
		     */
		
			private String gardenerName;
		
		     /**
		     * 性别
		     * 
		     */
		
			private String gardenerSex;
		
		     /**
		     * 身份证
		     * 
		     */
		
			private String gardenerIdentity;
		
		     /**
		     * 年龄
		     * 
		     */
		
			private String gardenerAge;
		
		     /**
		     * 状态
		     * 
		     */
		
			private Integer gardenerStatus;
		
			
			
			private Integer num1;
			private Integer num2;
			private Integer num3;
			private Integer num4;
			
			
    
		     /**
		     * 获取: Id
		     * 
		     */
		    public Integer getId() {
			return id;
		    }
		     /**
		     * 设置: Id
		     * 
		     */
		    public void setId(Integer id) {
			this.id = id;
		    }
		     /**
		     * 获取: 姓名
		     * 
		     */
		    public String getGardenerName() {
			return gardenerName;
		    }
		     /**
		     * 设置: 姓名
		     * 
		     */
		    public void setGardenerName(String gardenerName) {
			this.gardenerName = gardenerName;
		    }
		     /**
		     * 获取: 性别
		     * 
		     */
		    public String getGardenerSex() {
			return gardenerSex;
		    }
		     /**
		     * 设置: 性别
		     * 
		     */
		    public void setGardenerSex(String gardenerSex) {
			this.gardenerSex = gardenerSex;
		    }
		     /**
		     * 获取: 身份证
		     * 
		     */
		    public String getGardenerIdentity() {
			return gardenerIdentity;
		    }
		     /**
		     * 设置: 身份证
		     * 
		     */
		    public void setGardenerIdentity(String gardenerIdentity) {
			this.gardenerIdentity = gardenerIdentity;
		    }
		     /**
		     * 获取: 年龄
		     * 
		     */
		    public String getGardenerAge() {
			return gardenerAge;
		    }
		     /**
		     * 设置: 年龄
		     * 
		     */
		    public void setGardenerAge(String gardenerAge) {
			this.gardenerAge = gardenerAge;
		    }
		     /**
		     * 获取: 状态
		     * 
		     */
		    public Integer getGardenerStatus() {
			return gardenerStatus;
		    }
		     /**
		     * 设置: 状态
		     * 
		     */
		    public void setGardenerStatus(Integer gardenerStatus) {
			this.gardenerStatus = gardenerStatus;
		    }
       
 
   

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public Integer getNum1() {
		return num1;
	}
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	public Integer getNum2() {
		return num2;
	}
	public void setNum2(Integer num2) {
		this.num2 = num2;
	}
	public Integer getNum3() {
		return num3;
	}
	public void setNum3(Integer num3) {
		this.num3 = num3;
	}
	public Integer getNum4() {
		return num4;
	}
	public void setNum4(Integer num4) {
		this.num4 = num4;
	}
}
