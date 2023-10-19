import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { ToastrModule } from 'ngx-toastr';
import { EspecialidadesIndexComponent } from './especialidades/especialidades-index/especialidades-index.component';
import { EspecialidadesFormComponent } from './especialidades/especialidades-form/especialidades-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProfesoresFormComponent } from './profesores/profesores-form/profesores-form.component';
import { ProfesoresIndexComponent } from './profesores/profesores-index/profesores-index.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { MateriaIndexComponent } from './materias/materia-index/materia-index.component';
import { MateriaFormComponent } from './materias/materia-form/materia-form.component';


@NgModule({
  declarations: [
    AppComponent,
    EspecialidadesIndexComponent,
    EspecialidadesFormComponent,
    ProfesoresFormComponent,
    ProfesoresIndexComponent,
    MateriaIndexComponent,
    MateriaFormComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      autoDismiss: true,
      positionClass: "toast-bottom-right"
    }),
    FormsModule,
    ReactiveFormsModule,
    NgSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
