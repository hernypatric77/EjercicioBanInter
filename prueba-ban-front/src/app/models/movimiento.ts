import { Movimientodet } from "./movimientodet";

export class Movimiento {
  codUsuario: string;
  nombre: string;
  apellido: string;
  edad: number;
  fechaCreacion: Date;
  cargoEmpleado: string;
  tipoUsuario: string;
  numCuenta: string;
  movimientos: Movimientodet[] = [];
}
