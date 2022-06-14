import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'list-colors',
  templateUrl: './list-colors.component.html',
  styleUrls: ['./list-colors.component.css']
})
export class ListColorsComponent implements OnInit {

allColors = [{colorId: 1, colorName: "RED"},
             {colorId: 2, colorName: "GREEN"},
             {colorId: 3, colorName: "BLUE"}]

  constructor() { }

  ngOnInit(): void {
  }

  removeInParent($event: any){
    // here we handle the event of removing the colore from the array
    console.log($event);
    this.allColors = this.allColors.filter((color)=>$event!=color.colorId);
  }
}
