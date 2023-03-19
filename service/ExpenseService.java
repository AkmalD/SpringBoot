package com.TeknikPemrograman2023.springbootmongodb221524002Week7.service;

import com.TeknikPemrograman2023.springbootmongodb221524002Week7.model.Expense;
import com.TeknikPemrograman2023.springbootmongodb221524002Week7.repository.ExpenseRepository;

import java.util.List;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Exp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by ID %s", expense.getId())));

        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Expense By Name %s", name)));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
