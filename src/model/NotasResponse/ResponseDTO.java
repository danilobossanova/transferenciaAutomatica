package model.NotasResponse;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ResponseDTO implements Serializable {

	@SerializedName("serviceName")
	private String serviceName;

	@SerializedName("status")
	private String status;

	@SerializedName("pendingPrinting")
	private String pendingPrinting;

	@SerializedName("transactionId")
	private String transactionId;

	@SerializedName("responseBody")
	private ResponseBodyDTO responseBody;

	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}

	public String getServiceName(){
		return serviceName;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setPendingPrinting(String pendingPrinting){
		this.pendingPrinting = pendingPrinting;
	}

	public String getPendingPrinting(){
		return pendingPrinting;
	}

	public void setTransactionId(String transactionId){
		this.transactionId = transactionId;
	}

	public String getTransactionId(){
		return transactionId;
	}

	public void setResponseBody(ResponseBodyDTO responseBody){
		this.responseBody = responseBody;
	}

	public ResponseBodyDTO getResponseBody(){
		return responseBody;
	}
}