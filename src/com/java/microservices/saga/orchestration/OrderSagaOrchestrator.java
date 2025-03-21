package com.java.microservices.saga.orchestration;

public class OrderSagaOrchestrator {
    private final OrderService orderService;
    private final PaymentService paymentService;
    private final InventoryService inventoryService;

    public OrderSagaOrchestrator(OrderService orderService, PaymentService paymentService, InventoryService inventoryService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public void executeSaga(String productId, int quantity) {
        String orderId = null;
        try {
            // Step 1: Create Order
            Order order = orderService.createOrder(productId, quantity);
            orderId = order.getProductId();

            // Step 2: Process Payment
            if (!paymentService.processPayment(orderId)) {
                throw new RuntimeException("Payment failed");
            }

            // Step 3: Reserve Inventory
            if (!inventoryService.reserveStock(productId, quantity)) {
                throw new RuntimeException("Inventory reservation failed");
            }

            System.out.println("Saga completed successfully");
        } catch (Exception e) {
            System.out.println("Saga failed: " + e.getMessage());
            compensate(orderId, productId, quantity);
        }
    }

    private void compensate(String orderId, String productId, int quantity) {
        // Rollback in reverse order
        inventoryService.releaseStock(productId, quantity);
        paymentService.refundPayment(orderId);
        orderService.cancelOrder(orderId);
        System.out.println("Compensation actions completed");
    }
}
