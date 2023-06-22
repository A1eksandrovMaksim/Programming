import { Component, Input } from "@angular/core";
import { University } from "../classes/university";

@Component({
    selector: 'app-study',
    templateUrl: './study.component.html',
    styleUrls: ['./study.component.css']
})

export class StudyComponent {
    @Input() university: University
}



