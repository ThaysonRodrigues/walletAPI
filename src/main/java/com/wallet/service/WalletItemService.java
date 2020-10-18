package com.wallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.wallet.entity.WalletItem;
import com.wallet.enums.TypeEnum;

public interface WalletItemService {

	WalletItem save(WalletItem i);
	
	List<WalletItem> findByWalletAndType(Long wallet, TypeEnum type);
	
	BigDecimal sumByWalletId(Long wallet);
	
	Optional<WalletItem> findById(Long id);
	
	void deleteById(Long id);
}
