package ru.shop.model;

import java.util.UUID;

public class Order {
    private final UUID id;
    private final UUID custimerId;
    private final UUID productId;
    private final long count;
    private final long amount;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", custimerId=" + custimerId +
                ", productId=" + productId +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustimerId() {
        return custimerId;
    }

    public UUID getProductId() {
        return productId;
    }

    public long getCount() {
        return count;
    }

    public long getAmount() {
        return amount;
    }

    public Order(UUID id, UUID custimerId, UUID productId, long count, long amount) {
        this.id = id;
        this.custimerId = custimerId;
        this.productId = productId;
        this.count = count;
        this.amount = amount;
    }
}
