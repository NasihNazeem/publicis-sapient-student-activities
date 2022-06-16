import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  users = [
    {name: "Alex", age: 30, gender: "Male"},
    {name: "Bruce", age: 20, gender: "Female"},
    {name: "Mary", age: 23, gender: "Female"}
  ]

}
