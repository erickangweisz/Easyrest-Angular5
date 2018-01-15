import { Component, OnInit } from '@angular/core'
import { UserService } from '../../services/user/user.service'
import { NgForm } from '@angular/forms'
import { ActivatedRoute, Params } from '@angular/router'
import { User } from '../../models/user'
import { Router } from '@angular/router'
import { UserRoleService } from '../../services/user-role/user-role.service'

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css'],
  providers: [ UserService, UserRoleService ]
})
export class UserViewComponent implements OnInit {

  public title: string
  public id: number
  public user: any

  public roles: any = []
  public rolesid: any = []

  constructor(private _userService: UserService,
              private _userRoleService: UserRoleService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) {
    this.title = 'User view'
  }

  ngOnInit() {
    // subscribe to router event
    this._activatedRoute.params.subscribe((params: Params) => {
      this.id = params['id']
    })
    this.getUser(this.id)
    this.getRolesByUserId(this.id)
  }

  getUser(id: number) {
    this._userService.getUser(this.id).subscribe(user => {
      this.user = user
    })
  }

  getRolesByUserId(userid: number) {
    this._userRoleService.getRolesByUserId(userid).subscribe(roles => {
      this.roles = roles
      for (let i=0; i<this.roles.length; i++) {
        console.log(roles[i]['roleid'])
        this.rolesid = roles[i]['roleid']
      }
    })
  }

}
