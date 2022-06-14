import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'list-fruits',
  templateUrl: './list-fruits.component.html',
  styleUrls: ['./list-fruits.component.css']
})
export class ListFruitsComponent implements OnInit {

  allFruits = ["Apple", "Banana", "Oranges"];

  constructor() { }

  ngOnInit(): void {
  }

}
