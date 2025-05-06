INSERT INTO public.usuarios
(id, apellido, codigo, create_at, edad, nombre)
VALUES(nextval('public.usuarios_id_seq'), 'Perez',  '1234567890', now(), 38, 'Jaimito');

INSERT INTO public.usuarios
(id, apellido, codigo, create_at, edad, nombre)
VALUES(nextval('public.usuarios_id_seq'), 'Inga',  '1716983562', now(), 39, 'Hernan');

INSERT INTO public.cuentas
(id, create_at, numero_cta, usuario_id, tipo_cta)
VALUES(nextval('public.cuentas_id_seq'), now(), '98583123000', 1, 'CORRIENTE');
INSERT INTO public.cuentas
(id, create_at, numero_cta, usuario_id, tipo_cta)
VALUES(nextval('public.cuentas_id_seq'), now(), '22222321000', 2, 'AHORRO');

INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Compra Online', 'D', 1, 200.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Transferencia a otro banco', 'D', 1, 12.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Salario', 'C', 1, 80.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Salario', 'C', 1, 1500.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Salario', 'C', 2, 2000.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Compra Online', 'D', 2, 200.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Transferencia a otro banco', 'D', 2, 12.00);
INSERT INTO public.movimientos
(id, create_at, descripcion, tipo_movimiento, cuenta_id, valor)
VALUES(nextval('public.movimientos_id_seq'), now(), 'Ahorro', 'C', 2, 80.00);
