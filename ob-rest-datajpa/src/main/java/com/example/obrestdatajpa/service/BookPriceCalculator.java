package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.models.Book;

public class BookPriceCalculator {

    public static double priceCalculator(Book book){

        double price = book.getPrice();
        if(book.getPages() > 300){
            price +=5;
        }

        //Ship
        price+=2.99;
        return price;

    }
}
