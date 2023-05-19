package com.jxxt.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TGuardian {

  

	
		     /**
		     * Id
		     * 
		     */
		
			private Integer id;
		
		     /**
		     * 姓名
		     * 
		     */
		
			private String guardianName;
		
		     /**
		     * 性别
		     * 
		     */
		
			private String guardianSex;
		
		     /**
		     * 身份证
		     * 
		     */
		
			private String guardianIdentity;
		
		     /**
		     * 电话
		     * 
		     */
		
			private String guardianPhone;
		
		     /**
		     * 关系
		     * 
		     */
		
			private String guardianRelation;
			
			private int oldId;
		
		     /**
		     * 创建时间
		     * 
		     */
		
			private String createTime;
		
    
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
		    public String getGuardianName() {
			return guardianName;
		    }
		     /**
		     * 设置: 姓名
		     * 
		     */
		    public void setGuardianName(String guardianName) {
			this.guardianName = guardianName;
		    }
		     /**
		     * 获取: 性别
		     * 
		     */
		    public String getGuardianSex() {
			return guardianSex;
		    }
		     /**
		     * 设置: 性别
		     * 
		     */
		    public void setGuardianSex(String guardianSex) {
			this.guardianSex = guardianSex;
		    }
		     /**
		     * 获取: 身份证
		     * 
		     */
		    public String getGuardianIdentity() {
			return guardianIdentity;
		    }
		     /**
		     * 设置: 身份证
		     * 
		     */
		    public void setGuardianIdentity(String guardianIdentity) {
			this.guardianIdentity = guardianIdentity;
		    }
		     /**
		     * 获取: 电话
		     * 
		     */
		    public String getGuardianPhone() {
			return guardianPhone;
		    }
		     /**
		     * 设置: 电话
		     * 
		     */
		    public void setGuardianPhone(String guardianPhone) {
			this.guardianPhone = guardianPhone;
		    }
		     /**
		     * 获取: 关系
		     * 
		     */
		    public String getGuardianRelation() {
			return guardianRelation;
		    }
		     /**
		     * 设置: 关系
		     * 
		     */
		    public void setGuardianRelation(String guardianRelation) {
			this.guardianRelation = guardianRelation;
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
	public int getOldId() {
		return oldId;
	}
	public void setOldId(int oldId) {
		this.oldId = oldId;
	}
}
