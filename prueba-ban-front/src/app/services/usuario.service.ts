import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// lo mismo pero utilizando pipe
// import { map } from 'rxjs/operators';
import { Usuario } from '../models/usuario';
import { Movimiento } from '../models/movimiento';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseEndpoint = 'http://localhost:8085';

  private cabeceras: HttpHeaders = new HttpHeaders({ 'content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public listar(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.baseEndpoint);
    // lo mismo pero utilizando pipe
    // return this.http.get(this.baseEndpoint).pipe(
    //   map(usuarios => usuarios as Usuario[])
    // );
  }

  public listarPaginas(page: string, size: string): Observable<any> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size);
    return this.http.get<any>(`${this.baseEndpoint}/pagina`, { params: params });
  }

  public ver(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.baseEndpoint}/ ${id}`);
  }

  public crear(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.baseEndpoint, usuario, { headers: this.cabeceras });
  }

  public editar(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.baseEndpoint}/ ${usuario.id}`, usuario, { headers: this.cabeceras })
  }

  public eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseEndpoint}/ ${id}`);
  }

  public buscar (codigo: string): Observable<Movimiento> {
    return this.http.get<Movimiento>(`${this.baseEndpoint}/filtrar/${codigo}`);
  }
}
