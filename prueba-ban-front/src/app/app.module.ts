import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { LayoutModule } from './layout/layout.module';
import { UsuariosFormComponent } from './components/usuarios/usuarios-form.component';
import { MovimientosComponent } from './components/movimientos/movimientos.component';
import { MovimientosFormComponent } from './components/movimientos/movimientos-form.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuariosComponent,
    UsuariosFormComponent,
    MovimientosComponent,
    MovimientosFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
