import { Component, OnInit } from '@angular/core'
import { UserService } from '../../services/user/user.service'

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
  providers: [ UserService ]
})
export class UsersComponent implements OnInit {

  public title: string
  public users: any = []
  public roleName: any = []

  constructor(private _userService: UserService) {
    this.title = 'Users'
  }

  ngOnInit() {
    this.getUsers()
  }

  public getUsers() {
    this._userService.getUsers().subscribe(users => {
      this.users = users
    })
  }

  public deleteUser(id: number) {
    let confirmDelete: boolean
    confirmDelete = confirm('are you sure delete the user with id ' + id + '?')

    if (confirmDelete) {
      this._userService.deleteUser(id).subscribe(userDeleted => {
        location.reload()
      })
    }
  }

}
