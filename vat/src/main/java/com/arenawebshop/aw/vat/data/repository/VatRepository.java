package com.arenawebshop.aw.vat.data.repository;

import com.arenawebshop.aw.vat.data.entity.ProductType;
import com.arenawebshop.aw.vat.data.entity.Vat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VatRepository extends CrudRepository<Vat, String> {
    Optional<Vat> findByCodeAndType(String code, ProductType type);
}
