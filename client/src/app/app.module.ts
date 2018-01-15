import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'
import { HttpModule } from '@angular/http'
import { RouterModule, Routes } from '@angular/router'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { MultiselectDropdownModule } from 'angular-2-dropdown-multiselect'

import { AppComponent } from './app.component'
import { NavbarComponent } from './components/navbar/navbar.component'
import { UsersComponent } from './components/users/users.component'
import { FooterComponent } from './components/footer/footer.component'
import { UserViewComponent } from './components/user-view/user-view.component'
import { UserFormComponent } from './components/user-form/user-form.component'
import { AboutComponent } from './components/about/about.component'

import { HttpClientModule } from '@angular/common/http'
import { routing, appRoutingProviders } from './app.routing'
import { TransRolePipe } from './pipes/trans-role.pipe'

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    UsersComponent,
    FooterComponent,
    UserViewComponent,
    UserFormComponent,
    AboutComponent,
    TransRolePipe
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    routing,
    MultiselectDropdownModule
  ],
  providers: [ appRoutingProviders ],
  bootstrap: [ AppComponent ]
})
export class AppModule {}
