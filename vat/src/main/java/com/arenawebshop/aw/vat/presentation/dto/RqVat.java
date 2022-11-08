package com.arenawebshop.aw.vat.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RqVat {
    String code;
    String type;
    String area;
    Double rate;
}
