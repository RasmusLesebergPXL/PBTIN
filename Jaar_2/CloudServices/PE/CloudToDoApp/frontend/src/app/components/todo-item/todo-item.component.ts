import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Todo } from 'src/app/models/todo.model';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
  @Input() todo!: Todo;
  highlight: boolean = false;
  @Output() onDelete: EventEmitter<any> = new EventEmitter();

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
  }

  toggleTodo(): void{
    this.todo.completed = !this.todo.completed;
    this.todoService.updateTodo(this.todo).subscribe();
  }

  deleteTodo(): void{
    this.todoService.deleteTodo(this.todo).subscribe(() => {
      this.onDelete.emit();
    });
  }

  toggleHighlight(): void{
    this.highlight = !this.highlight;
  }
}
