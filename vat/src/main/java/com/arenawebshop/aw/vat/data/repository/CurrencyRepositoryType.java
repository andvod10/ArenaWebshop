package com.arenawebshop.aw.vat.data.repository;

import com.arenawebshop.aw.vat.data.entity.Currency;
import com.arenawebshop.aw.vat.data.entity.CurrencyRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepositoryType extends CrudRepository<CurrencyRate, String> {
    Optional<CurrencyRate> findByCode(Currency code);
}
