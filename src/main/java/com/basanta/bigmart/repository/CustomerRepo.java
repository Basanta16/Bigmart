package com.basanta.bigmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basanta.bigmart.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
