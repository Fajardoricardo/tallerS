import { Component, OnInit } from '@angular/core';
import { ProfesoresService } from '../profesores.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HelperService } from 'src/app/config/services/helper.service';
import { Route, Router } from '@angular/router';
import { EspecialidadService } from 'src/app/especialidades/especialidad.service';
import { MateriaService } from 'src/app/materias/materia.service';
import { ServiceProfesorMateriaGradoService } from '../service-profesor-materia-grado.service';


@Component({
  selector: 'app-profesores-form',
  templateUrl: './profesores-form.component.html',
  styleUrls: ['./profesores-form.component.css']
})
export class ProfesoresFormComponent implements OnInit {
  public id = 0;  
  public frmProfesor: FormGroup;
  public frmProfesorMateriaGrado: FormGroup;

  public listMaterias: any = []
  public listGrados: any = []
  public listEspecialidades: any = []
  
  constructor(private service: ProfesoresService, private serviceProfesorMateriaGrado: ServiceProfesorMateriaGradoService,private activeRoute: ActivatedRoute,
     private helperService: HelperService, private route: Router, private serviceEspecialidades: EspecialidadService,
     private serviceMateria: MateriaService) { 
    this.id = this.activeRoute.snapshot.params['id'];
    this.frmProfesor = new FormGroup({
      nombres: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      apellidos: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(50)]),
      especialidad: new FormControl(null, Validators.required)
    });
    this.frmProfesorMateriaGrado = new FormGroup ({
      materia: new FormControl(null, Validators.required),
      grado: new FormControl(null, Validators.required)
    });
  }
  volver(){
    this.route.navigateByUrl("/profesores")
  }
  ngOnInit(): void {
    this.getlists();

    if (this.id != 0 && this.id != undefined) {
      this.service.getById(this.id).subscribe(
        result =>{
          this.frmProfesor.controls['nombres'].setValue(result.data.nombres)
          this.frmProfesor.controls['apellidos'].setValue(result.data.apellidos)
          this.frmProfesor.controls['especialidad'].setValue(result.data.especialidad.id)
        },
        error =>{}
      )
    }
    
  }
  getlists(){
    this.serviceEspecialidades.getAll().subscribe(
      result => {
        this.listEspecialidades = result.data
      }
    )
    this.serviceGrado.getAll().subscribe(
      result => {
        this.listGrados = result.data
      }
    )
    this.serviceMateria.getAll().subscribe(
      result => {
        this.listMaterias = result.data
      }
    )
  }
  
  guardar(){
    if (this.frmProfesor.invalid) {
      this.helperService.showNotify("warning","El campo no cumple con las validaciones, hpt bruto!.")
      return
    }
    let data = {
      "nombres": this.frmProfesor.controls['nombres'].value,
      "apellidos": this.frmProfesor.controls['apellidos'].value,
      "especialidad":{
        "id": this.frmProfesor.controls['especialidad'].value
      } 
    }
    this.service.save(data, this.id).subscribe(
      result => {
        this.helperService.showNotify("success","Profesor guardada.")
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
          this.frmProfesor.controls['nombre'].setValue(result.data.nombres)
        },
        error =>{}
      )
    }
  }
  guardarMateriaGrado(){
    if (this.frmProfesorMateriaGrado.invalid) {
      this.helperService.showNotify("warning","El campo no cumple con las validaciones, hpt bruto!.")
      return
    }
    let data = {
      "profesor":{
        "id": this.id
      },
      "materia":{
        "id": this.frmProfesorMateriaGrado.controls['materia'].value
      },
      "grado":{
        "id": this.frmProfesorMateriaGrado.controls['grado'].value
      }
     
    }
    this.serviceProfesorMateriaGrado.save(data).subscribe(
      result => {
        this.helperService.showNotify("success","Profesor guardada.")
      },
      error => {
        this.helperService.showNotify("danger","Se generó un error al guardar.")
      }
    )
  }
}
