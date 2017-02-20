package com.ibcj.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Autor;
import com.ibcj.repository.Autores;
import com.ibcj.util.cdi.CDIServiceLocator;


@FacesConverter(value="autorConverter")
public class AutorConversor implements Converter{

	private Autores autores;

	public AutorConversor() {
		autores = CDIServiceLocator.getBean(Autores.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Autor retorno = null;			

		if (value != null) {
			retorno = autores.porCodigo(new Integer(value));
		}

		return retorno;
	}


	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Autor autor = (Autor) value;
			return autor.getCodigo() == null ? null : autor.getCodigo().toString();

		}

		return null;
	}

}