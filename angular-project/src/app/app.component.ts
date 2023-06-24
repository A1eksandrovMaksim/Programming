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
  universitiesWithFilter: University[] = [];
  universities: University[] = [];
  public state_for_filter:string = '';
  public name_for_filter:string = '';
  isLoading: boolean = false;
  displayedColumns: string[] = ['country', 'name', 'domains', 'admition_date', 'graduate_date', 'pay_condition', 'debt'];

  constructor(private universityService: UniversityService){}
  
  ngOnInit(): void {
    this.isLoading = true;
    this.universityService.getAll().subscribe((unties)=>{
        unties.forEach( (unty: IUniversity):void =>{ 
          this.universities.push(new University(unty))
        })
        this.universities.sort(this.sortfunc)
        this.isLoading = false;
        this.universitiesWithFilter = this.universities.slice(0)
    })
  }

  private sortfunc(au: University, bu: University):number{
    if(au.country === bu.country)
            if(au.name === bu.name)
              return 0
            else
              if(au.name > bu.name)
                return 1
              else
                return -1
          else
            if(au.country > bu.country)
              return 1
            else
              return -1
  }

  

  filterBtnClk(): void{
    this.universitiesWithFilter = []
    this.isLoading = true;
    this.universities.forEach((unty: University):void =>{ 
      if(unty.country.toLowerCase().search(this.state_for_filter.toLowerCase()) !== -1 || !this.state_for_filter)
        if(unty.name.toLowerCase().search(this.name_for_filter.toLowerCase()) !== -1 || !this.name_for_filter)
          this.universitiesWithFilter.push(unty)
    })
    this.isLoading = false;
  }

}
