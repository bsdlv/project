import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ApiService{
  constructor(private http:HttpClient){}

  getInfo(id:string):Observable<any>{
    const url=`https://api.worldbank.org/v2/country/${id}?format=json`;
    return this.http.get(url);
  }
}