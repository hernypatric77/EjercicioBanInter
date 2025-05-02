# ProtectoBase

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.1.6.

## Development server

Ejecutar `ng serve` for a dev server. Navigate to `http://localhost:4200/`. La aplicación se recargará automáticamente si cambia alguno de los archivos fuente.

- node -version
- npm -version
- ng i -g @angular/cli
- ng version
- ng new [nombre_proyecto]
- cd [nombre_proyecto]
- ng server  ; ng server -o --port=3500
- modificamos tsconfig.json (strict --> false)
- npm install bootstrap @popperjs/core
- modificamos angular.json
- modificamos app.module.js (httpClientModule)
- [Instalamos alertas confirmaciones](https://sweetalert2.github.io/#download)

.nvmrc --> colocar la version del node, node version use para ver en q version esta corriendo el proyecto
[Bootstrap-ejemplos](https://getbootstrap.com/)

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

- ng g c components/usuarios --skip-tests --flat (no crea carpeta)
- ng g m layout/navbar
- modificamos app-routing.module.ts
- ng g s services/usuarios --skip-tests

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
