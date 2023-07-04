import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IStudent } from 'src/app/models/student';
import { ModalService } from 'src/app/services/modal.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent {
  @Output() emitter = new EventEmitter()
  @Input() editStudent: IStudent


  constructor(private modalService: ModalService,
    private studentService: StudentService){}

  put(){
    if(this.editStudent.id)
    this.studentService.update(this.editStudent, this.editStudent.id).subscribe(()=>{
      this.modalService.close()
      this.emitter.emit("success post");
    })
  }
}
