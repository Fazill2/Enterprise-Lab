import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-about',
  imports: [],
  templateUrl: './about.component.html',
  styleUrl: './about.component.scss'
})
export class AboutComponent implements OnInit {
  date = new Date();
  ngOnInit(): void {
    setInterval(() => {
      this.date = new Date();
    }, 1000);
  }

}
