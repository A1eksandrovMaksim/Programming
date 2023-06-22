import { Component, OnInit } from '@angular/core';
import { University } from './components/classes/university';
import { UniversityService } from './components/services/university.service';
import { IUniversity } from './components/models/university';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'angular-project';
  universities: University[] = [];
  state_for_filter:string = '';
  name_for_filter:string = '';

  constructor(private universityService: UniversityService){

  }
  
  ngOnInit(): void {
    this.universityService.getAll().subscribe((unties)=>{
      unties.forEach( (unty: IUniversity):void =>{ 
        this.universities.push(new University(unty))
      })
    })
  }

  filterBtnClk(): void{
    this.universities = []
    this.universityService.getAllWithFilter(this.state_for_filter, this.name_for_filter).subscribe((unties)=>{
      unties.forEach( (unty: IUniversity):void =>{ 
        this.universities.push(new University(unty))
      })
    })
  }

}
