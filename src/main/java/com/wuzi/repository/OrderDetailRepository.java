package com.wuzi.repository;

import com.wuzi.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 17:03
 * @description:
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String id);
}
