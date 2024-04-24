package com.sha.service;

import java.util.List;

import com.sha.model.Purchase;
import com.sha.repository.projection.PurchaseItem;

public interface PurchaseService {
	Purchase savePurchase(Purchase purchase);

    List<PurchaseItem> findPurchaseItemsOfUser(Long userId);

}
