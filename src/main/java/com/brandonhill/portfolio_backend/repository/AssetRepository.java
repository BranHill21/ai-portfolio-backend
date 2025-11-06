package com.brandonhill.portfolio_backend.repository;

import com.brandonhill.portfolio_backend.model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface AssetRepository extends MongoRepository<Asset, String> {
    List<Asset> findByUserId(String userId);
}