import { Routes } from '@angular/router';

import { InventarioEntrada } from './pages/inventario-entrada/inventario-entrada';
import { InventarioSalida } from './pages/inventario-salida/inventario-salida';
import { InventarioHistorial } from './pages/inventario-historial/inventario-historial';
import { Login } from './pages/login/login';
import { Home } from './pages/home/home';

export const routes: Routes = [
    { path: 'login', component: Login },
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    {
        path: 'home',
        component: Home,
        children: [
            { path: 'entrada', component: InventarioEntrada },
            { path: 'salida', component: InventarioSalida },
            { path: 'historial', component: InventarioHistorial },
            { path: '', redirectTo: 'entrada', pathMatch: 'full' }
        ]
    },
    { path: '**', redirectTo: 'login' }
];
