import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { EspecialidadService } from '../especialidad.service';
import { ActivatedRoute } from '@angular/router';
import { Route, Router } from '@angular/router';
import { HelperService } from 'src/app/config/services/helper.service';

@Component({
selector: 'app-especialidades-form',
templateUrl: './especialidades-form.component.html',
styleUrls: ['./especialidades-form.component.css']
})
export class EspecialidadesFormComponent implements OnInit {

public id = 0;  
public frmEspecialidad: FormGroup;

constructor(private service: EspecialidadService, private activeRoute: ActivatedRoute,
   private helperService: HelperService, private route: Router) { 
  this.id = this.activeRoute.snapshot.params['id'];
  this.frmEspecialidad = new FormGroup({
    nombre: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(50)])
  })
}
volver(){
  this.route.navigateByUrl("/especialidades")
}
ngOnInit(): void {
  if (this.id != 0 && this.id != undefined) {
    this.service.getById(this.id).subscribe(
      result =>{
        this.frmEspecialidad.controls['nombre'].setValue(result.data.nombre)
      },
      error =>{}
    )
  }
}

guardar(){
  if (this.frmEspecialidad.invalid) {
    this.helperService.showNotify("warning","El campo no cumple con las validaciones, hpt bruto!.")
    return
  }
  let data = {
    "nombres": this.frmEspecialidad.controls['nombre'].value
  }
  this.service.save(data, this.id).subscribe(
    result => {
      this.helperService.showNotify("success","Especialidad guardada.")
    },
    error => {
      this.helperService.showNotify("danger","Se generó un error al guardar.")
    }
  )
}
delete(){
  if (this.id != 0) {
    this.service.getById(this.id).subscribe(
      result =>{
        this.frmEspecialidad.controls['nombre'].setValue(result.data.nombre)
      },
      error =>{
        this.helperService.showNotify("danger","Se generó un error.")
      }
    )
  }
}
}
