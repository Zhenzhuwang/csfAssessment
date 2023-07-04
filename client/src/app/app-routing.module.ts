import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchComponent } from './components/search/search.component';
import { BookDetailsComponent } from './components/book-details/book-details.component';
import { ListOfBooksComponent } from './components/list-of-books/list-of-books.component';
import { BookReviewComponent } from './components/book-review/book-review.component';

const routes: Routes = [
  {path: '', component: SearchComponent},
  {path: 'books', component:ListOfBooksComponent},
  {path: 'books/bookId', component:BookDetailsComponent},
  {path: 'review', component:BookReviewComponent},
  {path:'**', redirectTo:'/', pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
