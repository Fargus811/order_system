package com.itrex.ordersystem.repository;

import com.itrex.ordersystem.repository.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Long> {

}
