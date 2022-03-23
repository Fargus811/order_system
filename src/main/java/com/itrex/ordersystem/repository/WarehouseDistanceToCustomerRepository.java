package com.itrex.ordersystem.repository;

import com.itrex.ordersystem.repository.entity.CustomerEntity;
import com.itrex.ordersystem.repository.entity.ProductEntity;
import com.itrex.ordersystem.repository.entity.WarehouseDistanceToCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseDistanceToCustomerRepository extends JpaRepository<WarehouseDistanceToCustomer, Long> {

    WarehouseDistanceToCustomer findFirstByCustomerAndWarehouseProductEntitiesOrderByDistanceAsc(CustomerEntity customer,
                                                                                                 ProductEntity productEntity);
}
