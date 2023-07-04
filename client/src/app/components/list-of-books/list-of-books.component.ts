import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookChar } from 'src/app/models/book-char';
import { BookSpringbootService } from 'src/app/services/book-springboot.service';
import { BookReview } from 'src/app/models/book-review';

@Component({
  selector: 'app-list-of-books',
  templateUrl: './list-of-books.component.html',
  styleUrls: ['./list-of-books.component.css']
})
export class ListOfBooksComponent implements OnInit, OnDestroy {
  aRouteSub$!: Subscription
  search! : string
  limit: number = 10
  offset: number = 0
  bookList: BookChar[] = []

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private springBoot: BookSpringbootService){ }

  async ngOnInit(){
    this.aRouteSub$= this.activatedRoute.queryParams.subscribe(
      (qParams) => {
        this.search = qParams['query']
        console.debug("Getting results for.. " + this.search)
      }
    )
    await this.springBoot.search(this.search)
      .then(response => {
        this.bookList = response
        console.debug(response)
      })
    
    //get book list promise
    // await this.springBoot.getBookList(this.search,this.limit, this.offset).then(
    //   v => this.bookList =v )
    //   console.info(this.bookList)
    
  }

  ngOnDestroy(): void {
    this.aRouteSub$.unsubscribe();
  }

  previous() {
    if(this.offset >= this.limit){
      this.offset -= this.limit
    }
    console.debug("new offset > " + this.offset)
    //trigger service
    this.springBoot.getBookList(this.search,this.limit, this.offset).then(
      v => this.bookList = v
    )
    console.info(this.bookList)
  }

  next() {
    this.offset += this.limit
    console.debug("new offset >" + this.offset)
    //trigger service
    this.springBoot.getBookList(this.search,this.limit, this.offset).then(
      v => this.bookList = v
    )
    console.info(this.bookList)
  }

}



  