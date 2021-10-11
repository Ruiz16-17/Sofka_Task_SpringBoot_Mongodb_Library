package com.Task_Mongodb_SpringBoot.library.repository;

import com.Task_Mongodb_SpringBoot.library.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRepository extends MongoRepository<Material, String> {
}
