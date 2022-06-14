import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

  counter: number = 0;

  constructor() { }

  ngOnInit(): void {
  }

  incrementCounter(){
    //this.counter = +this.counter + 1; 
    this.counter++;
  }

  decrementCounter(){
    //this.counter = +this.counter - 1; 
    this.counter--;
  }
}
