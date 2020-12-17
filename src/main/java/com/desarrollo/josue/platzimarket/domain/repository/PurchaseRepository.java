package com.desarrollo.josue.platzimarket.domain.repository;

import com.desarrollo.josue.platzimarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save (Purchase purchase);
}
