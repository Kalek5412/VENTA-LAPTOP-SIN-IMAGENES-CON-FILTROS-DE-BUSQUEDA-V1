package com.laptop.backend.repository;

import com.laptop.backend.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long>, JpaSpecificationExecutor<Laptop> {
}
