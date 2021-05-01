package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(InformationService informationService,
                          OrderService orderService,
                          OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest saleRequest) {

        boolean isBought = orderService.buy(saleRequest.getUser(),
                saleRequest.getProduct(),
                saleRequest.getPurchaseDay());

        if (isBought) {
            informationService.inform(saleRequest.getUser(),
                    saleRequest.getProduct());
            orderRepository.createSale(saleRequest.getUser(),
                    saleRequest.getProduct(),
                    saleRequest.getPurchaseDay());
            return new OrderDto(saleRequest.getUser(),
                    saleRequest.getProduct(),
                    true);
        } else {
            return new OrderDto(saleRequest.getUser(),
                    saleRequest.getProduct(),
                    false);
        }
    }

}
