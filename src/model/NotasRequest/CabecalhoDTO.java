package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class CabecalhoDTO implements Serializable {

	@SerializedName("NUNOTA")
	private NUNOTADTO nUNOTA;

	@SerializedName("CODPARC")
	private CODPARCDTO cODPARC;

	@SerializedName("DTNEG")
	private DTNEGDTO dTNEG;

	@SerializedName("CODTIPOPER")
	private CODTIPOPERDTO cODTIPOPER;

	@SerializedName("CODTIPVENDA")
	private CODTIPVENDADTO cODTIPVENDA;

	@SerializedName("CODVEND")
	private CODVENDDTO cODVEND;

	@SerializedName("CODEMP")
	private CODEMPDTO cODEMP;

	@SerializedName("TIPMOV")
	private TIPMOVDTO tIPMOV;

	@SerializedName("CODNAT")
	private CODNATDTO cODNAT;

	@SerializedName("CODCENCUS")
	private CODCENCUSDTO cODCENCUS;

	public void setNUNOTA(NUNOTADTO nUNOTA){
		this.nUNOTA = nUNOTA;
	}

	public NUNOTADTO getNUNOTA(){
		return nUNOTA;
	}

	public void setCODPARC(CODPARCDTO cODPARC){
		this.cODPARC = cODPARC;
	}

	public CODPARCDTO getCODPARC(){
		return cODPARC;
	}

	public void setDTNEG(DTNEGDTO dTNEG){
		this.dTNEG = dTNEG;
	}

	public DTNEGDTO getDTNEG(){
		return dTNEG;
	}

	public void setCODTIPOPER(CODTIPOPERDTO cODTIPOPER){
		this.cODTIPOPER = cODTIPOPER;
	}

	public CODTIPOPERDTO getCODTIPOPER(){
		return cODTIPOPER;
	}

	public void setCODTIPVENDA(CODTIPVENDADTO cODTIPVENDA){
		this.cODTIPVENDA = cODTIPVENDA;
	}

	public CODTIPVENDADTO getCODTIPVENDA(){
		return cODTIPVENDA;
	}

	public void setCODVEND(CODVENDDTO cODVEND){
		this.cODVEND = cODVEND;
	}

	public CODVENDDTO getCODVEND(){
		return cODVEND;
	}

	public void setCODEMP(CODEMPDTO cODEMP){
		this.cODEMP = cODEMP;
	}

	public CODEMPDTO getCODEMP(){
		return cODEMP;
	}

	public void setTIPMOV(TIPMOVDTO tIPMOV){
		this.tIPMOV = tIPMOV;
	}

	public TIPMOVDTO getTIPMOV(){
		return tIPMOV;
	}

	public CODNATDTO getcODNAT() {
		return cODNAT;
	}

	public void setcODNAT(CODNATDTO cODNAT) {
		this.cODNAT = cODNAT;
	}

	public CODCENCUSDTO getcODCENCUS() {
		return cODCENCUS;
	}

	public void setcODCENCUS(CODCENCUSDTO cODCENCUS) {
		this.cODCENCUS = cODCENCUS;
	}
}