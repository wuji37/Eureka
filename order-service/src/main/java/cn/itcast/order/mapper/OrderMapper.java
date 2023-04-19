package cn.itcast.order.mapper;

import org.apache.ibatis.annotations.Select;
import cn.itcast.order.pojo.Order;

public interface OrderMapper {

    @Select("select * from tb_order where id=#{id}")
    Order findById(Long id);
}
