import { Usuario } from './usuario.interface';

export interface LoginRespuesta {
    usuario: Usuario;
    permisosIds: number[];
}