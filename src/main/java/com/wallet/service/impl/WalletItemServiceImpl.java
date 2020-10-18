package com.wallet.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.entity.WalletItem;
import com.wallet.enums.TypeEnum;
import com.wallet.repository.WalletItemRepository;
import com.wallet.service.WalletItemService;

@Service
public class WalletItemServiceImpl implements WalletItemService {
	
	@Autowired
	private WalletItemRepository repository;
		
	@Override
	public WalletItem save(WalletItem i) {
		return repository.save(i);
	}
	
	@Override
	public List<WalletItem> findByWalletAndType(Long wallet, TypeEnum type) {
		return repository.findByWalletIdAndType(wallet, type);
	}

	@Override
	public BigDecimal sumByWalletId(Long wallet) {
		return repository.sumByWalletId(wallet);
	}

	@Override
	public Optional<WalletItem> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	
}
