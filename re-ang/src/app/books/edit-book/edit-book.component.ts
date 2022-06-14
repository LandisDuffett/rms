import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book.model';
import { BooksService } from '../books.service';

@Component({
  selector: 'edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  updateBook: Book = {
    id: 0,
    bookTitle: '',
    bookAuthor: '',
    bookGenre: '',
    bookCost: 0,
    bookImage: ''
  }
  // injecting ActivatedRoute in the constructor to retreive a route parameter
  constructor(private activatedRoute: ActivatedRoute, 
              private bookService: BooksService,
              private router: Router) { }

  ngOnInit(): void {
    // this is the right place to retrieve the route parameter - bid from the route path
    // and send the retrived bid to service layer and fetch the book object

    // to retreive the route parameter we need the api ActivatedRoute
    // so ActivatedRoute has to be injected into this component
    let bidParam = this.activatedRoute.snapshot.paramMap.get('bid');
    console.log(bidParam);

    // now send the bidParam to the service layer and fetch the book object
    // and assign it to updateBook which is 2 way bound to the the template
    this.updateBook =  this.bookService.getABook(bidParam);

  }

  updateBookInfo(){
    // the property updateBook which is 2 way bound to the template has to sent 
    //to the service layer to be updated in the array
    this.bookService.updateBook(this.updateBook);

    // navigate to the view-book route using Router api
    this.router.navigate(['view-books']);
  }

  logTheChanges(title: any){
    console.log(title);
  }
}
