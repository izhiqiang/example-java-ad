package com.github.ad.dao;

import com.github.ad.entity.Creative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreativeRepository extends JpaRepository<Creative, Long> {
}
