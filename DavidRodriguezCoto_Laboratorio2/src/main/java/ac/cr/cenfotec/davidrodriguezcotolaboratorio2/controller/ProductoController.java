package ac.cr.cenfotec.davidrodriguezcotolaboratorio2.controller;

import ac.cr.cenfotec.davidrodriguezcotolaboratorio2.entity.Producto;
import ac.cr.cenfotec.davidrodriguezcotolaboratorio2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("productoNombre/{nombre}")
    public List<Producto> getProductosByNombre(@PathVariable(value = "nombre") String nombre){
        return productoRepository.findByNombre(nombre);
    }

    @GetMapping("producto/{id}")
    public Optional<Producto> getProducto(@PathVariable(value = "id") Integer id)
    {
        return productoRepository.findById(id);
    }

    @PostMapping("producto")
    public Producto addProdructo(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("producto/{id}")
    public ResponseEntity<Producto> modifyProducto(@PathVariable(value = "id") Integer id, @RequestBody Producto producto){
        Optional<Producto> result = productoRepository.findById(id);
        if (result.isPresent()){
            result.get().setNombre(producto.getNombre());
            result.get().setDescripcion(producto.getDescripcion());
            result.get().setCantidad(producto.getCantidad());
            result.get().setPrecio(producto.getPrecio());
            Producto updatedProducto = productoRepository.save(result.get());

            return ResponseEntity.ok(updatedProducto);
        }
        return null;
    }
    @DeleteMapping("producto/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable(value = "id") Integer id){
        productoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
