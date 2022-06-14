import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book.model';
import { BooksService } from '../books.service';

@Component({
  selector: 'view-books',
  templateUrl: './view-books.component.html',
  styleUrls: ['./view-books.component.css']
})
export class ViewBooksComponent implements OnInit {

// properties/fields are declared here and initialized in the constructor
// ViewBookComponent is dependent on BooksService class
// we can use DI(Dependency Injection) to inject BooksService into this component

//bookService: BooksService;
currentAllBooks: Book[];

shouldDisplay: boolean = false;

// here we are creating a property testBook of type Book
// this enforces the Book structure for the testBook property
// BookPojo pojo = new BookPojo();
// we will not be using testBook in the component
testBook: Book = {
    id: 101,
    bookTitle: 'Harry Potter and the Order of Phoenix',
    bookAuthor: 'J.K.Rowling',
    bookGenre: 'Fiction',
    bookCost: 100,
    bookImage: 'https://images.unsplash.com/photo-1626618012641-bfbca5a31239?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80'
};

newBook: Book = {
  id: 0,
  bookTitle: '',
  bookAuthor: '',
  bookGenre: '',
  bookCost: 0,
  bookImage: ''
};

// we have moved the book data to the service class
// allBooks: Book[] = [
//   {
//     id: 101,
//     bookTitle: 'Harry Potter and the Order of Phoenix',
//     bookAuthor: 'J.K.Rowling',
//     bookGenre: 'Fiction',
//     bookCost: 100,
//     bookImage: 'https://images.unsplash.com/photo-1626618012641-bfbca5a31239?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80'
//   },
//   {
//     id: 102,
//     bookTitle: 'Harry Potter and the Sorcerers Stone',
//     bookAuthor: 'J.K.Rowling',
//     bookGenre: 'Fiction',
//     bookCost: 150,
//     bookImage: 'https://images.unsplash.com/photo-1600189261867-30e5ffe7b8da?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80'
//   },
//   {
//     id: 103,
//     bookTitle: 'Harry Potter and the Deathly Hallows',
//     bookAuthor: 'J.K.Rowling',
//     bookGenre: 'Fiction',
//     bookCost: 170,
//     bookImage: 'https://images.unsplash.com/photo-1611676279444-5577698aa13c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80'
//   }
// ];

// here we are injecting(DI) BooksService in to this component through the constructor
// private says that bookService must become a field/property of the component
    // otherwise bookService will be treated a local variable to the constructor
        // and if it is local it cannot be used outside of the constructor
  constructor(private bookService: BooksService, private router: Router) { 
    this.currentAllBooks = [];
    //this.bookService = new BooksService();
  }

  ngOnInit(): void {
    this.currentAllBooks = this.bookService.getAllBooks();
  }

  deleteBook(bookId: number){
    this.currentAllBooks = this.bookService.deleteBook(bookId);
  }

  goToEditBook(bookId: number){
    // here we have to navigate to EditBookComponent whose route path is edit-book
    // for this we need to use Router api
    // we can inject Router in the component's constructor and use it here
    this.router.navigate(['edit-book',bookId]); // sending incomming bookId as a route parameter
  }

  displayBookForm(){
    if(this.shouldDisplay){
      this.shouldDisplay = false;
    }else{
      this.shouldDisplay = true;
    }
  }

  addANewBook(){
    // copying the property newBook object in to a local localNewBook object
    let localNewBook: Book = {
      id: 0,
      bookTitle: this.newBook.bookTitle,
      bookAuthor: this.newBook.bookAuthor,
      bookGenre: this.newBook.bookGenre,
      bookCost: this.newBook.bookCost,
      bookImage: this.newBook.bookImage
    }

    // clear the form after the data is copied into a local Book object
    this.newBook = {
      id: 0,
      bookTitle: '',
      bookAuthor: '',
      bookGenre: '',
      bookCost: 0,
      bookImage: ''
    };

    // hiding the form
    this.shouldDisplay = false;

    // sending the local object to service layer to add it to the array
    this.currentAllBooks = this.bookService.addBook(localNewBook);
  }
}
