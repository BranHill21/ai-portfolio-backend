package com.brandonhill.portfolio_backend;

import com.brandonhill.portfolio_backend.model.Asset;
import com.brandonhill.portfolio_backend.model.User;
import com.brandonhill.portfolio_backend.repository.UserRepository;
import com.brandonhill.portfolio_backend.repository.AssetRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PortfolioBackendApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRepository;

    private static String userId;
    private static String assetId;

    @Test
    @Order(1)
    void registerUserTest() {
        User user = new User(null, "testuser", "pass123", "test@example.com");
        User saved = userRepository.save(user);
        assertNotNull(saved.getId());
        userId = saved.getId();
    }

    @Test
    @Order(2)
    void addAssetTest() {
        Asset asset = new Asset(null, userId, "AAPL", 5, 175.0);
        Asset saved = assetRepository.save(asset);
        assertNotNull(saved.getId());
        assetId = saved.getId();
    }

    @Test
    @Order(3)
    void getAssetsByUserTest() {
        List<Asset> assets = assetRepository.findByUserId(userId);
        assertFalse(assets.isEmpty());
    }

    @Test
    @Order(4)
    void updateAssetTest() {
        Asset asset = assetRepository.findById(assetId).orElse(null);
        assertNotNull(asset);
        asset.setQuantity(10);
        Asset updated = assetRepository.save(asset);
        assertEquals(10, updated.getQuantity());
    }

    @Test
    @Order(5)
    void deleteAssetTest() {
        assetRepository.deleteById(assetId);
        assertFalse(assetRepository.findById(assetId).isPresent());
    }

    @Test
    @Order(6)
    void deleteUserTest() {
        userRepository.deleteById(userId);
        assertFalse(userRepository.findById(userId).isPresent());
    }
}