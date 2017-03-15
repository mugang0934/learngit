package com.itheima.base.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.itheima.base.service.BaseService;

/**
 * 全局业务层实现类
 * 
 * @author Mxy
 * @time 2017-3-15 09:36:50
 * @version 1.0
 */
@Service
@Lazy(value=true)
public class BaseServiceImpl<T> implements BaseService<T> {

	//获取当前操作类型即泛型T
	private Class clazz;

	@Resource
	private SessionFactory sessionFactory;

	public BaseServiceImpl() {
		
        System.out.println(this);
        System.out.println(this.getClass());
        System.out.println(this.getClass().getSuperclass());
		
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
        clazz = (Class)type.getActualTypeArguments()[0];  

	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {  
        //从当前线程获取session，如果没有则创建一个新的session  
        return sessionFactory.getCurrentSession();  
        
    }
    
	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}
	
	@Override
	public void delete(int id) {
		System.out.println(clazz.getSimpleName());  
		
		String hql = "delete "+clazz.getSimpleName()+"c where c.id = :id";
		
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
		
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	
	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
				
	}
}
