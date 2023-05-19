package com.jxxt.entity;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;
public class TLogin {

  

	
		     /**
		     * Id
		     * 
		     */
		
			private Integer id;
		
		     /**
		     * 用户名
		     * 
		     */
		
			private String username;
		
		     /**
		     * 密码
		     * 
		     */
		
			private String password;
		
		     /**
		     * 角色
		     * 
		     */
		
			private Integer role;
		
    
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
		     * 获取: 用户名
		     * 
		     */
		    public String getUsername() {
			return username;
		    }
		     /**
		     * 设置: 用户名
		     * 
		     */
		    public void setUsername(String username) {
			this.username = username;
		    }
		     /**
		     * 获取: 密码
		     * 
		     */
		    public String getPassword() {
			return password;
		    }
		     /**
		     * 设置: 密码
		     * 
		     */
		    public void setPassword(String password) {
			this.password = password;
		    }
		     /**
		     * 获取: 角色
		     * 
		     */
		    public Integer getRole() {
			return role;
		    }
		     /**
		     * 设置: 角色
		     * 
		     */
		    public void setRole(Integer role) {
			this.role = role;
		    }
       
 
   

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
