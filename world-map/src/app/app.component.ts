import { Component } from '@angular/core';
import { MapComponent } from './map/map.component';
import { NgIf } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MapComponent,NgIf,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title:string='world-map';
  region:string='';
  name:string='';
  capcity:string='';
  id:string='';
  lat:string='';
  long:string='';
  income:string='';
  lending:string='';

  onCountrySelected(data:any){
    console.log('Received',data);
    const arr:any=data[1][0];
    this.region=arr.region.value;
    this.capcity=arr.capitalCity;
    this.id=arr.id;
    this.lat=arr.latitude
    this.long=arr.longitude
    this.name=arr.name
    this.income=arr.incomeLevel.value;
    this.lending=arr.lendingType.value;
  }
}