package com.jxxt.entity;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class TOldGuardian {

  

	
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
		     * GuardianId
		     * 
		     */
		
			private Integer guardianId;
		
    
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
		     * 获取: GuardianId
		     * 
		     */
		    public Integer getGuardianId() {
			return guardianId;
		    }
		     /**
		     * 设置: GuardianId
		     * 
		     */
		    public void setGuardianId(Integer guardianId) {
			this.guardianId = guardianId;
		    }
       
 
   

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
