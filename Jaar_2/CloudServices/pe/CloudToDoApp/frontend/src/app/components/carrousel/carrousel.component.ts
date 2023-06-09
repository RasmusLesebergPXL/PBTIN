import { Component, OnInit } from '@angular/core';
import { CarrouselItem } from 'src/app/CarrouselItem.model';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-carrousel',
  templateUrl: './carrousel.component.html',
  styleUrls: ['./carrousel.component.css']
})
export class CarrouselComponent implements OnInit {
  images!: CarrouselItem[];
  activeItem: number = 0;
  counter!: any;
  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.todoService.getCarrouselItems().subscribe(
      (data: any) => {
        this.images = data;
      }
    );

    this.counter = setInterval( () => {
      this.activeItem = (this.activeItem >= this.images.length-1) ? 0 : this.activeItem+1;
    },5000);
  }

  ngOnDestroy(): void{
    clearInterval(this.counter);
  }

  checkIfActive(index: number) {
    return this.activeItem === index;
  }

}

