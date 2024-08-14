package actions;

import com.google.gson.Gson;
import model.NotasRequest.*;

import java.util.ArrayList;
import java.util.List;

public class TesteNotas {

    public static void main(String[] args) {

        String request = "{\"serviceName\":\"CACSP.incluirNota\",\"requestBody\":{\"nota\":{\"cabecalho\":{\"NUNOTA\":{},\"CODPARC\":{\"$\":\"1\"},\"DTNEG\":{\"$\":\"09/12/2022\"},\"CODTIPOPER\":{\"$\":\"2000\"},\"CODTIPVENDA\":{\"$\":\"12\"},\"CODVEND\":{\"$\":\"0\"},\"CODEMP\":{\"$\":\"1\"},\"TIPMOV\":{\"$\":\"O\"}},\"itens\":{\"INFORMARPRECO\":\"True\",\"item\":[{\"NUNOTA\":{},\"CODPROD\":{\"$\":\"8\"},\"QTDNEG\":{\"$\":\"1\"},\"CODLOCALORIG\":{\"$\":\"0\"},\"CODVOL\":{\"$\":\"UN\"},\"PERCDESC\":{\"$\":\"0\"},\"VLRUNIT\":{\"$\":\"1.75\"}}]}}}}";
        String response = "{\"serviceName\":\"CACSP.incluirNota\",\"status\":\"1\",\"pendingPrinting\":\"false\",\"transactionId\":\"1484EE05236C4B33DE6355DAA8443EFF\",\"responseBody\":{\"pk\":{\"NUNOTA\":{\"$\":\"740\"}}}}";

        RequestDTO requestDTO = new RequestDTO();
        RequestBodyDTO requestBodyDTO = new RequestBodyDTO();

        // Campos de cabeçalho
        CODEMPDTO codempdto = new CODEMPDTO();
        CODPARCDTO codparcdto = new CODPARCDTO();
        NUNOTADTO nunotadto = new NUNOTADTO();
        DTNEGDTO dtnegdto = new DTNEGDTO();
        CODTIPOPERDTO codtipoperdto = new CODTIPOPERDTO();
        CODTIPVENDADTO codtipvendadto = new CODTIPVENDADTO();
        CODVENDDTO codvenddto = new CODVENDDTO();
        TIPMOVDTO tipmovdto = new TIPMOVDTO();

        codempdto.set("1");
        codparcdto.set("521549");
        dtnegdto.set("30/04/2024");
        codtipoperdto.set("1007");
        codtipvendadto.set("0");
        codvenddto.set("42");
        tipmovdto.set("Q");

        CabecalhoDTO cabecalhoDTO = new CabecalhoDTO();
        cabecalhoDTO.setNUNOTA(nunotadto);
        cabecalhoDTO.setCODEMP(codempdto);
        cabecalhoDTO.setCODPARC(codparcdto);
        cabecalhoDTO.setDTNEG(dtnegdto);
        cabecalhoDTO.setCODTIPOPER(codtipoperdto);
        cabecalhoDTO.setCODTIPVENDA(codtipvendadto);
        cabecalhoDTO.setCODVEND(codvenddto);
        cabecalhoDTO.setTIPMOV(tipmovdto);

        // Item 1
        CODLOCALORIGDTO codlocalorigdto = new CODLOCALORIGDTO();
        CODPRODDTO codproddto = new CODPRODDTO();
        CODVOLDTO codvoldto = new CODVOLDTO();
        PERCDESCDTO percdescdto = new PERCDESCDTO();
        QTDNEGDTO qtdnegdto = new QTDNEGDTO();
        VLRUNITDTO vlrunitdto = new VLRUNITDTO();

        ItemDTO itemDTO = new ItemDTO();
        codlocalorigdto.set("910000000");
        codproddto.set("1953");
        codvoldto.set("UN");
        percdescdto.set("0");
        qtdnegdto.set("5");
        vlrunitdto.set("123.32");

        itemDTO.setNUNOTA(nunotadto);
        itemDTO.setCODLOCALORIG(codlocalorigdto);
        itemDTO.setCODPROD(codproddto);
        itemDTO.setCODVOL(codvoldto);
        itemDTO.setPERCDESC(percdescdto);
        itemDTO.setQTDNEG(qtdnegdto);
        itemDTO.setVLRUNIT(vlrunitdto);

        List<ItemDTO> listaItens = new ArrayList<>();
        listaItens.add(itemDTO);

        ItensDTO itensDTO = new ItensDTO();
        itensDTO.setItem(listaItens);
        itensDTO.setINFORMARPRECO("False");

        NotaDTO notaDTO = new NotaDTO();
        notaDTO.setCabecalho(cabecalhoDTO);
        notaDTO.setItens(itensDTO);

        requestBodyDTO.setNota(notaDTO);

        requestDTO.setServiceName("CACSP.incluirNota");
        requestDTO.setRequestBody(requestBodyDTO);

        Gson gson = new Gson();
        String json = gson.toJson(requestDTO);

        System.out.println("json: " + json);

//        Gson gson = new Gson();
//        JsonObject paramsObj = JsonUtils.convertStringToJsonObject(gson.toJson(request));
//        ctx = ServiceContext.getCurrent();
//        JsonObject requestBody = ctx.getJsonRequestBody();
//        contextoAcao.setMensagemRetorno(JsonUtils.converteObjectToString(requestBody));

    }

}
