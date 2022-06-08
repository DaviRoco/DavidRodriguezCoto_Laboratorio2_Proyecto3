package ac.cr.cenfotec.davidrodriguezcotolaboratorio2.repository;

import ac.cr.cenfotec.davidrodriguezcotolaboratorio2.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT c FROM Producto c WHERE c.nombre like %?1%")
    List<Producto> findByNombre(String nombre);
}
