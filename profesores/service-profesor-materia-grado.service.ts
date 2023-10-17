import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServiceProfesorMateriaGradoService {
  private urlBase = "http://localhost:8000/api/profesor_materia_gardo"
  private httpHeaders: HttpHeaders

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders();
    this.httpHeaders.append("Content-Type", "application/json")
   }
  getAll(){
    return this.http.get<any>(this.urlBase, {headers: this.httpHeaders})

  }
  save(data: any){
      return this.http.post(this.urlBase, data, {headers: this.httpHeaders})
  }
delete(id: any){
  return this.http.delete(this.urlBase + '/' + id.toString(), {headers: this.httpHeaders})
}}
