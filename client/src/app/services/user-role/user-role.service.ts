import { Injectable } from '@angular/core'
import { UserRole } from '../../models/userrole'
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs/Observable'
import { GLOBAL } from '../global'

@Injectable()
export class UserRoleService {

  private url: string

  constructor(public _http: HttpClient) {
    this.url = GLOBAL.url
  }

  public getRolesByUserId(userid: number): Observable<any> {
    return this._http.get(this.url + 'userroleservice/rolesbyuserid/' + userid)
  }

}
