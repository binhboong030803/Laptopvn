package com.project.shopapp.repositories;


import com.project.shopapp.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<User> findByPhoneNumber(String phoneNumber);

    @Query(
            value = "SELECT * FROM users u " +
                    "JOIN roles r ON u.role_id = r.id " +
                    "WHERE u.active = true " +
                    "AND (:keyword IS NULL OR :keyword = '' OR " +
                    "u.full_name ILIKE CONCAT('%', :keyword, '%') OR " +
                    "u.address ILIKE CONCAT('%', :keyword, '%') OR " +
                    "u.phone_number ILIKE CONCAT('%', :keyword, '%')) " +
                    "AND LOWER(r.name) = 'user'",
            countQuery = "SELECT COUNT(*) FROM users u JOIN roles r ON u.role_id = r.id " +
                    "WHERE u.active = true " +
                    "AND (:keyword IS NULL OR :keyword = '' OR " +
                    "u.full_name ILIKE CONCAT('%', :keyword, '%') OR " +
                    "u.address ILIKE CONCAT('%', :keyword, '%') OR " +
                    "u.phone_number ILIKE CONCAT('%', :keyword, '%')) " +
                    "AND LOWER(r.name) = 'user'",
            nativeQuery = true
    )
    Page<User> findAll(@Param("keyword") String keyword, Pageable pageable);

}
