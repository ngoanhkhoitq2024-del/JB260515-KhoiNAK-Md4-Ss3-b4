package re.edu.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.edu.orderservice.entity.Order;
import re.edu.orderservice.exception.ResourceNotFoundException;
import re.edu.orderservice.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public String healthCheck(){
        return "Order Service is Up";
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Không tìm thấy đơn hàng có id: " + id)
                );
    }
}
