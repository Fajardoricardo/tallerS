import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EspecialidadesIndexComponent } from './especialidades/especialidades-index/especialidades-index.component';
import { EspecialidadesFormComponent } from './especialidades/especialidades-form/especialidades-form.component';
import { ProfesoresIndexComponent } from './profesores/profesores-index/profesores-index.component';
import { ProfesoresFormComponent } from './profesores/profesores-form/profesores-form.component';
import { MateriaIndexComponent } from './materias/materia-index/materia-index.component';
import { MateriaFormComponent } from './materias/materia-form/materia-form.component';

const routes: Routes = [
  {path: 'especialidades', component: EspecialidadesIndexComponent},
  {path: 'especialidades/new', component: EspecialidadesFormComponent},
  {path: 'especialidades/edit/:id', component: EspecialidadesFormComponent},
  {path: 'profesores', component: ProfesoresIndexComponent},
  {path: 'profesores/new', component: ProfesoresFormComponent},
  {path: 'profesores/edit/:id', component: ProfesoresFormComponent},
  {path: 'materias', component: MateriaIndexComponent},
  {path: 'materias/new', component: MateriaFormComponent},
  {path: 'materias/edit/:id', component: MateriaFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
