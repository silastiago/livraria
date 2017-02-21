package com.ibcj.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ibcj.model.Venda;
import com.ibcj.repository.Vendas;
import com.ibcj.util.cdi.CDIServiceLocator;


@FacesConverter(forClass=Venda.class)
public class VendaConversor implements Converter{

	private Vendas vendas;

	public VendaConversor() {
		vendas = CDIServiceLocator.getBean(Vendas.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Venda retorno = null;			

		if (value != null) {
			retorno = vendas.porCodigo(new Integer(value));
		}

		return retorno;
	}


	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Venda venda = (Venda) value;
			return venda.getCodigo() == null ? null : venda.getCodigo().toString();

		}

		return null;
	}

}