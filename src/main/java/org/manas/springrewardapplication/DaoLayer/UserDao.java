package org.manas.springrewardapplication.DaoLayer;

import org.manas.springrewardapplication.Model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public interface UserDao extends JpaRepository<User, UUID>{

     Optional<User> findByEmail(String email);
}
