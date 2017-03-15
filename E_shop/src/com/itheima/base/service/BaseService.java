package com.itheima.base.service;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author Mxy
 * @time 2017-3-15 09:34:10
 * @version 1.0
 */
@Transactional
public interface BaseService<T> {
	
	/**
	 * 保存数据
	 * 
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 删除数据
	 * 
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 更新数据
	 * 
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 获取单条数据
	 * 
	 * @param id获取数据的id值
	 * @return 返回为具体模型对象
	 */
	T get(int id);
	
	/**
	 * 获取多条数据
	 * 
	 * @return 封装模型对象的list集合
	 */
	List<T> query();
}
