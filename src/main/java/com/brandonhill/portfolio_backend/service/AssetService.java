package com.brandonhill.portfolio_backend.service;

import com.brandonhill.portfolio_backend.model.Asset;
import com.brandonhill.portfolio_backend.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAssetsByUser(String userId) {
        return assetRepository.findByUserId(userId);
    }

    public Asset addAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public void deleteAsset(String id) {
        assetRepository.deleteById(id);
    }

    public Asset updateAsset(Asset asset) {
        return assetRepository.save(asset);
    }
}