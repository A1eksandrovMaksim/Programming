import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudyComponent } from './components/study/study.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule } from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    StudyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
