package com.java.microservices.saga.orchestration;

import static java.lang.System.*;

public class SagaTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        InventoryService inventoryService = new InventoryService();

        OrderSagaOrchestrator orchestrator = new OrderSagaOrchestrator(orderService, paymentService, inventoryService);

        // Execute saga
        orchestrator.executeSaga("prod-123", 1);
    }
}
enum OrderSagaState {
    ORDER_CREATED,
    PAYMENT_PROCESSED,
    INVENTORY_UPDATED,
    SAGA_COMPLETED,
    SAGA_FAILED
}


class Order {
    String productId;
    int quantity;

    public String getProductId() {
        return productId;
    }

    public Order(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}

class OrderService {
    public Order createOrder(String productId, int quantity) {
        // Logic to create an order
        out.println("Order created for product: " + productId);
        return new Order(productId, quantity);
    }

    public void cancelOrder(String orderId) {
        // Logic to cancel the order
        out.println("Order canceled with ID: " + orderId);
    }
}

class PaymentService {
    public boolean processPayment(String orderId) {
        // Logic to process payment
        out.println("Payment processed for order ID: " + orderId);
        return true; // Assume payment is successful
    }

    public void refundPayment(String orderId) {
        // Logic to refund payment
        out.println("Payment refunded for order ID: " + orderId);
    }
}

class InventoryService {
    public boolean reserveStock(String productId, int quantity) {
        // Logic to reserve inventory
        out.println("Reserved stock for product: " + productId);
        return true; // Assume stock reservation is successful
    }

    public void releaseStock(String productId, int quantity) {
        // Logic to release stock
        out.println("Stock released for product: " + productId);
    }
}