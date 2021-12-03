package com.example.demo.service;

import com.example.demo.modelo.CleaningProduct;
import com.example.demo.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository cleaningProductRepository;

    public List<CleaningProduct> getAll(){
        return cleaningProductRepository.getAll();
    }

    public Optional<CleaningProduct> getCleaningProducts(String reference){
        return cleaningProductRepository.getCleaningProducts(reference);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        if(cleaningProduct.getReference() == null) {
            return cleaningProduct;
        }else{
            return cleaningProductRepository.create(cleaningProduct);
        }
    }

    public CleaningProduct update(CleaningProduct cleaningProduct) {

        if (cleaningProduct.getReference() != null) {
            Optional<CleaningProduct> cleaningProduct1Db = cleaningProductRepository.getCleaningProducts(cleaningProduct.getReference());
            if (!cleaningProduct1Db.isEmpty()) {
                if (cleaningProduct.getBrand() != null) {
                    cleaningProduct1Db.get().setBrand(cleaningProduct.getBrand());
                }
                if (cleaningProduct.getCategory() != null) {
                    cleaningProduct1Db.get().setCategory(cleaningProduct.getCategory());
                }
                if (cleaningProduct.getDescription() != null) {
                    cleaningProduct1Db.get().setDescription(cleaningProduct.getDescription());
                }
                if (cleaningProduct.getPrice() != 0.0) {
                    cleaningProduct1Db.get().setPrice(cleaningProduct.getPrice());
                }
                if (cleaningProduct.getPrice() != 0.0) {
                    cleaningProduct1Db.get().setPrice(cleaningProduct.getPrice());
                }
                if (cleaningProduct.getQuantity() != 0) {
                    cleaningProduct1Db.get().setQuantity(cleaningProduct.getQuantity());
                }
                if (cleaningProduct.getPhotography() != null) {
                    cleaningProduct1Db.get().setPhotography(cleaningProduct.getPhotography());
                }
                cleaningProduct1Db.get().setAvailability(cleaningProduct.isAvailability());
                cleaningProductRepository.update(cleaningProduct1Db.get());
                return cleaningProduct1Db.get();
            } else {
                return cleaningProduct;
            }

        }else{
            return cleaningProduct;
        }
    }

    public boolean delete(String reference){
        Boolean aboolean= getCleaningProducts(reference).map(cleaningProduct -> {
            cleaningProductRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return aboolean;
    }
}
