package com.brandonhill.portfolio_backend.controller;

import com.brandonhill.portfolio_backend.model.Asset;
import com.brandonhill.portfolio_backend.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@CrossOrigin(origins = {"http://localhost:3000", "https://stockfolioai.netlify.app/"})
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping("/{userId}")
    public List<Asset> getUserAssets(@PathVariable String userId) {
        return assetService.getAssetsByUser(userId);
    }

    @PostMapping("/addAsset")
    public Asset addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    @PutMapping
    public Asset updateAsset(@RequestBody Asset asset) {
        return assetService.updateAsset(asset);
    }

    @DeleteMapping("/{id}")
    public void deleteAsset(@PathVariable String id) {
        assetService.deleteAsset(id);
    }
}