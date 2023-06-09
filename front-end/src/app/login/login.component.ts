import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  ngOnInit(): void {
    
  }
  constructor(private userService: UserService,private router:Router){}
  onSubmit(myForm:NgForm){
    this.userService.login(myForm.value).subscribe(
      (response:any)=>{
        if(response!=null){
          console.log(response.username);
          console.log(response.password);
          this.router.navigate(['/home']);
        }
        else{
          window.alert("Invalid Credentials");
        }
      }
    );
  }
}

