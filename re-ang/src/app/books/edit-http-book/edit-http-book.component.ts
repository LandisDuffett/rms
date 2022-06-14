import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book.model';
import { BooksHttpService } from '../books-http.service';

@Component({
  selector: 'edit-http-book',
  templateUrl: './edit-http-book.component.html',
  styleUrls: ['./edit-http-book.component.css']
})
export class EditHttpBookComponent implements OnInit {
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
              private bookHttpService: BooksHttpService,
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
    this.bookHttpService.getABook(bidParam).subscribe((response)=>{
      // we have to assign this response to updateBook object
      this.updateBook = response;
    })

  }

  updateBookInfo(){
    this.bookHttpService.updateBook(this.updateBook).subscribe((response)=>{
      this.router.navigate(['view-http-books']);
    })
  }

  logTheChanges(title: any){
    console.log(title);
  }

}
