import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from '../request.model';
import { RequestService } from '../request.service';
import { AuthService } from 'src/app/users/auth.service';

@Component({
  selector: 'my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.css']
})
export class MyRequestsComponent implements OnInit {

  currentMyRequests: Request[];

  shouldDisplay: boolean = false;
  
  currentUser = this.authService.retreiveUserInfo();

  newRequest: Request = {
    requestId: 0,
    userId: this.currentUser.userId,
    requestAmount: 0,
    requestDescription: '',
    requestStatus: 'pending',
    requestImageURL: '',
    requestTime: new Date().toUTCString(),
    resolvedTime: ''
  };

  displayAll: boolean = false;

  displayPend: boolean = false;
  
  displayRes: boolean = false;

  constructor(private requestService: RequestService, private router: Router, private authService: AuthService) { 
    this.currentMyRequests = [];
}

  ngOnInit(): void {
    this.loadData();
  }

  loadData(){
    let usr = this.authService.retreiveUserInfo();
    let usrid = usr.userId;
    //get all requests for the currently logged in employee
    this.requestService.getEmpReqs(usrid).subscribe(response => {
      console.log(usr);
      console.log(usrid);
      this.currentMyRequests = response;
    })
  }

  //toggle display of all requests
  displayAllMyReq(){
    this.displayAll = true;
    this.displayPend = false;
    this.displayRes = false;
  }

  //toggle display of pending requests
  displayMyPendReq(){
    this.displayAll = false;
    this.displayPend = true;
    this.displayRes = false;
  }

  //toggle display of resolved requests
  displayMyResReq(){
    this.displayAll = false;
    this.displayPend = false;
    this.displayRes = true;
  }

  //toggle display of submit new request form
  displayReqForm(){
    if(this.shouldDisplay){
      this.shouldDisplay = false;
    }else{
      this.shouldDisplay = true;
    }
  }

  addANewRequest(){
    console.log(this.newRequest)
    this.requestService.addRequest(this.newRequest).subscribe((response)=>{
 
       // we need a fresh fetch of all requests from the database
      this.loadData();

      // clear the Add Form
      this.newRequest = {
        requestId: 0,
        userId: this.currentUser.userId,
        requestAmount: 0,
        requestDescription: '',
        requestStatus: 'pending',
        requestImageURL: '',
        requestTime: new Date().toUTCString(),
        resolvedTime: ''
      };

      // toggle/hide the Add Form
      this.shouldDisplay = false;
    })
  }

}
