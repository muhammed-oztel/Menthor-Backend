package com.example.test.service;

import com.example.test.model.TestEntity;
import com.example.test.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestEntity Create(TestEntity entity){
        return testRepository.save(entity);
    }

    public TestEntity Update(Long id,TestEntity entity){
        TestEntity db = testRepository.getReferenceById(id);
        db.setName(entity.getName());
        db.setSurname(entity.getSurname());
        db.setBirth(entity.getBirth());
        db.setDesc(entity.getDesc());
        return testRepository.save(db);
    }

    public String Delete(Long id){
        testRepository.deleteById(id);
        return "silme işlemi başarılı";
    }

    public List<TestEntity> All(){
        return testRepository.findAll();
    }
}
