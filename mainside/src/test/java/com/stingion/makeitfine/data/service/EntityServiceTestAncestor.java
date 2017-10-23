package com.stingion.makeitfine.data.service;

import com.stingion.makeitfine.testconfiguration.MajorTestConfiguration;
import com.stingion.makeitfine.testconfiguration.ServiceTestConfiguration;
import com.stingion.makeitfine.data.repository.util.EntityHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Import(MajorTestConfiguration.class)
@Transactional
public class EntityServiceTestAncestor<T> {

    @Autowired
    protected EntityHelper<T> eH;

    @Autowired
    protected EntityService<T> entityService;

    @Autowired
    protected ServiceTestConfiguration.EntityTestData<T> entityTestData;

    @Test
    public void findAllTest() {
        assertThat(entityTestData.getFindAll()).isEqualTo(entityService.findAll().toString());
    }

    @Test
    public void findByIdTest() {
        assertThat(entityTestData.getFindById()).isEqualTo(entityService.findById(entityTestData.getId()).toString());
    }

    @Test
    public void deleteTest() {
        int beforeDelete = eH.getCount();
        T entity = entityService.findById(entityTestData.getId());
        entityService.delete(entity);
        int afterDelete = eH.getCount();

        assertThat(beforeDelete == afterDelete + 1);
        assertThat(!eH.isExist(entity));
    }

    @Test
    public void saveTest() {
        int beforeSave = eH.getCount();
        entityService.save(entityTestData.getSavedEntity());
        int afterSave = eH.getCount();

        assertThat(beforeSave + 1 == afterSave);
        assertThat(eH.isExist(entityTestData.getSavedEntity()));
    }

    @Test
    public void updateTest() {
        int beforeUpdate = eH.getCount();

        T entityBeforeUpdate = entityService.findById(entityTestData.getId());
        assertThat(entityTestData.getUpdateEntity().toString()).isNotEqualTo(entityBeforeUpdate.toString());
        entityService.update(entityTestData.getUpdateEntity());

        int afterUpdate = eH.getCount();

        T entityAfterUpdate = entityService.findById(entityTestData.getId());

        assertThat(entityTestData.getUpdateEntity().toString()).isEqualTo(entityAfterUpdate.toString());
        assertThat(beforeUpdate == afterUpdate);
    }
}