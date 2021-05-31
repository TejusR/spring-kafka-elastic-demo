package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public class UserRepository extends ElasticsearchRepository<User, String>{
    public List<User> findByFirstname(String firstName);
}
