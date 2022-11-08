package com.arenawebshop.aw.vat.service.vat;

import com.arenawebshop.aw.vat.data.entity.Vat;

public interface VatService {
    public void addVat(Vat vat);
    public Vat getVat(String code, String type);
}
