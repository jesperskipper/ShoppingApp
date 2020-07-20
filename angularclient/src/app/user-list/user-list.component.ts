import { Component, OnInit } from '@angular/core';
import {UserService} from "../service/user.service";
import {User} from "../models/user";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  private users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.findAll().subscribe(data =>{
      this.users = data;
    })
  }

}