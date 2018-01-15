import { Component, OnInit } from '@angular/core'
import { NgForm, FormControl, FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms'
import { UserService } from '../../services/user/user.service'
import { Router } from '@angular/router'
import { User } from '../../models/user'
import { UserRoleService } from '../../services/user-role/user-role.service'
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect'

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css'],
  providers: [ UserService, UserRoleService ]
})
export class UserFormComponent implements OnInit {

  public title: string
  public user: User

  public rolesModel: number[]
  public roles: IMultiSelectOption[]

  public roleNotSelected: boolean

  constructor(private _userService: UserService,
              private _router: Router) {
    this.title = 'user form'
    this.roleNotSelected = false
  }

  ngOnInit() {
    this.roles = [
      { id: 1, name: 'ADMIN' },
      { id: 2, name: 'USER' },
    ]
  }

  onSubmit(userform: NgForm) {
    if (this.rolesModel) {
      if (userform.valid) {
        this.user = new User(0, '')
        this.user.name = userform.value['name']
        this._userService.createUser(this.user, this.rolesModel).subscribe(
                                      res => { this._router.navigate(['/users']) }, 
                                      err => { console.log('error :: ' + err) })
      }
    } else {
      this.roleNotSelected = true
    }
  }

  // this method is called when there are changes in checkboxs
  onChange() {
    //console.log(this.rolesModel)
  }

}
