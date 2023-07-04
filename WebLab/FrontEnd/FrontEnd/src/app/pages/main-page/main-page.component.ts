import { Component, OnInit } from '@angular/core';
import { IGroup } from 'src/app/models/group';
import { IStudent } from 'src/app/models/student';
import { GroupService } from 'src/app/services/group.service';
import { ModalService } from 'src/app/services/modal.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit{
  groups: IGroup[] = []
  idGroupOfNewStudent = 0
  editGroupObj: IGroup 
  editStudentObj: IStudent

  constructor(private groupService: GroupService,
    public modalService: ModalService){}

  ngOnInit(){
    this.groupService.getAll().subscribe({
      next:((responce: IGroup[])=>{
        this.groups = responce
      })
    })
  }

  editGroup(event: IGroup){
    this.editGroupObj = event
    this.modalService.openEditGroup()
  }

  addStudent(event: number){
    this.idGroupOfNewStudent = event
    this.modalService.openAddStudent()
  }

  shouldRefreshList(event: any){
    this.groupService.getAll().subscribe({
      next:((responce: IGroup[])=>{
        this.groups = responce
      })
    })
  }

  editStudent(event: IStudent){
    this.editStudentObj = event
    this.modalService.openEditStudent()
  }

}
