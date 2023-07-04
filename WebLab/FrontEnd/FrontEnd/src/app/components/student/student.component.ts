import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IStudent } from 'src/app/models/student';
import { ModalService } from 'src/app/services/modal.service';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent{
  @Input() student: IStudent
  @Output() emitter = new EventEmitter()
  @Output() editStudentEmit = new EventEmitter<IStudent>()

  constructor(public studentService: StudentService){}

  shouldRefreshList(event: any){
    this.emitter.emit()
  }

  editStudent(){
    this.editStudentEmit.emit(this.student)
  }

  deleteStudent(){
    if(this.student.id)
    this.studentService.delete(this.student.id).subscribe(()=>{
      this.emitter.emit()
    })
  }
  
}
