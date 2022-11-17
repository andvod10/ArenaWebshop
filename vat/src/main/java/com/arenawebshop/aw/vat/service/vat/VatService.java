package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.entity.ProductType;
import com.arenawebshop.aw.vat.data.entity.Vat;

public interface VatService {
    void addVat(Vat vat);
    Vat getVat(String code, ProductType type);
    Double calculateVat(String code, ProductType type);
}
