package com.example.demo.crud;

import com.example.demo.modelo.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, String> {


}
