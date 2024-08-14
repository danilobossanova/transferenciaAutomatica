package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class CODUSU implements Serializable {

	@SerializedName("$")
	private String dolar;

	public void set(String dol){
		this.dolar = dol;
	}

	public String get(){
		return dolar;
	}
}