package com.sv.grupo3.restaurante.service;

import com.sv.grupo3.restaurante.model.ItemMenu;
import com.sv.grupo3.restaurante.repository.ProductoRepository;
import java.util.List;

/**
 * Lógica de Negocio para el menú.
 * Validado por: José Alfredo Rodríguez (Business Analyst)
 * Cumple con: HU-001 (Registrar y actualizar productos del menú)
 */
public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Validación de Negocio para HU-001: El producto debe tener datos válidos
    public void registrarProducto(ItemMenu producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Error de Negocio: El producto no puede estar vacío.");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Error de Negocio: El nombre del producto es obligatorio.");
        }
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("Error de Negocio: El precio debe ser mayor a $0.00.");
        }
        
        productoRepository.guardar(producto);
        System.out.println("Regla de negocio aprobada: Producto '" + producto.getNombre() + "' registrado con éxito.");
    }

    // Validación de Negocio para HU-001: Filtrar por categorías
    public List<ItemMenu> listarPorCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Error de Negocio: Debe especificar una categoría válida para filtrar.");
        }
        return productoRepository.buscarPorCategoria(categoria);
    }
}