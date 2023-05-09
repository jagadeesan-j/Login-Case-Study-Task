import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200'
  })
};
@Injectable({
  providedIn: 'root'
})
export class UserService {
  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  )
  constructor(private http: HttpClient) { }
  public login(logindata: any) {
    return this.http.post("http://localhost:9090/login", logindata, { headers: this.requestHeader });
  }
  public save(data: any) {
    return this.http.post("http://localhost:9090/register", data, { headers: this.requestHeader });
  }
}
