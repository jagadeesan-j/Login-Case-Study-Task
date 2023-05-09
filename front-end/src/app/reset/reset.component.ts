import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit{
  ngOnInit(): void {
    
  }
  constructor(private userService: UserService,private router:Router){}
  onSave(myForm:NgForm){
    this.userService.save(myForm.value).subscribe(
      (response:any)=>{
        if(response!=null){
          console.log(response.username);
          console.log(response.password);
          this.router.navigate(['/login']);
        }
        else{
          window.alert("Invalid");
        }
      }
    );
  }
}
