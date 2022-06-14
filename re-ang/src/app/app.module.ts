import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CounterComponent } from './counter/counter.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListFruitsComponent } from './list-fruits/list-fruits.component';
import { HeaderComponent } from './header/header.component';
import { ViewBooksComponent } from './books/view-books/view-books.component';
import { EditBookComponent } from './books/edit-book/edit-book.component';
import { HttpClientModule } from '@angular/common/http';
import { ViewHttpBooksComponent } from './books/view-http-books/view-http-books.component';
import { EditHttpBookComponent } from './books/edit-http-book/edit-http-book.component';
import { LoginComponent } from './users/login/login.component';
import { LogoutComponent } from './users/logout/logout.component';
import { ListColorsComponent } from './colors/list-colors/list-colors.component';
import { ColorComponent } from './colors/color/color.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { MyInfoComponent } from './employees/my-info/my-info.component';
import { MyRequestsComponent } from './requests/my-requests/my-requests.component';

@NgModule({
  declarations: [
    AppComponent,
    CounterComponent,
    ListFruitsComponent,
    HeaderComponent,
    ViewBooksComponent,
    EditBookComponent,
    ViewHttpBooksComponent,
    EditHttpBookComponent,
    LoginComponent,
    LogoutComponent,
    ListColorsComponent,
    ColorComponent,
    ViewRequestsComponent,
    ViewEmployeesComponent,
    MyInfoComponent,
    MyRequestsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
