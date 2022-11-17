package com.arenawebshop.vat.service.vat;

import com.arenawebshop.vat.data.entity.ProductType;
import com.arenawebshop.vat.data.entity.Vat;

public interface VatService {
    void addVat(Vat vat);
    Vat getVat(String code, ProductType type);
    Double calculateVat(String code, ProductType type);
}
