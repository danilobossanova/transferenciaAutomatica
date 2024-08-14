package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class ItensDTO implements Serializable {

	@SerializedName("INFORMARPRECO")
	private String iNFORMARPRECO;

	@SerializedName("item")
	private List<ItemDTO> item;

	public void setINFORMARPRECO(String iNFORMARPRECO){
		this.iNFORMARPRECO = iNFORMARPRECO;
	}

	public String getINFORMARPRECO(){
		return iNFORMARPRECO;
	}

	public void setItem(List<ItemDTO> item){
		this.item = item;
	}

	public List<ItemDTO> getItem(){
		return item;
	}
}