import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private username = 'admin'
  private password = '100'

  public getUsername(newUsername?: string): string{
    if(newUsername != undefined)
      this.username = newUsername;
    return this.username
  }

  public getPassword(newPassword?: string): string{
    if(newPassword != undefined)
      this.password = newPassword;
    return this.password
  }
}
