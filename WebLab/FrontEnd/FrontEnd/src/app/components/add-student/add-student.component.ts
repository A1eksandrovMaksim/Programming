import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IStudent } from 'src/app/models/student';
import { ModalService } from 'src/app/services/modal.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent {
  @Output() emitter = new EventEmitter()
  @Input() groupId: number

  student: IStudent = {
    name: '',
    number: 0,
    birthdate: Date.now.toString()
  }

  constructor(private modalService: ModalService,
    private studentService: StudentService){}

  post(){
    this.studentService.add(this.student, this.groupId).subscribe(()=>{
      this.modalService.close()
      this.emitter.emit("success post");
    })
  }
}
