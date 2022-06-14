import { Component, Input, OnInit, QueryList, ViewChildren } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../users/user.model';
import { Request } from '../../requests/request.model';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'view-employees',
  templateUrl: './view-employees.component.html',
  styleUrls: ['./view-employees.component.css']
})
export class ViewEmployeesComponent implements OnInit {

  currentAllEmployees: User[];

  currentEmpRequests: Request[];

  displayForm: boolean = false;

  displayAll: boolean = false;

  displayEmpReqs: boolean = false;

  currUsrFN: string = "";

  currUsrLN: string = "";

  newEmployee: User = {
    userId: 0,
    userFirstName: '',
    userLastName: '',
    userEmail: '',
    userPassword: '',
    userRole: ''
  };

  updatedRequest: Request = {
    requestId: 0,
    userId: 0,
    requestAmount: 0,
    requestDescription: '',
    requestStatus: '',
    requestImageURL: '',
    requestTime: '',
    resolvedTime: ''
  }
  
  constructor(private employeeService: EmployeeService, private router: Router) { 
    this.currentAllEmployees = [];
    this.currentEmpRequests = [];
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    //need to retrieve a list of all employees for display and as basis for retrieiving individual employees' requests
    this.employeeService.getAllEmployees().subscribe(response => {
      this.currentAllEmployees = response;
      this.displayAll = true;
    })
  }

  displayAllReqs(){
    //toggles displayAll on in order to display all employees
    //toggles displayEmpReqs off in order to hide chosen individual employee's requests
    this.displayAll = true;
    this.displayEmpReqs = false;
  }

  displayOneReqs(userId: number, ufn: string, uln: string){
    //brings in chosen individual's first name and last name from template so current individual's name can be displayed in template
    this.currUsrFN = ufn;
    this.currUsrLN = uln;
    //uses the userId parameter to retrieve all requests for that individual and sets the response array to currentEmpRequests
    this.employeeService.getEmpReqs(userId).subscribe(response => {
      this.currentEmpRequests = response;
      //toggles displayAll off in order to hide all employees
      this.displayAll = false;
      //toggles displayEmpReqs on in order to display chosen individual's requests
      this.displayEmpReqs = true;
    });
  }

  addANewEmp(){
    this.employeeService.addEmployee(this.newEmployee).subscribe((response)=>{
       // we need a fresh fetch of all employees from the database
      this.loadData();

      // toggle/hide the Add Request Form
      this.displayForm = false;
    })
  }

  goBack() {
    //returns to display of all employees since navbar does not provide this link
    this.displayEmpReqs = false;
    this.loadData();
  }

  goToEditRequest(request: any, reqStatus: string) {
    //sends pending request to be updated with requestStatus of either 'approved' or 'denied'
    this.updatedRequest.userId = request.userId;
    this.updatedRequest.requestId = request.requestId;
    this.updatedRequest.requestAmount = request.requestAmount;
    this.updatedRequest.requestDescription = request.requestDescription;
    this.updatedRequest.requestStatus = reqStatus;
    this.updatedRequest.requestImageURL = request.requestImageURL;
    this.updatedRequest.requestTime = request.requestTime;
    this.updatedRequest.resolvedTime = new Date().toUTCString();
    this.employeeService.updateRequest(this.updatedRequest).subscribe((response)=>{
    //retrieves fresh array of requests, now fully updated
      this.displayOneReqs(request.userId, this.currUsrFN, this.currUsrLN)
    })
  }

}
