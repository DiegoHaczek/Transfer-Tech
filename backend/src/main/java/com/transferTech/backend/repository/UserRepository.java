package com.transferTech.backend.repository;

import com.transferTech.backend.entity.Role;
import com.transferTech.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String mail);
    boolean existsByEmail(String email);
    User findUserNameById (Long id);

    @Transactional
    @Query(value = """
              select u.name as user_name,a.id as account_id,a.qr,a.account_number,a.alias
              from accounts a
              inner join users u
              on a.user_id=u.id
              where user_id in (select contacts_id from users_contacts where user_id = :Id );
              """
            ,nativeQuery=true)
    List<Map<String,Object>> getAllContactsByUserId (@Param("Id") long userId);

    Optional<List<User>> findByRole(Role role);
}
