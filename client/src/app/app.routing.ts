import { ModuleWithProviders } from '@angular/core'
import { Routes, RouterModule } from '@angular/router'

import { UserViewComponent } from './components/user-view/user-view.component'
import { UsersComponent } from './components/users/users.component'
import { UserFormComponent } from './components/user-form/user-form.component'
import { AboutComponent } from './components/about/about.component'

const appRoutes: Routes = [
    { path: 'user/:id', component: UserViewComponent, data: { title: 'User view' } },
    { path: 'users', component: UsersComponent, data: { title: 'User list' } },
    { path: 'user-form', component: UserFormComponent, data: { title: 'User form' } },
    { path: 'about', component: AboutComponent, data: { title: 'About' } },
    { path: '', redirectTo: '/users', pathMatch: 'full' },
    { path: '**', component: UsersComponent }
]

export const appRoutingProviders: any[] = []
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes)