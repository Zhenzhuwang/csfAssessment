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

aRouteSub$! :Subscription
search! :string
bookId! : number
bookList: BookChar[] = []
reviewList: BookReview[] = []

constructor(private activateRoute: ActivatedRoute,
            private springBoot: BookSpringbootService,
            private router: Router) { }
            

ngOnDestroy(): void {
  this.aRouteSub$.unsubscribe()
}

async ngOnInit() {
  //get path variable
  //this.bookId = this.activatedRoute.snapshot.params['bookId']
  this.aRouteSub$ = this.activateRoute.params.subscribe(
    (qParams)=> {
      this.search = qParams['query']
    }
  )
  //console.debug(this.bookId)
  //get book promise
  await this.springBoot.getBookById(this.bookId)
    .then(v => this.book = v)
    .catch(err => console.warn(err))
  console.info("book > " + this.bookId)
  // await this.springBoot.getBookById(this.bookId)
  //   .then(v => this.book = v)
  //   .catch(err => console.warn(err))
  // console.info("book > " + this.book)

  // get api review
//   await this.springBoot.getReviews(this.bookId)
//     .then(v => this.reviewList = v)
//   console.info("reviews >" this.reviewList)
}


}
