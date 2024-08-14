package model.NotasRequest;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class ItemDTO implements Serializable {

	@SerializedName("NUNOTA")
	private NUNOTADTO nUNOTA;

	@SerializedName("CODPROD")
	private CODPRODDTO cODPROD;

	@SerializedName("QTDNEG")
	private QTDNEGDTO qTDNEG;

	@SerializedName("CODLOCALORIG")
	private CODLOCALORIGDTO cODLOCALORIG;

	@SerializedName("CODVOL")
	private CODVOLDTO cODVOL;

	@SerializedName("PERCDESC")
	private PERCDESCDTO pERCDESC;

	@SerializedName("VLRUNIT")
	private VLRUNITDTO vLRUNIT;
//----------------------------------------------
	@SerializedName("SEQUENCIA")
	private SEQUENCIA sEQUENCIA;

	@SerializedName("ATUALESTOQUE")
	private ATUALESTOQUE aTUALESTOQUE;

	@SerializedName("ATUALESTTERC")
	private ATUALESTTERC aTUALESTTERC;

	@SerializedName("CONTROLE")
	private CONTROLE cONTROLE;

	@SerializedName("USOPROD")
	private USOPROD uSOPROD;

	@SerializedName("CODUSU")
	private CODUSU cODUSU;

	public void setNUNOTA(NUNOTADTO nUNOTA){
		this.nUNOTA = nUNOTA;
	}

	public NUNOTADTO getNUNOTA(){
		return nUNOTA;
	}

	public void setCODPROD(CODPRODDTO cODPROD){
		this.cODPROD = cODPROD;
	}

	public CODPRODDTO getCODPROD(){
		return cODPROD;
	}

	public void setQTDNEG(QTDNEGDTO qTDNEG){
		this.qTDNEG = qTDNEG;
	}

	public QTDNEGDTO getQTDNEG(){
		return qTDNEG;
	}

	public void setCODLOCALORIG(CODLOCALORIGDTO cODLOCALORIG){
		this.cODLOCALORIG = cODLOCALORIG;
	}

	public CODLOCALORIGDTO getCODLOCALORIG(){
		return cODLOCALORIG;
	}

	public void setCODVOL(CODVOLDTO cODVOL){
		this.cODVOL = cODVOL;
	}

	public CODVOLDTO getCODVOL(){
		return cODVOL;
	}

	public void setPERCDESC(PERCDESCDTO pERCDESC){
		this.pERCDESC = pERCDESC;
	}

	public PERCDESCDTO getPERCDESC(){
		return pERCDESC;
	}

	public void setVLRUNIT(VLRUNITDTO vLRUNIT){
		this.vLRUNIT = vLRUNIT;
	}

	public VLRUNITDTO getVLRUNIT(){
		return vLRUNIT;
	}

	public USOPROD getuSOPROD() {
		return uSOPROD;
	}

	public void setuSOPROD(USOPROD uSOPROD) {
		this.uSOPROD = uSOPROD;
	}

	public CODUSU getcODUSU() {
		return cODUSU;
	}

	public void setcODUSU(CODUSU cODUSU) {
		this.cODUSU = cODUSU;
	}

	public SEQUENCIA getsEQUENCIA() {
		return sEQUENCIA;
	}

	public void setsEQUENCIA(SEQUENCIA sEQUENCIA) {
		this.sEQUENCIA = sEQUENCIA;
	}

	public ATUALESTOQUE getaTUALESTOQUE() {
		return aTUALESTOQUE;
	}

	public void setaTUALESTOQUE(ATUALESTOQUE aTUALESTOQUE) {
		this.aTUALESTOQUE = aTUALESTOQUE;
	}

	public ATUALESTTERC getaTUALESTTERC() {
		return aTUALESTTERC;
	}

	public void setaTUALESTTERC(ATUALESTTERC aTUALESTTERC) {
		this.aTUALESTTERC = aTUALESTTERC;
	}

	public CONTROLE getcONTROLE() {
		return cONTROLE;
	}

	public void setcONTROLE(CONTROLE cONTROLE) {
		this.cONTROLE = cONTROLE;
	}

	public CODVOLDTO getcODVOL() {
		return cODVOL;
	}

	public void setcODVOL(CODVOLDTO cODVOL) {
		this.cODVOL = cODVOL;
	}
}