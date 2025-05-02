import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { UsuariosFormComponent } from './components/usuarios/usuarios-form.component';
import { MovimientosComponent } from './components/movimientos/movimientos.component';
import { MovimientosFormComponent } from './components/movimientos/movimientos-form.component';

const routes: Routes = [
  {path:'', pathMatch:'full', redirectTo:'movimientos'},
  {path:'usuarios', component: UsuariosComponent},
  {path:'usuarios/form', component: UsuariosFormComponent},
  {path:'usuarios/form/:id', component: UsuariosFormComponent},
  {path: 'movimientos', component: MovimientosComponent},
  {path: 'movimientos/form', component: MovimientosFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
