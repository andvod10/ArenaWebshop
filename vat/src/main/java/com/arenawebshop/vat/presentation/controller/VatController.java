package com.arenawebshop.vat.presentation.controller;

import com.arenawebshop.vat.data.mapper.VatMapper;
import com.arenawebshop.vat.presentation.dto.RqVat;
import com.arenawebshop.vat.service.vat.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vat")
public class VatController {
    private VatService vatService;

    @Autowired
    VatController(VatService vatService) {
        this.vatService = vatService;
    }

    @PostMapping()
    void addVat(@RequestBody RqVat rqVat) {
        this.vatService.addVat(VatMapper.toEntity(rqVat));
    }
}
