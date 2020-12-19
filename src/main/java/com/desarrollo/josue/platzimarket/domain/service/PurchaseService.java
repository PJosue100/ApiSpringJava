package com.desarrollo.josue.platzimarket.domain.service;

import com.desarrollo.josue.platzimarket.domain.Product;
import com.desarrollo.josue.platzimarket.domain.Purchase;
import com.desarrollo.josue.platzimarket.domain.repository.ProductRepository;
import com.desarrollo.josue.platzimarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Este es un servicio de dominio sirve como intermediario entre el controlador y el repositorio
@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save (Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
