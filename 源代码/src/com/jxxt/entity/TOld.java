package com.jxxt.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TOld {

  

	
		     /**
		     * Id
		     * 
		     */
		
			private Integer id;
		
		     /**
		     * 姓名
		     * 
		     */
		
			private String oldName;
		
		     /**
		     * 性别
		     * 
		     */
		
			private String oldSex;
		
		     /**
		     * 身份证
		     * 
		     */
		
			private String oldIdentity;
		
		     /**
		     * 年龄
		     * 
		     */
		
			private String oldAge;
		
		     /**
		     * 健康状况
		     * 
		     */
		
			private Integer healthStatus;
		
		     /**
		     * 创建时间
		     * 
		     */
		
			private String createTime;
		
			
			private int num;
			
			private int guardianId;
    
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
		    public String getOldName() {
			return oldName;
		    }
		     /**
		     * 设置: 姓名
		     * 
		     */
		    public void setOldName(String oldName) {
			this.oldName = oldName;
		    }
		     /**
		     * 获取: 性别
		     * 
		     */
		    public String getOldSex() {
			return oldSex;
		    }
		     /**
		     * 设置: 性别
		     * 
		     */
		    public void setOldSex(String oldSex) {
			this.oldSex = oldSex;
		    }
		     /**
		     * 获取: 身份证
		     * 
		     */
		    public String getOldIdentity() {
			return oldIdentity;
		    }
		     /**
		     * 设置: 身份证
		     * 
		     */
		    public void setOldIdentity(String oldIdentity) {
			this.oldIdentity = oldIdentity;
		    }
		     /**
		     * 获取: 年龄
		     * 
		     */
		    public String getOldAge() {
			return oldAge;
		    }
		     /**
		     * 设置: 年龄
		     * 
		     */
		    public void setOldAge(String oldAge) {
			this.oldAge = oldAge;
		    }
		     /**
		     * 获取: 健康状况
		     * 
		     */
		    public Integer getHealthStatus() {
			return healthStatus;
		    }
		     /**
		     * 设置: 健康状况
		     * 
		     */
		    public void setHealthStatus(Integer healthStatus) {
			this.healthStatus = healthStatus;
		    }
		     /**
		     * 获取: 创建时间
		     * 
		     */
		    public String getCreateTime() {
			return createTime;
		    }
		     /**
		     * 设置: 创建时间
		     * 
		     */
		    public void setCreateTime(String createTime) {
			this.createTime = createTime;
		    }
       
 
   

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGuardianId() {
		return guardianId;
	}
	public void setGuardianId(int guardianId) {
		this.guardianId = guardianId;
	}
}
