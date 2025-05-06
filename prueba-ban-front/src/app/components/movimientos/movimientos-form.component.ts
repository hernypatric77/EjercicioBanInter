import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovimientoInternoDto } from 'src/app/models/MovimientoInternoDto';
import { ReqMovInternoDto } from 'src/app/models/ReqMovInternoDto';
import { MovimientosService } from 'src/app/services/movimientos.service';

import Swal from 'sweetalert2';

@Component({
  selector: 'app-movimientos-form',
  templateUrl: './movimientos-form.component.html',
  styleUrls: ['./movimientos-form.component.css']
})
export class MovimientosFormComponent {
  reqMovimiento: ReqMovInternoDto;
  movimientoInt: MovimientoInternoDto = null;
  error: any;

  constructor(private service: MovimientosService, private router: Router,
    private route: ActivatedRoute
  ) {
    this.reqMovimiento = new ReqMovInternoDto();
   }

  public guardarMovimiento(): void {
    this.service.crear(this.reqMovimiento).subscribe(
      respDto => {
        console.log(respDto);
        this.movimientoInt = respDto
        if(this.movimientoInt.codError !== null) {
          Swal.fire('Error: ', `Transaccion rechazada: ${this.movimientoInt.descError}`, 'error');
        }
      },
      err => {
        if (err.status === 400) {
          this.error = err.error;
          console.log(this.error);
        }
      });
  }

  public recargarPagina(): void {
    window.location.reload();
  }

}
