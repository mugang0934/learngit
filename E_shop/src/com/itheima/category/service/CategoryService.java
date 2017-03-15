package com.itheima.category.service;

import javax.transaction.Transactional;

import com.itheima.base.service.BaseService;
import com.itheima.category.domain.Category;

/**
 * 商品分类业务层接口 
 * 
 * @author Mxy
 * @time 2017-3-15 13:29:28
 * @version 1.0
 */
@Transactional
public interface CategoryService extends BaseService<Category> {

}
