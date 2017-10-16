/**
 * Created in scope of "Make it fine" project
 */
package com.stingion.makeitfine.data.service.impl;

import com.stingion.makeitfine.data.repository.EntityRepository;
import com.stingion.makeitfine.data.service.EntityService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
public class EntityServiceImpl<T> implements EntityService<T> {

    @Resource
    private EntityRepository<T> entityRepository;

    @Override
    public List<T> findAll() {
        return entityRepository.findAll();
    }

    @Override
    public T findById(int id) {
        return entityRepository.findOne(id);
    }

    @Override
    public T save(T entity) {
        return entityRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return save(entity);
    }

    @Override
    public void delete(T entity) {
        entityRepository.delete(entity);
    }
}