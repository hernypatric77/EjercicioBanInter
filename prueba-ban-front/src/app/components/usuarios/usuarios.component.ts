import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  titulo = 'Listado de usuarios';
  usuarios: Usuario[];
  constructor(private service: UsuarioService) { }

  ngOnInit() {
    this.service.listar().subscribe(usuarios => this.usuarios = usuarios);

  }

  public eliminar(usuario): void {

    Swal.fire({
      title: "Cuidado:",
      text: `¿Seguro que desea elimnar a ${usuario.nombre} ?`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Si, eliminar!"
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(usuario.id).subscribe(() => {
          this.usuarios = this.usuarios.filter(a => a !== usuario);
          Swal.fire('Eliminado: ', `Usuaios ${usuario.nombre} eliminado con exito`, 'success');
        });
      }
    });


  }

}
