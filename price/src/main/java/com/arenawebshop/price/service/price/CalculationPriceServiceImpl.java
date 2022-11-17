package com.arenawebshop.price.service.price;

import com.arenawebshop.price.data.mapper.PriceMapper;
import com.arenawebshop.price.presentation.dto.RqPrice;
import com.arenawebshop.price.presentation.dto.RsPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculationPriceServiceImpl implements CalculationPriceService {
    // It's better to hold these values in DB, for more then one freighter. And it will be easier to modify
    @Value("${freight.price}")
    private double freightPrice;
    @Value("${freight.items}")
    private int freightItems;
    @Value("${freight.additional-price}")
    private double additionalFreightPrice;
    @Value("${freight.additional-items}")
    private int additionalFreightItems;

    /**
     * The calculation is:
     * Total price = amount x price + freigh
     */
    @Override
    public RsPrice calculateTotalPrice(String... args) {
        RqPrice rqPrice = PriceMapper.toRqPrice(args);
        double totalPrice = rqPrice.price * rqPrice.amount;
        totalPrice += calculateFreight(rqPrice.amount);
        return RsPrice.builder()
                .price(totalPrice)
                .build();
    }

    /**
     * Freight depends on the amount of products.
     * • Up to and including 10 items: 50,-
     * • For each additional 10 items: 25,-
     * For example 48 items:
     * 50 + 4 * 25
     */
    private Double calculateFreight(Integer amount) {
        return freightPrice + Math.ceil((amount - freightItems) / (double) additionalFreightItems) * additionalFreightPrice;
    }
}
