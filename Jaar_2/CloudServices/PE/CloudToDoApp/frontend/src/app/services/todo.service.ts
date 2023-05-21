import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators'
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CarrouselItem } from '../CarrouselItem.model';
import { Todo } from '../models/todo.model';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) {

  }

  getTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(environment.apiurl + '/todo').pipe(
      catchError(this.handleError)
    );
  }

  addTodo(todo: Todo): Observable<any> {
    return this.http.post(environment.apiurl + '/todo', todo);
  }

  updateTodo(todo: Todo): Observable<any> {
    return this.http.put(environment.apiurl + '/todo/' + todo._id, todo);
  }

  deleteTodo(todo: Todo): Observable<any> {
    return this.http.delete(environment.apiurl + '/todo/' + todo._id);
  }

  getCarrouselItems(): Observable<CarrouselItem[]> {
    return this.http.get<CarrouselItem[]>(environment.apiurl + '/carrousel');
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      //console.error('An error occurred:', error.error);
      alert(`Error of type: ${error.name} with the message: ${error.message}`);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      //console.error(
      //  `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }


}
