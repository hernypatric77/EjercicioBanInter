import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Movimiento } from 'src/app/models/movimiento';

@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {
  titulo = "Buscar movimientos de la cuenta";
  usuario: Movimiento = null;
  codigo: string= '';
  error: any;

  constructor(private service: UsuarioService, private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    // this.route.paramMap.subscribe(params => {
    //   const id: number = +params.get('id');
    //   if(id){
    //     this.service.ver(id).subscribe(usuario => this.usuario = usuario);
    //   }
    // })
  }

  public buscar(): void {
    this.usuario = new Movimiento();
    this.service.buscar(this.codigo).subscribe(
      usuario => {
        console.log(usuario);
        this.usuario = usuario},
      err => {
        if (err.status === 400) {
          this.error = err.error;
          console.log(this.error);
        }
      });
  }

  public calcularTotal(): number {
    if (!this.usuario.movimientos) return 0;
    return this.usuario.movimientos.reduce((total, movimiento) => {
      if (movimiento.tipoMovimiento === 'D') {
        return total - movimiento.valor;
      } else if (movimiento.tipoMovimiento === 'C') {
        return total + movimiento.valor;
      }
      return total;
    }, 0);
  }

  public recargarPagina(): void {
    window.location.reload();
  }
}
