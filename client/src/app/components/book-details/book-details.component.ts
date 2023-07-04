// import { Component, OnDestroy, OnInit } from '@angular/core';
// import { ActivatedRoute, Router } from '@angular/router';
// import { Subscription } from 'rxjs';
// import { BookChar } from 'src/app/models/book-char';
// import { BookReview } from 'src/app/models/book-review';
// import { BookSpringbootService } from 'src/app/services/book-springboot.service';

// @Component({
//   selector: 'app-book-details',
//   templateUrl: './book-details.component.html',
//   styleUrls: ['./book-details.component.css']
// })
// export class BookDetailsComponent implements OnInit, OnDestroy {

// aRouteSub$! :Subscription
// search! :string
// bookId! : number
// bookList: BookChar[] = []
// reviewList: BookReview[] = []

// constructor(private activateRoute: ActivatedRoute,
//             private springBoot: BookSpringbootService,
//             private router: Router) { }
            

// ngOnDestroy(): void {
//   this.aRouteSub$.unsubscribe()
// }

// async ngOnInit() {
//   //get path variable
//   //this.bookId = this.activatedRoute.snapshot.params['bookId']
//   this.aRouteSub$ = this.activateRoute.params.subscribe(
//     (qParams)=> {
//       this.search = qParams['query']
//     }
//   )
//   //console.debug(this.bookId)
//   //get book promise
//   await this.springBoot.getBookById(this.bookId)
//     .then(v => this.book = v)
//     .catch(err => console.warn(err))
//   console.info("book > " + this.bookId)
//   // await this.springBoot.getBookById(this.bookId)
//   //   .then(v => this.book = v)
//   //   .catch(err => console.warn(err))
//   // console.info("book > " + this.book)

//   // get api review
// //   await this.springBoot.getReviews(this.bookId)
// //     .then(v => this.reviewList = v)
// //   console.info("reviews >" this.reviewList)
// }


// }

import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookChar } from 'src/app/models/book-char';
import { BookReview } from 'src/app/models/book-review';
import { BookSpringbootService } from 'src/app/services/book-springboot.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit, OnDestroy {
  aRouteSub$: Subscription | undefined;
  search: string = '';
  bookId: number | undefined;
  book: BookChar | undefined;
  reviewList: BookReview[] = [];

  constructor(
    private activateRoute: ActivatedRoute,
    private springBoot: BookSpringbootService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aRouteSub$ = this.activateRoute.params.subscribe((qParams) => {
      this.search = qParams['query'] || '';
      console.debug("Getting details for book with ID: " + this.bookId);
      this.getBookDetails();
      this.getBookReviews();
    });
  }

  ngOnDestroy(): void {
    this.aRouteSub$?.unsubscribe();
  }

  async getBookDetails(): Promise<void> {
    try {
      const bookId = parseInt(this.search, 10);
      if (isNaN(bookId)) {
        throw new Error('Invalid book ID');
      }
      this.bookId = bookId;
      // this.book = await this.springBoot.getBookById(bookId);
      console.debug("Book details:", this.book);
    } catch (error) {
      console.error(error);
    }
  }

  async getBookReviews(): Promise<void> {
    try {
      if (this.bookId) {
        // this.reviewList = await this.springBoot.getReviews();
        console.debug("Reviews:", this.reviewList);
      }
    } catch (error) {
      console.error(error);
    }
  }
}
