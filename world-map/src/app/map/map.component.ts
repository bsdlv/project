import { ApiService } from '../api.service';
import { Component, Output, EventEmitter } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-map',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './map.component.html',
  styleUrl: './map.component.css'
})

export class MapComponent {
    @Output() countrySelected=new EventEmitter<any>();
    
    constructor(private apiService:ApiService) {}
    
    countryClick(event:MouseEvent) { 
        const selected:any=event.target;
        const id:string=selected.id;
        this.apiService.getInfo(id).subscribe(
            (resp:any)=>{
                this.countrySelected.emit(resp)
            },
            (error)=>{
                console.error('Error fetching country data:',error);
            }
        );
    }
}
