import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {ReqMovInternoDto} from '../models/ReqMovInternoDto'
import { MovimientoInternoDto } from '../models/MovimientoInternoDto';

@Injectable({
  providedIn: 'root'
})
export class MovimientosService {

  private baseEndpoint = 'http://localhost:8085/movimientos/crear';

  private cabeceras: HttpHeaders = new HttpHeaders({ 'content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public crear(movDto: ReqMovInternoDto): Observable<MovimientoInternoDto> {
    return this.http.post<MovimientoInternoDto>(this.baseEndpoint, movDto, { headers: this.cabeceras });
  }

}
