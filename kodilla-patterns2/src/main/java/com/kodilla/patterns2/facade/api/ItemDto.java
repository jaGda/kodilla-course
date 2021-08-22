package com.kodilla.patterns2.facade.api;

public final class ItemDto {

    private final Long productId;
    private final double qty;

    public ItemDto(final Long productId, final double qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQty() {
        return qty;
    }
}
