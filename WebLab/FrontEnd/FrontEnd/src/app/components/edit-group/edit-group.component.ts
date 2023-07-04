import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IGroup } from 'src/app/models/group';
import { GroupService } from 'src/app/services/group.service';
import { ModalService } from 'src/app/services/modal.service';

@Component({
  selector: 'app-edit-group',
  templateUrl: './edit-group.component.html',
  styleUrls: ['./edit-group.component.css']
})
export class EditGroupComponent {
  @Output() emitter = new EventEmitter();
  @Input() editGroup: IGroup

  constructor(private groupService: GroupService,
    private modalService: ModalService){}
  put(){
    if(this.editGroup.id)
    this.groupService.update(this.editGroup, this.editGroup.id).subscribe(()=>{
      this.modalService.close()
      this.emitter.emit("success put");
    })
  }
}
