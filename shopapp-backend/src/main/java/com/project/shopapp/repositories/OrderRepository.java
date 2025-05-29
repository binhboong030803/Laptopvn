package com.project.shopapp.repositories;

import com.project.shopapp.models.Order;
import com.project.shopapp.models.OrderDetail;
import com.project.shopapp.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUserId(Long userId);

    @Query("SELECT o FROM Order o " +
            "WHERE o.isActive = true AND " +
            "(:keyword IS NULL OR :keyword = '' OR " +
            "LOWER(o.fullName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(o.address) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(o.note) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(o.email) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<Order> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
