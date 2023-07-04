import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookChar } from '../models/book-char';
import { Observable, lastValueFrom } from 'rxjs';
import { BookReview } from '../models/book-review';



const SPRINGBOOT_URL = 'api/books'


@Injectable({
  providedIn: 'root'
})
export class BookSpringbootService {

  
//   constructor(private http: HttpClient) { }

//   search(bookTitle: string): Promise<BookChar[]>{
//     let params = new HttpParams()
//     .set("query", bookTitle)

//     //sent to springboot
//     return lastValueFrom(
//       this.http.get<BookChar[]>("/api/books", {params})
//     )
//   }


//   getBookList(search: string, limit: number, offset: number):Promise<BookChar[]>{
//     let params = new HttpParams()
//       .set('search', search)
//       .set('limit', limit)
//       .set('offset', offset)
//       //send for springboot
//       return lastValueFrom(
//         this.http.get<BookChar[]>(SPRINGBOOT_URL, {params})
//       )
//   }

//   getBookById(book_id: number): Promise<BookChar>{
//     const completeUrl = SPRINGBOOT_URL + "/" + book_id
//     console.debug(completeUrl)
//     return lastValueFrom(
//       this.http.get<BookChar>(completeUrl)
//     )
//   }

//   getReviews(){

//   }
constructor(private http: HttpClient) { }

private baseUrl = 'http://localhost:8080/api'; // Update with your API endpoint URL

search(query: string): Observable<BookChar[]> {
  const params = new HttpParams().set('query', query);
  return this.http.get<BookChar[]>(`${this.baseUrl}/search`, { params });
}

getBookById(bookId: number): Observable<BookChar> {
  return this.http.get<BookChar>(`${this.baseUrl}/books/${bookId}`);
}

getReviews(bookId: number): Observable<BookReview[]> {
  return this.http.get<BookReview[]>(`${this.baseUrl}/books/${bookId}/reviews`);
}
}
 
