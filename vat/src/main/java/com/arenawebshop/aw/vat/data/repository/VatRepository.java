package com.arenawebshop.aw.vat.data.repository;

import com.arenawebshop.aw.vat.data.entity.Vat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VatRepository extends CrudRepository<Vat, String> {
    public Optional<Vat> findByCodeAndType(String code, String type);
}
