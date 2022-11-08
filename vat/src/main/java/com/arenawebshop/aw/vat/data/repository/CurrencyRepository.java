package com.arenawebshop.aw.vat.data.repository;

import com.arenawebshop.aw.vat.data.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {
    public Optional<Currency> findByCode(String code);
}
