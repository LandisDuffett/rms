import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/users/auth.service';
import { User } from 'src/app/users/user.model';
import { EmployeeService } from '../employee.service';


@Component({
  selector: 'app-my-info',
  templateUrl: './my-info.component.html',
  styleUrls: ['./my-info.component.css']
})
export class MyInfoComponent implements OnInit {

  currentUserInfo = this.authService.retreiveUserInfo();

  shouldDisplay: boolean = false;

  oldPassword: string = "";

  updateEmployee: any = {
    userId: 0,
    userFirstName: '',
    userLastName: '', 
    userEmail: '',
    userPassword: '',
    userRole: ''
  }

  constructor(private employeeService: EmployeeService, private router: Router, private authService: AuthService, private activatedRoute: ActivatedRoute) { 
  }

  ngOnInit(): void {
    this.updateEmployee =  this.authService.retreiveUserInfo();
  }

  loadData(){
  }

  displayResetForm(){
    if(this.shouldDisplay){
      this.shouldDisplay = false;
    }else{
      this.shouldDisplay = true;
    }
  }

  updateEmpInfo(){
    //updates info in db
    //response returns updated info, which is set in session storage
    //current info is retrieved from session storage and set to currentUserInfo to show updated info to user
    //current info is also set to updateEmployee, which is two-way bound to form in template
    this.employeeService.updateEmployee(this.updateEmployee).subscribe((response)=>{
      this.authService.storeUserInfo(response);
      this.currentUserInfo = this.authService.retreiveUserInfo();
      this.updateEmployee =  this.authService.retreiveUserInfo();
    })
  }

}
