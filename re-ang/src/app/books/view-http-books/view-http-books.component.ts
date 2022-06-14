import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book.model';
import { BooksHttpService } from '../books-http.service';

@Component({
  selector: 'app-view-http-books',
  templateUrl: './view-http-books.component.html',
  styleUrls: ['./view-http-books.component.css']
})
export class ViewHttpBooksComponent implements OnInit {

  currentAllBooks: Book[];

  shouldDisplay: boolean = false;
  
  newBook: Book = {
    id: 0,
    bookTitle: '',
    bookAuthor: '',
    bookGenre: '',
    bookCost: 0,
    bookImage: ''
  };
  
  constructor(private bookHttpService: BooksHttpService, 
              private router: Router) { 
    this.currentAllBooks = [];
  }

  ngOnInit(): void {
    // moved to a seperate function loadData
    // this.bookHttpService.getAllBooks().subscribe(response => {
    //   console.log(response);
    //   this.currentAllBooks = response;
    // })
    this.loadData();
  }

  loadData(){
    this.bookHttpService.getAllBooks().subscribe(response => {
      console.log(response);
      this.currentAllBooks = response;
    })
  }

  deleteBook(bookId: number){
   this.bookHttpService.deleteBook(bookId).subscribe((response)=>{
    // the response is not of much use here
    console.log(response);
    // we need a fresh fetch of all books from the database
    this.loadData();
   });
  }

  goToEditBook(bookId: number){
    // here we have to navigate to EditBookComponent whose route path is edit-book
    // for this we need to use Router api
    // we can inject Router in the component's constructor and use it here
    this.router.navigate(['edit-http-book',bookId]); // sending incomming bookId as a route parameter
  }

  displayBookForm(){
    if(this.shouldDisplay){
      this.shouldDisplay = false;
    }else{
      this.shouldDisplay = true;
    }
  }

  addANewBook(){
    this.bookHttpService.addBook(this.newBook).subscribe((response)=>{
      //this response is not of much use
      console.log(response);
       // we need a fresh fetch of all books from the database
      this.loadData();

      // clear the Add Form
      this.newBook = {
        id: 0,
        bookTitle: '',
        bookAuthor: '',
        bookGenre: '',
        bookCost: 0,
        bookImage: ''
      };

      // toggle/hide the Add Form
      this.shouldDisplay = false;
    })
  }

}
