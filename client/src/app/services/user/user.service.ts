import { Injectable } from '@angular/core'
import { User } from '../../models/user'
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs/Observable'
import { GLOBAL } from '../global'

@Injectable()
export class UserService {

  private url: string

  constructor(public _http: HttpClient) {
    this.url = GLOBAL.url
  }

  public getUsers(): Observable<any> {
    return this._http.get(this.url + 'userservice/users')
  }

  public getUser(id: number): Observable<any> {
    return this._http.get(this.url + 'userservice/user/' + id)
  }

  public createUser(user: User, roleid: any): Observable<any> {
    let headers = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    let httpParams = new HttpParams()
        .append('name', user.name)
        .append('roleid', roleid)
    
    return this._http.post(this.url + 'userservice/user', httpParams, { headers: headers })
  }

  public deleteUser(id: number): Observable<any> {
    let headers = new HttpHeaders().set('Content-Type', 'application/json')
    return this._http.delete(this.url + 'userservice/user/' + id, { headers: headers })
  }

}
