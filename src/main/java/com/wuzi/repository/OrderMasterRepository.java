package com.wuzi.repository;

import com.wuzi.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: sell
 * @author: HM
 * @create: 2018-03-28 17:08
 * @description:
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 查询所有的订单列表
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);




    /**
     * 根据支付状态来查询
     *
     * @param buyerOpenid
     * @param orderStatus
     * @param payStatus
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenidAndOrderStatusAndPayStatus(String buyerOpenid, Integer orderStatus, Integer payStatus, Pageable pageable);

    Page<OrderMaster> findByBuyerOpenidAndOrderStatusInAndPayStatus(String buyerOpenid, List<Integer> orderStatus, Integer payStatus, Pageable pageable);



    Page<OrderMaster> findByBuyerOpenidAndOrderStatus(String buyerOpenid, Integer orderStatus, Pageable pageable);
}
