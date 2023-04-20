package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import cn.itcast.order.pojo.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private UserClient userClient;
    @Autowired
    private RestTemplate restTemplate;


    public Order queryOrderById(Long orderId){
        Order order=orderMapper.findById(orderId);

        return order;
    }
    

    public Order queryOrderById_RestTemplate(Long orderId){
        Order order=orderMapper.findById(orderId);
        String url="http://localhost:8081/user/"+order.getUser_id();
        User user=restTemplate.getForObject(url,User.class);
        order.setUser(user);
        return order;
    }
}
