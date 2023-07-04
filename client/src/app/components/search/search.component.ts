import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookSpringbootService } from 'src/app/services/book-springboot.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  ALPHABETS: string[] = [
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
  ]

  NUMBERS: string[] = [
    '0','1','2','3','4','5','6','7','8','9'
  ]

  searchForm! : FormGroup
  SearchValue!: string;
  limit: number = 10;
  offset: number = 0

  constructor(private fb : FormBuilder,
              private router : Router,
              private springBoot: BookSpringbootService) { }

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      searchForm: this.fb.control<string>('', Validators.required)
    })
  }

  search() {
    const bookTitle = this.searchForm.value['bookTitle']
    //console.error(searchTerm)
    this.router.navigate(['/books'],{
      queryParams: {query: bookTitle}
    }
  )
  }

  books(value: string){
    console.log(value);
  // this.springBoot.getBookList(value);
  this.router.navigate(['/books']);
  }
}
