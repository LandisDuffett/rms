import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditBookComponent } from './books/edit-book/edit-book.component';
import { EditHttpBookComponent } from './books/edit-http-book/edit-http-book.component';
import { ViewBooksComponent } from './books/view-books/view-books.component';
import { ViewHttpBooksComponent } from './books/view-http-books/view-http-books.component';
import { ListColorsComponent } from './colors/list-colors/list-colors.component';
import { CounterComponent } from './counter/counter.component';
import { MyInfoComponent } from './employees/my-info/my-info.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { ListFruitsComponent } from './list-fruits/list-fruits.component';
import { MyRequestsComponent } from './requests/my-requests/my-requests.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { AuthenticationGuard } from './users/authentication.guard';
import { LoginComponent } from './users/login/login.component';
import { LogoutComponent } from './users/logout/logout.component';

// specify the route paths of the components here
const routes: Routes = [
  { path: "counter", component: CounterComponent, canActivate:[AuthenticationGuard] },
  { path: "list-fruits", component: ListFruitsComponent, canActivate:[AuthenticationGuard] },
  { path: "view-books", component: ViewBooksComponent, canActivate:[AuthenticationGuard] },
  { path: "edit-book/:bid", component: EditBookComponent, canActivate:[AuthenticationGuard] },
  { path: "view-http-books", component: ViewHttpBooksComponent},
  { path: "edit-http-book/:bid", component: EditHttpBookComponent, canActivate:[AuthenticationGuard] },
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent },
  { path: "colors", component: ListColorsComponent },
  { path: "view-requests", component: ViewRequestsComponent, canActivate:[AuthenticationGuard]},
  { path: "view-employees", component: ViewEmployeesComponent, canActivate:[AuthenticationGuard]},
  { path: "edit-request", component: ViewRequestsComponent, canActivate:[AuthenticationGuard]},
  { path: "my-requests", component: MyRequestsComponent, canActivate:[AuthenticationGuard]},
  { path: "my-info", component: MyInfoComponent, canActivate:[AuthenticationGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
