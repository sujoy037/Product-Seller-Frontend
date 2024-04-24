package com.sha.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sha.model.Purchase;
import com.sha.repository.ProductRepository;
import com.sha.repository.PurchaseRepository;
import com.sha.repository.projection.PurchaseItem;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
	private final PurchaseRepository purchaseRepository;

	@Override
	public Purchase savePurchase(Purchase purchase) {
		purchase.setPurchaseTime(LocalDateTime.now());

		return purchaseRepository.save(purchase);
	}

	@Override
	public List<PurchaseItem> findPurchaseItemsOfUser(Long userId) {
		return purchaseRepository.findAllPurchasesOfUser(userId);
	}

}
