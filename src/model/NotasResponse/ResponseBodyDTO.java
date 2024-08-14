package model.NotasResponse;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ResponseBodyDTO implements Serializable {

	@SerializedName("pk")
	private PkDTO pk;

	public void setPk(PkDTO pk){
		this.pk = pk;
	}

	public PkDTO getPk(){
		return pk;
	}
}