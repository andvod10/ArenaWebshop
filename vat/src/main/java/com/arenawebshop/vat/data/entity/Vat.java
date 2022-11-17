package com.arenawebshop.vat.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vat")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vat extends BaseEntity {
    @Column(name = "code")
    String code;
    @Column(name = "rate")
    Double rate;
    @Column(name = "type")
    ProductType type;
    @Column(name = "area")
    String area;
}
