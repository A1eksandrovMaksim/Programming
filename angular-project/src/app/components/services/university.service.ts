import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { IUniversity } from "../models/university";

@Injectable({
    providedIn: 'root'
})

export class UniversityService{
    constructor(private http:HttpClient){
    }

    getAll(): Observable<IUniversity[]>{
        return this.http.get<IUniversity[]>('http://universities.hipolabs.com/search')
    }

    getAllWithFilter(state:string, name:string): Observable<IUniversity[]>{
        return this.http.get<IUniversity[]>('http://universities.hipolabs.com/search', {
            params: new HttpParams().append('country', state).append('name', name)
        })
    }
}