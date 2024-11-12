package em.inventarios.servicio;

import java.util.List;

import em.inventarios.modelo.Producto;

//agregaremos los metodos basicos para recuperar informacion de la bd
public interface IProductoServicio {
    // metodo listar producto
    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer idProducto);

}
