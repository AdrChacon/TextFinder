package estructuras;
/**
 * Clase para crear una lista enlazada simple
 */
public class List<T>{

    private Nodo<T> cabeza;
    private int largo;

    private static class Nodo<T>{

        public Nodo<T> siguiente = null;
        public T archivo;
        public Nodo(T archivo) {
            this.archivo = archivo;
        }
    }


    public void InsertarInicio(T archivo){
        Nodo<T> nodo = new Nodo<T>(archivo);
        nodo.siguiente = cabeza;
        cabeza = nodo;
        largo++;
    }


    public void InsertarFinal(T archivo){
        Nodo<T> nodo = new Nodo<T>(archivo);
        if (cabeza == null){
            InsertarInicio(archivo);
        }else{
            Nodo<T> puntero = cabeza;
            while(puntero.siguiente != null){
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodo;
            largo++;
        }
    }


    public void Insertar(int indice,T archivo){
        Nodo<T> nodo = new Nodo<T>(archivo);
        if (cabeza == null || indice == 0){
            this.InsertarInicio(archivo);
        }else{
            Nodo<T> puntero = cabeza;
            int contador = 0;
            while(contador < indice && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            nodo.siguiente = puntero.siguiente;
            puntero.siguiente = nodo;
            largo++;
        }
    }


    public T Obtener(int indice){
        if(cabeza == null){
            return null;
        }else{
            Nodo<T> puntero = cabeza;
            int contador = 0;
            while (contador < indice && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            if(contador != indice){
                return null;
            }else{
                return puntero.archivo;
            }
        }
    }


    public int getLargo(){
        return largo;
    }


    public void eliminarPrimero(){
        if (cabeza != null) {
            Nodo<T> primer = cabeza;
            cabeza = cabeza.siguiente;
            primer.siguiente = null;
            largo--;
        }
    }


    public void eliminarUltimo(){
        if(cabeza != null){
            if(cabeza.siguiente == null){
                cabeza = null;
            }else{
                Nodo<T> puntero = cabeza;
                while (puntero.siguiente.siguiente != null){
                    puntero = puntero.siguiente;
                }
                puntero.siguiente = null;
                largo--;
            }
        }
    }


    public void eliminar(int indice){
        if (cabeza != null){
            if(indice == 0){
                this.eliminarPrimero();
            }else if(indice < largo) {
                Nodo<T> puntero = cabeza;
                int contador = 0;
                while (contador < (indice - 1)) {
                    puntero = puntero.siguiente;
                    contador++;
                }
                Nodo<T> temp = puntero.siguiente;
                puntero.siguiente = temp.siguiente;
                temp.siguiente = null;
                largo--;
            }
        }
    }

}