package com.example.test.controller;

import com.example.test.model.TestEntity;
import com.example.test.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menttest")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/create")
    public TestEntity Create(@RequestBody TestEntity entity){
        return testService.Create(entity);
    }

    @PutMapping("/update/{id}")
    public TestEntity Update(@PathVariable Long id, @RequestBody TestEntity entity){
        return testService.Update(id, entity);
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable Long id){
        return testService.Delete(id);
    }

    @GetMapping("/all")
    public List<TestEntity> All(){
        return testService.All();
    }
}
