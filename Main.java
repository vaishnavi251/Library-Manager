package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int n,ch;
        System.out.println("\n\tEnter number of books :");
        n=sc.nextInt();

        Library ob = new Library(n);
        ob.Accept();
        do{
            System.out.println("\n\t M E N U :");
            System.out.println("\n\t 1.Display details: ");
            System.out.println("\n\t 2.Add details: ");
            System.out.println("\n\t 3.Search a book by ISBN No.: ");
            System.out.println("\n\t 4.Search a book by Author: ");
            System.out.println("\n\t 5.Sort books by ISBN No.: ");
            System.out.println("\n\t 0.Exit");
            System.out.println("\n\t Enter your choice: ");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:

                    break;
                case 2:
                    ob.Display();
                    break;
                case 3:
                    ob.sort_books();
                    ob.search_ISBN();
                    break;
                case 4:
                    ob.search_Author();
                    break;
                case 5:
                    ob.sort_books();
                    ob.Display();
                    break;
                case 6:
                    System.out.println("\n\t Thank you...");
                    break;
                default:
                    System.out.println("\n\t Please Re enter");
            }
        }while (ch!=6);
    }
}

class Book{
    int ISBN;
    String bookname, authorname;
}
class Library{
    Scanner sc=new Scanner(System.in);
    int n;
    Book theBooks[] = new Book[n];// Array that stores 'book' Objects.
    Library(int n)//Constructor of class Library
    {
        this.n=n;
        theBooks=new Book[n];
    }
    void Accept()//Function to accept all the inputs
    {
        int i;
        System.out.println("\n\tEnter Details:");
        for(i=0;i<this.n;i++)
        {

            System.out.println("\n\tBook "+(i+1)+":");
            this.theBooks[i]=new Book();
            System.out.println("\n\t Enter Book Name: ");
            this.theBooks[i].bookname=sc.next();
            System.out.println("\n\t Enter Author Name: ");
            this.theBooks[i].authorname=sc.next();
            System.out.println("\n\t Enter ISBN Number: ");
            this.theBooks[i].ISBN=sc.nextInt();

        }

    }
    void Display()//Function to display all the details
    {
        int i;
        for(i=0;i<this.n;i++)
        {
            System.out.println("\n\tBook "+(i+1)+":");
            System.out.println("\n\t Book Name: " +this.theBooks[i].bookname);
            System.out.println("\n\t Author Name: "+this.theBooks[i].authorname);
            System.out.println("\n\t ISBN No: "+this.theBooks[i].ISBN);
        }
    }
    void search_Author()//Search book by author
    {//Linnear search
        int i,flag;
        flag=0;
        String a;
        System.out.println("\n\t Enter the Author Name to be searched: ");//Input name of author
        a=sc.next();
        for(i=0;i<n;i++)
        {
            if(this.theBooks[i].authorname.equals(a))//check condition if author name matches to ith entry of array
            {
                System.out.println("\n\t found at "+(i+1)+" Position");//Display position
                display(theBooks[i]);//Printing details
                flag++;
            }
        }
        if(flag==0)
            System.out.println("\n\tNot Found at library");
        else
            System.out.println("\n\t Found at the library");

    }

    void sort_books()
    {//Bubble Sort technique to sort array based on ISBN No.
        System.out.println("Array elements after sorting:");
        for (int i = 0; i < theBooks.length; i++)
        {
            for (int j = i + 1; j < theBooks.length; j++)
            {
                int temp = 0;
                if (this.theBooks[i].ISBN > this.theBooks[j].ISBN)
                {
                    temp = this.theBooks[i].ISBN;
                    this.theBooks[i].ISBN = this.theBooks[j].ISBN;
                    this.theBooks[j].ISBN = temp;
                }
            }
        }

    }
    void search_ISBN()
    {//Binnary Search technique
        System.out.println("\n\tEnter ISBN of book that is to be searched: ");
        int key = sc.nextInt();
        int l=0;// l=lower end
        int h =n-1;//h=higher end
        while(l<=h){
            int mid = (l+h)/2;//mid =average of higher and lower end
            if (theBooks[mid].ISBN==key)
            {
                display(theBooks[mid]);
                break;
            }
            else if (key<theBooks[mid].ISBN)
                h = mid-1;
            else l = mid+1;


        }
    }
    void display(Book book)//Function to display specific book details used for search
    {
        System.out.println("\n\t Book name: "+book.bookname);
        System.out.println("\n\t Author name: "+book.authorname);
        System.out.println("\n\t ISBN No.: "+book.ISBN);

    }
}