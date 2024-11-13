package em.inventarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import em.inventarios.excepcion.RecursoNoEncontradoExcepcion;
import em.inventarios.modelo.Producto;
import em.inventarios.servicio.ProductoServicio;

@RestController
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    // el controlador necesita del servicio, por medio de la inyeccion de
    // dependencias lo usaremos
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoServicio.listarProductos();
        System.out.println("Se han impreso los productos");
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
        return this.productoServicio.guardarProducto(producto);
    }

    // si encontramos el producto tendremos la respuesta correcta
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        
        Producto producto = this.productoServicio.buscarProductoPorId(id);

        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el id " + id);
        }

    }
}
