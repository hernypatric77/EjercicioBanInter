import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-usuarios-form',
  templateUrl: './usuarios-form.component.html',
  styleUrls: ['./usuarios-form.component.css']
})
export class UsuariosFormComponent implements OnInit {

  titulo: string = "Formulario de Usuario";
  usuario: Usuario = new Usuario();
  error: any;
  tiposUsuario: string[] = ['CLIENTE', 'EMPLEADO'];

  constructor(private service: UsuarioService, private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id: number = +params.get('id');
      if(id){
        this.service.ver(id).subscribe(usuario => this.usuario = usuario);
      }
    })
  }

  public crear(): void {
    this.service.crear(this.usuario).subscribe(
      usuario => {
        console.log(usuario);
        Swal.fire('Nuevo',`usuario ${usuario.nombre} creado con exito!`, 'success');
        this.router.navigate(['/usuarios']);
      },
      err => {
        if (err.status === 400) {
          this.error = err.error;
          console.log(this.error);
        }
      }
    );
  }

  public editar(): void {
    this.service.editar(this.usuario).subscribe(
      usuario => {
        console.log(usuario);
        Swal.fire('Actualizado:',`Usuario ${usuario.nombre} actualizado con exito!`, 'success');
        this.router.navigate(['/usuarios']);
      },
      err => {
        if (err.status === 400) {
          this.error = err.error;
          console.log(this.error);
        }
      }
    );
  }

}
