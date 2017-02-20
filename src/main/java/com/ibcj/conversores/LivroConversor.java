package com.ibcj.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Livro;
import com.ibcj.repository.Livros;
import com.ibcj.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Livro.class)
public class LivroConversor implements Converter{

	private Livros livros;

	public LivroConversor() {
		livros = CDIServiceLocator.getBean(Livros.class);
	}
	
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Livro retorno = null;
			
		if (value != null) {
			retorno = livros.porCodigo(new Integer(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			Livro livro = (Livro) value;
			return livro.getCodigo() == null ? null : livro.getCodigo().toString();

		}

		return null;
	}

}