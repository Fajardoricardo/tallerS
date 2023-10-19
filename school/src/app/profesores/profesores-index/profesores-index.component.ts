import { Component, OnInit } from '@angular/core';
import { ProfesoresService } from '../profesores.service';
import { Route, Router } from '@angular/router';
import { HelperService } from 'src/app/config/services/helper.service';


@Component({
  selector: 'app-profesores-index',
  templateUrl: './profesores-index.component.html',
  styleUrls: ['./profesores-index.component.css']
})
export class ProfesoresIndexComponent implements OnInit {

  public listProfesores: any =  []
  constructor(private service: ProfesoresService, private route: Router,
    private helperService: HelperService) { }

  ngOnInit(): void {
    this.getAllProfesores();
  }

  getAllProfesores() {
    this.service.getAll().subscribe(
      result => {
        this.listProfesores =  result.data
        console.log(this.listProfesores)
      }
    );
  }
 
  new(){
    this.route.navigateByUrl("/profesores/new")
  }
  edit(id: any){
    this.route.navigateByUrl("/profesores/edit/"+ id)
  }
  delete(id: any){
  this.service.delete(id).subscribe(
    result => {
      this.helperService.showNotify("warning","Se elimino el registro profesor")
      this.getAllProfesores()
    }
  )
 }
}
