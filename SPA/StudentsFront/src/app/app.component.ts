import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {StudentsComponent} from './students/students.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, StudentsComponent, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Students';
}
