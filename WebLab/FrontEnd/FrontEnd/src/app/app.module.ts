import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './pages/main-page/main-page.component';
import { GroupComponent } from './components/group/group.component';
import { StudentComponent } from './components/student/student.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { AuthenticationService } from './services/authentication.service';
import { ErrorComponent } from './components/error/error.component';
import { ModalComponent } from './components/modal/modal.component';
import { AddGroupComponent } from './components/add-group/add-group.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { EditGroupComponent } from './components/edit-group/edit-group.component';
import { EditStudentComponent } from './components/edit-student/edit-student.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    GroupComponent,
    StudentComponent,
    ErrorComponent,
    ModalComponent,
    AddGroupComponent,
    AddStudentComponent,
    EditGroupComponent,
    EditStudentComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
