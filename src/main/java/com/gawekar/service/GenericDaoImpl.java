package com.gawekar.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.orm.jpa.JpaTemplate;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    private JpaTemplate jpaTemplate;
    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    public JpaTemplate getJpaTemplate() {
        return jpaTemplate;
    }

    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    @Override
    public T create(T t) {
        jpaTemplate.persist(t);
        return t;
    }

    @Override
    public void delete(Object id) {
        this.jpaTemplate.remove(find(id));
    }

    @Override
    public T find(Object id) {
        return (T) this.jpaTemplate.find(type, id);
    }

    @Override
    public T update(T t) {
        return this.jpaTemplate.merge(t);
    }

    public <A> A findByNamedQuery(String namedQuery, Map<String, ? extends Object> params) {
        if (params == null) {
            return (A) jpaTemplate.findByNamedQuery(namedQuery);
        }
        return (A) this.jpaTemplate.findByNamedQueryAndNamedParams("Person.findPersonById", params).get(0);
    }
}
