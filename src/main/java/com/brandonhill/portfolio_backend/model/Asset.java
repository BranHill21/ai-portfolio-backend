package com.brandonhill.portfolio_backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "assets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset {
    @Id
    private String id;
    private String userId;  // links to the User
    private String symbol;  // e.g., "AAPL", "BTC-USD"
    private double quantity;
    private double buyPrice;
}