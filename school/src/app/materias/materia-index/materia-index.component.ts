import { Component, OnInit } from '@angular/core';
import { MateriaService } from '../materia.service';
import { Router } from '@angular/router';
import { HelperService } from 'src/app/config/services/helper.service';

@Component({
  selector: 'app-materia-index',
  templateUrl: './materia-index.component.html',
  styleUrls: ['./materia-index.component.css']
})
export class MateriaIndexComponent implements OnInit {
  public listMaterias: any =  []
  constructor(private service: MateriaService, private route: Router,
    private helperService: HelperService) { }

  ngOnInit(): void {
    this.getAllMaterias();
  }

  getAllMaterias() {
    this.service.getAll().subscribe(
      result => {
        this.listMaterias =  result.data
        console.log(this.listMaterias)
      }
    );
  }
 
  new(){
    this.route.navigateByUrl("/materias/new")
  }
  edit(id: any){
    this.route.navigateByUrl("/materias/edit/"+ id)
  }
  delete(id: any){
  this.service.delete(id).subscribe(
    result => {
      this.helperService.showNotify("warning","Se elimino el registro materia")
      this.getAllMaterias()
    }
  )
 }
}
