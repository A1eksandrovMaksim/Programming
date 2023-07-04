import { Component, EventEmitter, Output } from '@angular/core';
import { IGroup } from 'src/app/models/group';
import { GroupService } from 'src/app/services/group.service';
import { ModalService } from 'src/app/services/modal.service';

@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css']
})
export class AddGroupComponent {
  @Output() emitter = new EventEmitter();
  newGroup: IGroup = {
    name: '',
    students: []
  }
  constructor(private groupService: GroupService,
    private modalService: ModalService){}
  post(){
    this.groupService.add(this.newGroup).subscribe(()=>{
      this.modalService.close()
      this.emitter.emit("success post");
    })
  }
}
