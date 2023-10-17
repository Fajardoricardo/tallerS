import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfesoresService {
  private urlBase = "http://localhost:8000/api/profesor"
  private httpHeaders: HttpHeaders

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders();
    this.httpHeaders.append("Content-Type", "application/json")
   }
  getAll(){
    return this.http.get<any>(this.urlBase, {headers: this.httpHeaders})

  }
  getById(id: number){
    return this.http.get<any>(this.urlBase + '/' + id, {headers: this.httpHeaders})
  }
  save(data: any, id: any){
    if (id != undefined) {
      return this.http.put<any>(this.urlBase + '/' + id.toString(), data, {headers: this.httpHeaders})
    }else{
    return this.http.post<any>(this.urlBase, data, {headers: this.httpHeaders});
  }
}
delete(id: any){
  return this.http.delete<any>(this.urlBase + '/' + id.toString(), {headers: this.httpHeaders})
}
}
