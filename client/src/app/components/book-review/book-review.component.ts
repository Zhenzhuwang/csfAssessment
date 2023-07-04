import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookReview } from 'src/app/models/book-review';
import { BookSpringbootService } from 'src/app/services/book-springboot.service';

@Component({
  selector: 'app-book-review',
  templateUrl: './book-review.component.html',
  styleUrls: ['./book-review.component.css']
})
export class BookReviewComponent implements OnInit, OnDestroy{

  queryParams$!: Subscription
  searchTerm!: string
  reviewList: BookReview[] = []

  constructor(
    private activatedRoute: ActivatedRoute,
    private springboot: BookSpringbootService
  ) { }

  ngOnDestroy(): void {
    this.queryParams$.unsubscribe()
  }

  async ngOnInit() {
    this.queryParams$ = this.activatedRoute.queryParams.subscribe(
      (qParams) => {
        this.searchTerm = qParams['query']
        console.debug("Getting results for.. " + this.searchTerm
        )
      }
    )
    
    await this.springboot.search(this.searchTerm)
      .then(response => {
        this.reviewList = response
        console.debug(response)
      })
  }

}
