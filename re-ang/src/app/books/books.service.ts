import { Injectable } from '@angular/core';
import { Book } from './book.model';

// this decorator enables us to inject BooksService into other classes
@Injectable({
  providedIn: 'root'
})
export class BooksService {

  allBooks: Book[] = [
    {
      id: 101,
      bookTitle: 'Harry Potter and the Order of Phoenix',
      bookAuthor: 'J.K.Rowling',
      bookGenre: 'Fiction',
      bookCost: 100,
      bookImage: 'https://images.unsplash.com/photo-1626618012641-bfbca5a31239?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=464&q=80'
    },
    {
      id: 102,
      bookTitle: 'Harry Potter and the Sorcerers Stone',
      bookAuthor: 'J.K.Rowling',
      bookGenre: 'Fiction',
      bookCost: 150,
      bookImage: 'https://images.unsplash.com/photo-1600189261867-30e5ffe7b8da?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80'
    },
    {
      id: 103,
      bookTitle: 'Harry Potter and the Deathly Hallows',
      bookAuthor: 'J.K.Rowling',
      bookGenre: 'Fiction',
      bookCost: 170,
      bookImage: 'https://images.unsplash.com/photo-1611676279444-5577698aa13c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80'
    }
  ];
  constructor() { }

  getAllBooks(): Book[]{
    return this.allBooks;
  }

  deleteBook(bookId: number): Book[]{
    // lets remove the book with the book id in the array
    this.allBooks = this.allBooks.filter((book)=>book.id!=bookId) ;
    return this.allBooks;
  }

  addBook(newBook: Book): Book[]{
    // generating the primary key of the new book
    let generatedBookId: number = this.allBooks[this.allBooks.length-1].id + 1;

    // assign the generated book id to the id on the new book
    newBook.id = generatedBookId;

    // add the new book to the array
    this.allBooks.push(newBook);

    return this.allBooks;
  }

  getABook(bookId: any): Book{
    let sendBook: Book = {
      id: 0,
      bookTitle: '',
      bookAuthor: '',
      bookGenre: '',
      bookCost: 0,
      bookImage: ''
    }
    for(let i=0; i<this.allBooks.length;i++){
      if(this.allBooks[i].id == bookId){
        sendBook = this.allBooks[i];
      }
    }
    return sendBook;
  }

  updateBook(sentBook: Book): void{
    for(let i=0; i<this.allBooks.length;i++){
      if(this.allBooks[i].id == sentBook.id){
        this.allBooks[i] = sentBook;
      }
    }
  }
}
