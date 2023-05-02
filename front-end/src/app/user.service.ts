import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private http: HttpClient) { }

  public login(logindata: any) {

    return this.http.post("http://localhost:8080/login", logindata);
  }
}