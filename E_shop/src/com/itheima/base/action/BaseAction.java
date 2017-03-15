package com.itheima.base.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.itheima.category.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 全局的action
 * 
 * @author Mxy
 * @time 2017-3-15 13:53:37
 * @version 1.0
 */
@SuppressWarnings("all")
@Component
@Lazy(value=true)
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware,ModelDriven<T> {
    
    protected Map<String, Object> pageMap = null;
    
    protected Integer page;  
    
    protected Integer rows; 
    
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Resource
    protected CategoryService categoryService;
    
	
	protected Map<String, Object> application;
	
	
	protected Map<String, Object> session;
	
	
	protected Map<String, Object> request;
	
	protected T model;

	@Override
	public void setApplication(Map<String, Object> application) {
		
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session= session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		
		this.request = request;
	}

    @Override
    public T getModel() {
        
        System.out.println(this.getClass().getSuperclass());
        
        System.out.println(this.getClass());
         
        System.out.println(this);
        
        
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
       
        Class clazz = (Class)type.getActualTypeArguments()[0];  
        
        try {  
            model = (T)clazz.newInstance();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }     
        return model;  
    }  
}
