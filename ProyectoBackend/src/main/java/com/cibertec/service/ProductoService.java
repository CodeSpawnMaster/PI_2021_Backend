package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.cibertec.entity.Producto;

public interface ProductoService {
	public abstract List<Producto> listaProducto();
	public abstract Producto insertaActualizaProducto(Producto obj,List<MultipartFile> lstFoto);
	public abstract Optional<Producto> obtienePorId(int idProducto);
}
