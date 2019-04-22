package com.zrzy.framework;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/22
 * Time: 16:50
 */
public interface BaseDao<T> {

    public List<T> findAll(); // 查询全部

    public T findById(Integer id);

    public void add(T t);

    public void update(T t);

    public void delete(T t);
}
