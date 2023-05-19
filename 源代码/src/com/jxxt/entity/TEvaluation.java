package com.jxxt.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TEvaluation {

  

	
		     /**
		     * Id
		     * 
		     */
		
			private Integer id;
		
		     /**
		     * OldId
		     * 
		     */
		
			private Integer oldId;
		
		     /**
		     * GardenerId
		     * 
		     */
		
			private Integer gardenerId;
		
		     /**
		     * BeginTime
		     * 
		     */
		
			private String beginTime;
		
		     /**
		     * EndTime
		     * 
		     */
		
			private String endTime;
		
		     /**
		     * Type
		     * 
		     */
		
			private Integer type;
		
		     /**
		     * OldName
		     * 
		     */
		
			private String oldName;
		
		     /**
		     * OldIdentity
		     * 
		     */
		
			private String oldIdentity;
		
			
			
			
			
			
			private String gardenerName;
			

			private Integer healthStatus;
			
			
			
    
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
		     * 获取: OldId
		     * 
		     */
		    public Integer getOldId() {
			return oldId;
		    }
		     /**
		     * 设置: OldId
		     * 
		     */
		    public void setOldId(Integer oldId) {
			this.oldId = oldId;
		    }
		     /**
		     * 获取: GardenerId
		     * 
		     */
		    public Integer getGardenerId() {
			return gardenerId;
		    }
		     /**
		     * 设置: GardenerId
		     * 
		     */
		    public void setGardenerId(Integer gardenerId) {
			this.gardenerId = gardenerId;
		    }
		     /**
		     * 获取: BeginTime
		     * 
		     */
		    public String getBeginTime() {
			return beginTime;
		    }
		     /**
		     * 设置: BeginTime
		     * 
		     */
		    public void setBeginTime(String beginTime) {
			this.beginTime = beginTime;
		    }
		     /**
		     * 获取: EndTime
		     * 
		     */
		    public String getEndTime() {
			return endTime;
		    }
		     /**
		     * 设置: EndTime
		     * 
		     */
		    public void setEndTime(String endTime) {
			this.endTime = endTime;
		    }
		     /**
		     * 获取: Type
		     * 
		     */
		    public Integer getType() {
			return type;
		    }
		     /**
		     * 设置: Type
		     * 
		     */
		    public void setType(Integer type) {
			this.type = type;
		    }
		     /**
		     * 获取: OldName
		     * 
		     */
		    public String getOldName() {
			return oldName;
		    }
		     /**
		     * 设置: OldName
		     * 
		     */
		    public void setOldName(String oldName) {
			this.oldName = oldName;
		    }
		     /**
		     * 获取: OldIdentity
		     * 
		     */
		    public String getOldIdentity() {
			return oldIdentity;
		    }
		     /**
		     * 设置: OldIdentity
		     * 
		     */
		    public void setOldIdentity(String oldIdentity) {
			this.oldIdentity = oldIdentity;
		    }
       
 
   

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	public String getGardenerName() {
		return gardenerName;
	}
	public void setGardenerName(String gardenerName) {
		this.gardenerName = gardenerName;
	}
	public Integer getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(Integer healthStatus) {
		this.healthStatus = healthStatus;
	}
}
