package com.arenawebshop.vat.service.vat;

import com.arenawebshop.vat.data.entity.ProductType;
import com.arenawebshop.vat.data.entity.Vat;
import com.arenawebshop.vat.data.repository.VatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VatServiceImpl implements VatService {
    private VatRepository vatRepository;

    @Autowired
    VatServiceImpl(
            VatRepository vatRepository
    ) {
        this.vatRepository = vatRepository;
    }

    @Override
    public void addVat(Vat vat) {
        this.vatRepository.save(vat);
    }

    @Override
    public Vat getVat(String code, ProductType type) {
        return this.vatRepository.findByCodeAndType(code, type)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Couldn't find Vat by code %s", type)));
    }

    @Override
    public Double calculateVat(String code, ProductType type) {
        return this.getVat(code, type).getRate();
    }
}
