package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class RequestDTO implements Serializable {

	@SerializedName("serviceName")
	private String serviceName;

	@SerializedName("requestBody")
	private RequestBodyDTO requestBody;

	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}

	public String getServiceName(){
		return serviceName;
	}

	public void setRequestBody(RequestBodyDTO requestBody){
		this.requestBody = requestBody;
	}

	public RequestBodyDTO getRequestBody(){
		return requestBody;
	}
}