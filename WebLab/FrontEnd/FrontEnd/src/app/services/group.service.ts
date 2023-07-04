import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { enviroment } from 'src/environment/enviroment';
import { IGroup } from '../models/group';
import { AuthenticationService } from './authentication.service';
import { ErrorService } from './error.service';

@Injectable({
  providedIn: 'root'
})
export class GroupService{
  serverpath = enviroment.serverpath + '/groups'

  constructor(private http: HttpClient,
    private auth: AuthenticationService,
    private errorService: ErrorService) { }

  getAll():Observable<IGroup[]>{
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    console.log(username+':'+password)
    return this.http.get<IGroup[]>(this.serverpath + '/',{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  add(group: IGroup):Observable<IGroup>{
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.post<IGroup>(this.serverpath + '/',group,{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  update(group: IGroup, groupId: number):Observable<IGroup>{
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.put<IGroup>(this.serverpath + '/'+ groupId.toString(),group,{
      headers: new HttpHeaders()
      .set('Authorization', 'Basic '+ window.btoa(username+':'+password))
    }).pipe(
      catchError(this.errorHandler.bind(this))
    )
  }

  delete(groupId: number){
    let username = this.auth.getUsername()
    let password = this.auth.getPassword()
    return this.http.delete(this.serverpath + '/'+ groupId.toString(),{
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
