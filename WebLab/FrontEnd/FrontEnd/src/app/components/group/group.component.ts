import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IGroup } from 'src/app/models/group';
import { GroupService } from 'src/app/services/group.service';
import { ModalComponent } from '../modal/modal.component';
import { ModalService } from 'src/app/services/modal.service';

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent {
  @Output() deleteGroupEvent = new EventEmitter()
  @Output() addStudent = new EventEmitter<number>()
  @Output() editGroupEmit = new EventEmitter<IGroup>()
  @Input() group: IGroup

  constructor(private groupService: GroupService){}

  deleteGroup(){
    if(this.group.id)
    this.groupService.delete(this.group.id).subscribe(()=>{
      this.deleteGroupEvent.emit()
    })
  }

  editGroup(){
    this.editGroupEmit.emit(this.group)
  }

  addNewStudent(){
    if(this.group.id)
      this.addStudent.emit(this.group.id)
  }

  shouldRefreshList(event: any){
    this.deleteGroupEvent.emit()
  }
  
}
