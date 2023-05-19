package com.jxxt.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TOldDetails {

  

	
		     /**
		     * Id
		     * 
		     */
		
			private Integer id;
		
		     /**
		     * Details
		     * 
		     */
		
			private String details;
		
		     /**
		     * CreateTime
		     * 
		     */
		
			private String createTime;
		
		     /**
		     * GardenerId
		     * 
		     */
		
			private Integer gardenerId;
		
		     /**
		     * GardenerName
		     * 
		     */
		
			private String gardenerName;
		
		     /**
		     * HealthStatus
		     * 
		     */
		
			private Integer healthStatus;
		
		     /**
		     * OldId
		     * 
		     */
		
			private Integer oldId;
		
    
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
		     * 获取: Details
		     * 
		     */
		    public String getDetails() {
			return details;
		    }
		     /**
		     * 设置: Details
		     * 
		     */
		    public void setDetails(String details) {
			this.details = details;
		    }
		     /**
		     * 获取: CreateTime
		     * 
		     */
		    public String getCreateTime() {
			return createTime;
		    }
		     /**
		     * 设置: CreateTime
		     * 
		     */
		    public void setCreateTime(String createTime) {
			this.createTime = createTime;
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
		     * 获取: GardenerName
		     * 
		     */
		    public String getGardenerName() {
			return gardenerName;
		    }
		     /**
		     * 设置: GardenerName
		     * 
		     */
		    public void setGardenerName(String gardenerName) {
			this.gardenerName = gardenerName;
		    }
		     /**
		     * 获取: HealthStatus
		     * 
		     */
		    public Integer getHealthStatus() {
			return healthStatus;
		    }
		     /**
		     * 设置: HealthStatus
		     * 
		     */
		    public void setHealthStatus(Integer healthStatus) {
			this.healthStatus = healthStatus;
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
       
 
   

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
