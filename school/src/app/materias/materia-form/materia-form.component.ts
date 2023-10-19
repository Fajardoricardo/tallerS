import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MateriaService } from '../materia.service';
import { ActivatedRoute, Router } from '@angular/router';
import { HelperService } from 'src/app/config/services/helper.service';

@Component({
  selector: 'app-materia-form',
  templateUrl: './materia-form.component.html',
  styleUrls: ['./materia-form.component.css']
})
export class MateriaFormComponent implements OnInit {

  public id = 0;
  public frmMateria: FormGroup;

  constructor(private service: MateriaService, private activeRoute: ActivatedRoute,
    private helperService: HelperService, private route: Router) {
      this.id = this.activeRoute.snapshot.params['id'];
      this.frmMateria = new FormGroup({
        nombre: new FormControl(null, [Validators.required, Validators.minLength(3), Validators.maxLength(50)])
      })
     }

  ngOnInit(): void {
    if (this.id != 0 && this.id != undefined) {
      this.service.getById(this.id).subscribe(
        result =>{
          this.frmMateria.controls['nombre'].setValue(result.data.nambre)
        },
        error =>{
          this.helperService.showNotify("danger","Se generó un error")
        }
      )
    }
  }
  volver(){
    this.route.navigateByUrl("/materias")
  }
  guardar(){
    if (this.frmMateria.invalid) {
      this.helperService.showNotify("warning","El campo no cumple con las validaciones.")
      return
    }
    let data = {
      "nombres": this.frmMateria.controls['nombre'].value
    }
    this.service.save(data, this.id).subscribe(
      result => {
        this.helperService.showNotify("success","Materia guardada de forma correcta.")
      },
      error => {
        this.helperService.showNotify("danger","Se generó un error al guardar")
      }
    )
  }
  delete(){
    if (this.id != 0) {
      this.service.getById(this.id).subscribe(
        result =>{
          this.frmMateria.controls['nombre'].setValue(result.data.nombre)
        },
        error =>{
          this.helperService.showNotify("danger","Se generó un error")
        }
      )
    }
  }
}
