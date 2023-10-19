import { Component, OnInit } from '@angular/core';
import { EspecialidadService } from '../especialidad.service';
import {  Router } from '@angular/router';
import { HelperService } from 'src/app/config/services/helper.service';

@Component({
  selector: 'app-especialidades-index',
  templateUrl: './especialidades-index.component.html',
  styleUrls: ['./especialidades-index.component.css']
})
export class EspecialidadesIndexComponent implements OnInit {
  public listEspecialidades: any =  []
  constructor(private service: EspecialidadService, private route: Router,
    private helperService: HelperService) { }

  ngOnInit(): void {
    this.getAllEspecialidades();
  }

  getAllEspecialidades() {
    this.service.getAll().subscribe(
      result => {
        this.listEspecialidades =  result.data
        console.log(this.listEspecialidades)
      }
    );
  }
 
  new(){
    this.route.navigateByUrl("/especialidades/new")
  }
  edit(id: any){
    this.route.navigateByUrl("/especialidades/edit/"+ id)
  }
  delete(id: any){
  this.service.delete(id).subscribe(
    result => {
      this.helperService.showNotify("warning","Se elimino un registro especialidad")
      this.getAllEspecialidades()
    }
  )
 }
}
