package model.NotasResponse;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class PkDTO implements Serializable {

	@SerializedName("NUNOTA")
	private NUNOTADTO nUNOTA;

	public void setNUNOTA(NUNOTADTO nUNOTA){
		this.nUNOTA = nUNOTA;
	}

	public NUNOTADTO getNUNOTA(){
		return nUNOTA;
	}
}