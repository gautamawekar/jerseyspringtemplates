package com.gawekar.service;

import java.util.Map;

public interface GenericDao<T> {
    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);

    <A> A findByNamedQuery(String namedQuery, Map<String, ? extends Object> params);
}
