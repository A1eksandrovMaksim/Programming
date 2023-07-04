import { Component, EventEmitter, Output } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ModalService } from 'src/app/services/modal.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  @Output() emmiter = new EventEmitter()

  login = ''
  password = ''

  constructor(private authService: AuthenticationService,
    private modalService: ModalService){}

  signin(){console.log(
    this.authService.getPassword(this.password) + ":" +
    this.authService.getUsername(this.login))
    this.modalService.close()
    this.emmiter.emit();
  }
}
