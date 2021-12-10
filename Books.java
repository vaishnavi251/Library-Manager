package com.company;
import java.util.*;

public class Books {
    String bookname;
    String authorname;
    int ISBNno;
    String publication;
    int isbnSearch;
}

class Library extends Books{
    static Scanner sc = new Scanner(System.in);


    void Accept_Book_Details(){

        System.out.println("enter the name of book : ");
        bookname = sc.next();

        System.out.println("enter the name of the author of book : ");
        authorname = sc.next();

        System.out.println("enter ISBN no. of the book : ");
        ISBNno = sc.nextInt();

        System.out.println("enter the name of publication : ");
        publication = sc.next();

    }

    void Display_Book_Details(){
        System.out.println("Book name : "+bookname+"\nAuthor name : "+authorname+"\nISBN No. : "+ISBNno+"\nPublication name : "+publication);
    }

    void ISBNsearch(){
        //int isbnSearch;
        System.out.println("enter the ISBN no. of book to be searched : ");
        isbnSearch = sc.nextInt();
    }

    void check(){
        if(isbnSearch == ISBNno){
            System.out.println("book is found");
            Display_Book_Details();
        }
        
    }
}

