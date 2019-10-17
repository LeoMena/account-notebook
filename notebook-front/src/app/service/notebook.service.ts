import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { throwError, Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Transaction } from '../model/Transaction.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NotebookService {

  apiUrl: String = environment.apiUrl;

  constructor(private http: HttpClient) { }

  private handleError(error: Response | HttpErrorResponse | any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }

  public getTransactions() {
    return this.http
    .get<Transaction[]>(this.apiUrl + '/transactions')
      .pipe(
        catchError(this.handleError)
      );
  }
}
