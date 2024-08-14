package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class RequestBodyDTO implements Serializable {

	@SerializedName("nota")
	private NotaDTO nota;

	public void setNota(NotaDTO nota){
		this.nota = nota;
	}

	public NotaDTO getNota(){
		return nota;
	}
}