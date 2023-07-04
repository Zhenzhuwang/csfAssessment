import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BookChar } from 'src/app/models/book-char';
import { BookSpringbootService } from 'src/app/services/book-springboot.service';

@Component({
  selector: 'app-list-of-books',
  templateUrl: './list-of-books.component.html',
  styleUrls: ['./list-of-books.component.css']
})
export class ListOfBooksComponent implements OnInit, OnDestroy {
  aRouteSub$: Subscription | undefined;
  search: string = '';
  limit: number = 10;
  offset: number = 0;
  bookList: BookChar[] = [];

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private springBoot: BookSpringbootService
  ) {}

  ngOnInit(): void {
    this.aRouteSub$ = this.activatedRoute.queryParams.subscribe((qParams) => {
      this.search = qParams['query'] || '';
      console.debug("Getting results for.. " + this.search);
      this.getBookList();
    });
  }

  ngOnDestroy(): void {
    this.aRouteSub$?.unsubscribe();
  }

  async getBookList(): Promise<void> {
    try {
      const response = await this.springBoot.search(this.search);
      // this.bookList = response;
      console.debug(response);
    } catch (error) {
      console.error(error);
    }
  }

  previous(): void {
    if (this.offset >= this.limit) {
      this.offset -= this.limit;
    }
    console.debug("new offset > " + this.offset);
    this.getBookList();
  }

  next(): void {
    this.offset += this.limit;
    console.debug("new offset >" + this.offset);
    this.getBookList();
  }
}
