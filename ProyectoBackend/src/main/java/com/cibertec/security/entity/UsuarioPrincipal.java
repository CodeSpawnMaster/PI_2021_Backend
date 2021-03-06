package com.cibertec.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cibertec.entity.Usuario;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

public class UsuarioPrincipal implements UserDetails {
	
	private String nombreUsuario;
    private String password;
	private String nombre;
	private String paterno;
	private String materno;
	private String dni;
	private String direccion;
	private String celular;
	private String email; 
	private String ruc;
	private String razonSocial;
    private Collection<? extends GrantedAuthority> authorities;

   

    public UsuarioPrincipal(String nombreUsuario, String password, String nombre, String paterno, String materno,
			String dni, String direccion, String celular, String email, String ruc, String razonSocial,
			Collection<? extends GrantedAuthority> authorities) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.dni = dni;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.authorities = authorities;
	}

	public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombreUsuario(),usuario.getPassword(),usuario.getNombre() ,usuario.getPaterno(),
        		usuario.getMaterno(), usuario.getDni(), usuario.getDireccion(), usuario.getCelular(),usuario.getEmail(), usuario.getRuc(), usuario.getRazonSocial(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPaterno() {
        return paterno;
    }
    public String getMaterno() {
        return materno;
    }
    public String getDni() {
        return dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCelular() {
        return celular;
    }
    public String getRuc() {
        return ruc;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    
}
