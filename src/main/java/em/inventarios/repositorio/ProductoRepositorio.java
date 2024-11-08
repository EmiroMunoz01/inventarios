package em.inventarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import em.inventarios.modelo.Producto;
//tenemos los metodos para comunicarnos en la base de datos, los metodos CRUD, esta es la capa de acceso a datos
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
