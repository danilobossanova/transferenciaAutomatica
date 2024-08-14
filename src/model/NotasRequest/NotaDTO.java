package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class NotaDTO implements Serializable {

	@SerializedName("cabecalho")
	private CabecalhoDTO cabecalho;

	@SerializedName("itens")
	private ItensDTO itens;

	public void setCabecalho(CabecalhoDTO cabecalho){
		this.cabecalho = cabecalho;
	}

	public CabecalhoDTO getCabecalho(){
		return cabecalho;
	}

	public void setItens(ItensDTO itens){
		this.itens = itens;
	}

	public ItensDTO getItens(){
		return itens;
	}
}