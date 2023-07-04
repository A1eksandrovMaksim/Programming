import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ErrorService } from './error.service';
import { AuthenticationService } from './authentication.service';
import { IStudent } from '../models/student';
import { Observable, catchError, throwError } from 'rxjs';
import { enviroment } from 'src/environment/enviroment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  serverpath = enviroment.serverpath + '/students'

  constructor(private http: HttpClient,
    private errorService: ErrorService,
    private auth: AuthenticationService) { }

  getAll():Observable<IStudent[]>{
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.get<IStudent[]>(this.serverpath + '/',{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  add(student: IStudent, groupId: number): Observable<IStudent>{
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.post<IStudent>(this.serverpath + '/' + groupId.toString(),student,{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  update(student: IStudent, studentId: number): Observable<IStudent>{
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.put<IStudent>(this.serverpath + '/' + studentId.toString(), student ,{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  delete(studentId: number){
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.delete(this.serverpath + '/' + studentId.toString() ,{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  private errorHandler(error: HttpErrorResponse){
    this.errorService.handel(error.message)
    return throwError(()=>error.message)
  }

}
