import com.camargo.ecommerce.model.Order;
import com.camargo.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Pedido não encontrado com ID: " + id));
    }   
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
    public List<Order> findAll() {
        return orderRepository.findAll();
    }  
    
} 