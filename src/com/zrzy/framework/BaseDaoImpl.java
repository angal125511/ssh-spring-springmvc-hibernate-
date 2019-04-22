package com.zrzy.framework;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/22
 * Time: 16:52
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public BaseDaoImpl() {

        ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass(); // 获取泛型的class
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> findAll() {

        // 执行查询
        List<T> list = hibernateTemplate.execute(new QueryHibernateCallback());
        return list;
    }

    @Override
    public void add(T t) {
        hibernateTemplate.save(t);
    }

    @Override
    public T findById(Integer id) {

        return hibernateTemplate.get(entityClass, id);
    }

    @Override
    public void update(T t) {

        hibernateTemplate.update(t);
    }

    @Override
    public void delete(T t) {

        hibernateTemplate.delete(t);
    }


    //支持查询的内部类
    class QueryHibernateCallback implements HibernateCallback<List<T>>{
        @Override
        public List<T> doInHibernate(Session session) throws HibernateException {
            return session.createQuery("from " + entityClass.getSimpleName()).list();
        }
    }
}