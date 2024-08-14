package actions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.sankhya.jape.vo.DynamicVOPojo;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;
import br.com.sankhya.modelcore.util.ListenerParameters;
import com.sankhya.util.Base64Impl;
import com.sankhya.util.TimeUtils;

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.dao.JdbcWrapper;
import br.com.sankhya.jape.sql.NativeSql;
import br.com.sankhya.jape.util.JapeSessionContext;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.jape.vo.PrePersistEntityState;
import br.com.sankhya.modelcore.auth.AuthenticationInfo;
import br.com.sankhya.modelcore.comercial.BarramentoRegra;
import br.com.sankhya.modelcore.comercial.centrais.CACHelper;
import br.com.sankhya.modelcore.util.DynamicEntityNames;
import dao.MovInternaAutoDAO;
import model.TransfCabModel;
import model.TransfIteModel;
import service.NotaMovtoInternaAutoWMS;

public class BotaoGeraNotaJape implements AcaoRotinaJava {

    @Override
    public void doAction(ContextoAcao ca) throws Exception {

//        ca.confirmar("Confirmação" , "Confirma gerar nota de transferência ?" ,1);

        BigDecimal nuNota = new BigDecimal(0);

        List<TransfCabModel> listCabTransf = MovInternaAutoDAO.consultaCabArmParciaisFinalizados();

        for (TransfCabModel cabTransf : listCabTransf) {

            try {

                EntityFacade dwfEntityFacade = EntityFacadeFactory.getDWFFacade();
                AuthenticationInfo auth = AuthenticationInfo.getCurrent();

                DynamicVO cabVO = (DynamicVO) dwfEntityFacade.getDefaultValueObjectInstance("CabecalhoNota");

                cabVO.setProperty("CODEMP", BigDecimal.valueOf(11L));
                cabVO.setProperty("CODTIPOPER", BigDecimal.valueOf(1353L));
                cabVO.setProperty("TIPMOV", "T");
                cabVO.setProperty("CODPARC", BigDecimal.valueOf(521549L));
                cabVO.setProperty("CODTIPVENDA", BigDecimal.ZERO);
                cabVO.setProperty("DTNEG", TimeUtils.getNow());
                cabVO.setProperty("CODVEND", BigDecimal.ZERO);
                cabVO.setProperty("CODNAT", BigDecimal.valueOf(10101003L));
                cabVO.setProperty("CODCENCUS", BigDecimal.valueOf(11200L));

                CACHelper cacHelper = new CACHelper();

                JapeSessionContext.putProperty(ListenerParameters.CENTRAIS, Boolean.TRUE);

                PrePersistEntityState cabPreState = PrePersistEntityState.build(dwfEntityFacade,
                        DynamicEntityNames.CABECALHO_NOTA, cabVO);

                BarramentoRegra bRegrasCab = cacHelper.incluirAlterarCabecalho(auth, cabPreState);


                DynamicVO newCabVO = bRegrasCab.getState().getNewVO();
                nuNota = newCabVO.asBigDecimal("NUNOTA");
                System.out.println("[NUNOTA] " + nuNota);

                List<TransfIteModel> listTransf = MovInternaAutoDAO.consultaArmParciaisFinalizados(cabTransf.getNutarefa());
                Collection<PrePersistEntityState> itensNota = new ArrayList<PrePersistEntityState>();

                for (TransfIteModel transf : listTransf) {

                    DynamicVO itemVO_Orig = new DynamicVOPojo();
                    itemVO_Orig = (DynamicVO) dwfEntityFacade.getDefaultValueObjectInstance(DynamicEntityNames.ITEM_NOTA);

                    itemVO_Orig.setProperty("NUNOTA", nuNota);
                    itemVO_Orig.setProperty("CODEMP", transf.getCodemp());
                    itemVO_Orig.setProperty("CODPROD", transf.getCodprod());
                    itemVO_Orig.setProperty("QTDNEG", transf.getQtdneg());
                    itemVO_Orig.setProperty("CODLOCALORIG", transf.getCodlocalorig());
                    itemVO_Orig.setProperty("CODLOCALDEST", transf.getCodlocaldest());
                    itemVO_Orig.setProperty("CODVOL", transf.getCodvol());
                    itemVO_Orig.setProperty("USOPROD", transf.getUsoprod());
                    itemVO_Orig.setProperty("CODUSU", BigDecimal.ZERO);

                    PrePersistEntityState itePreStateOrig = PrePersistEntityState.build(dwfEntityFacade,
                            DynamicEntityNames.ITEM_NOTA, itemVO_Orig);
                    itensNota.add(itePreStateOrig);
                }

                cacHelper.incluirAlterarItem(nuNota, auth, itensNota, true);

            } catch (Exception e) {
                ca.setMensagemRetorno("Erro : " + e.getMessage() + " \n\n <b>Ação cancelada!</b>");
                System.out.println("[erro]" + e.getMessage());
                e.printStackTrace();

                if (nuNota.floatValue() > 0) {
                    excluirNota(nuNota);

                }

            }

        }

        // Marca nunotas na TGWTAR
        for (TransfCabModel cabTransf2 : listCabTransf) {
            try {
                MovInternaAutoDAO.marcaTarefasFinalizadas(cabTransf2.getNutarefa(), cabTransf2.getNunota());

            } catch (Exception e) {
                ca.setMensagemRetorno("Erro : " + e.getMessage() + " \n\n <b>Ação cancelada!</b>");
                System.out.println("[erro]" + e.getMessage());
                e.printStackTrace();

            }

        }

        ca.setMensagemRetorno("Notas de Transferências geradas com sucesso.");
        //ca.setMensagemRetorno("Notas de Transferências " + this.getLinkNota(nuNota.toString(), nuNota)  + " gerado com sucesso.");

    }

    private void excluirNota(BigDecimal nuNota) throws Exception {
        JdbcWrapper jdbc = null;
        NativeSql sql = null;
        NativeSql sql2 = null;

        EntityFacade entityFacade = EntityFacadeFactory.getDWFFacade();
        jdbc = entityFacade.getJdbcWrapper();

        sql = new NativeSql(jdbc);
        sql.appendSql ("DELETE FROM TGFITE WHERE NUNOTA = :NUNOTA ");
        sql.setNamedParameter("NUNOTA", nuNota);

        sql.executeUpdate();

        sql2 = new NativeSql(jdbc);
        sql2.appendSql ("DELETE FROM TGFCAB WHERE NUNOTA = :NUNOTA ");
        sql2.setNamedParameter("NUNOTA", nuNota);

        sql2.executeUpdate();


    }


    private String getLinkNota(final String descricao, final BigDecimal nuNota) {
        final String pk = "{\"NUNOTA\":\"{0}\"}".replace("{0}", nuNota.toString());
        String url = "<a title=\"Abrir Tela\" href=\"/mge/system.jsp#app/{0}/{1}\" target=\"_top\"><u><b>{2}</b></u></a>"
                .replace("{0}", Base64Impl.encode("br.com.sankhya.com.mov.CentralNotas".getBytes()).trim());
        url = url.replace("{1}", Base64Impl.encode(pk.getBytes()).trim());
        url = url.replace("{2}", descricao);
        return url;
    }

}
