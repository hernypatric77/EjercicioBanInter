import { Component } from '@angular/core';
import { Movimiento } from 'src/app/models/movimiento';

@Component({
  selector: 'app-movimientos-form',
  templateUrl: './movimientos-form.component.html',
  styleUrls: ['./movimientos-form.component.css']
})
export class MovimientosFormComponent {
  movimiento: Movimiento = null;
}
