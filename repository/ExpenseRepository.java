package com.TeknikPemrograman2023.springbootmongodb221524002Week7.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.TeknikPemrograman2023.springbootmongodb221524002Week7.model.Expense;
import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
