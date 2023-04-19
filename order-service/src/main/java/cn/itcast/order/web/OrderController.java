package cn.itcast.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")  //将get请求映射到对应的处理方法
    public Order queryOrderById(@PathVariable("orderId") Long orderId){
        //Order order=orderService.queryOrderById(orderId);
        Order order=orderService.queryOrderById_RestTemplate(orderId);
        return order;
    }
}
