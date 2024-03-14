package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.models.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void priceCalculator() {
        Book book = new Book(1L, "El senor de los anillos", "Author",1000, 49.99, LocalDate.now(), true);
        double price = BookPriceCalculator.priceCalculator(book);

        //Test the behaviour
        System.out.println(price);

        //assertions
        assertTrue(price > 0);
        assertEquals(57.980000000000004, price);
    }
}