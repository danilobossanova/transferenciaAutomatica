package dao;

import br.com.sankhya.jape.EntityFacade;
import br.com.sankhya.jape.bmp.PersistentLocalEntity;
import br.com.sankhya.jape.dao.JdbcWrapper;
import br.com.sankhya.jape.sql.NativeSql;
import br.com.sankhya.jape.vo.DynamicVO;
import br.com.sankhya.jape.vo.EntityVO;
import br.com.sankhya.modelcore.util.DynamicEntityNames;
import br.com.sankhya.modelcore.util.EntityFacadeFactory;
import model.TransfCabModel;
import model.TransfIteModel;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovInternaAutoDAO {

    public static List<TransfCabModel> consultaCabArmParciaisFinalizados() throws Exception {

        final EntityFacade entityFacade = EntityFacadeFactory.getDWFFacade();
        final JdbcWrapper jdbcWrapper = entityFacade.getJdbcWrapper();

        List<TransfCabModel> listTransf = new ArrayList<>();

        final NativeSql nativeSql = new NativeSql(jdbcWrapper);
        try {
            nativeSql.appendSql("SELECT DISTINCT NUNOTA, NUTAREFA\n" +
                                "  FROM VW_WMSTRANSFLOC01_DCCO\n" +
                                " ORDER BY NUTAREFA");

            final ResultSet resultSet = nativeSql.executeQuery();
            while (resultSet.next()) {
                TransfCabModel cab = new TransfCabModel();
                cab.setNunota(resultSet.getBigDecimal("NUNOTA"));
                cab.setNutarefa(resultSet.getBigDecimal("NUTAREFA"));
                listTransf.add(cab);
            }

        } finally {
            JdbcWrapper.closeSession(jdbcWrapper);
        }

        return listTransf;
    }

    public static List<BigDecimal> consultaNotasTransConfirmar() throws Exception {

        final EntityFacade entityFacade = EntityFacadeFactory.getDWFFacade();
        final JdbcWrapper jdbcWrapper = entityFacade.getJdbcWrapper();

        List<BigDecimal> listTransf = new ArrayList<>();

        final NativeSql nativeSql = new NativeSql(jdbcWrapper);
        try {
            nativeSql.appendSql("SELECT NUNOTA\n" +
                                "  FROM VW_WMSTRANSFLOC02_DCCO\n" +
                                " ORDER BY NUNOTA");

            final ResultSet resultSet = nativeSql.executeQuery();
            while (resultSet.next()) {
                listTransf.add(resultSet.getBigDecimal("NUNOTA"));
            }

        } finally {
            JdbcWrapper.closeSession(jdbcWrapper);
        }

        return listTransf;
    }


    public static List<TransfIteModel> consultaArmParciaisFinalizados(BigDecimal nutarefa) throws Exception {

        final EntityFacade entityFacade = EntityFacadeFactory.getDWFFacade();
        final JdbcWrapper jdbcWrapper = entityFacade.getJdbcWrapper();

        List<TransfIteModel> listTransf = new ArrayList<>();

        final NativeSql nativeSql = new NativeSql(jdbcWrapper);
        try {
            nativeSql.appendSql("SELECT CODEMP,\n" +
                                "       NUNOTA,\n" +
                                "       CODPARCEMP,\n" +
                                "       NUTAREFA,\n" +
                                "       SEQUENCIA,\n" +
                                "       CODTAREFA,\n" +
                                "       SITTAR,\n" +
                                "       DTTAREFA,\n" +
                                "       CODUSU,\n" +
                                "       CODPROD,\n" +
                                "       USOPROD,\n" +
                                "       CODVOL,\n" +
                                "       QTDDEST,\n" +
                                "       CODLOCALORIG,\n" +
                                "       CODLOCALDEST\n" +
                                "  FROM VW_WMSTRANSFLOC01_DCCO\n" +
                                " WHERE NUTAREFA = " + nutarefa.toString() +
                                " ORDER BY NUTAREFA, SEQUENCIA");

            final ResultSet resultSet = nativeSql.executeQuery();
            while (resultSet.next()) {
                TransfIteModel transf = new TransfIteModel();

                transf.setCodemp(resultSet.getBigDecimal("CODEMP"));
                transf.setCodparcEmp(resultSet.getBigDecimal("CODPARCEMP"));
                transf.setCodprod(resultSet.getBigDecimal("CODPROD"));
                transf.setCodtarefa(resultSet.getBigDecimal("CODTAREFA"));
                transf.setCodvol(resultSet.getString("CODVOL"));
                transf.setUsoprod(resultSet.getString("USOPROD"));
                transf.setNutarefa(resultSet.getBigDecimal("NUTAREFA"));
                transf.setQtdneg(resultSet.getBigDecimal("QTDDEST"));
                transf.setSequencia(resultSet.getBigDecimal("SEQUENCIA"));
                transf.setCodlocalorig(resultSet.getBigDecimal("CODLOCALORIG"));
                transf.setCodlocaldest(resultSet.getBigDecimal("CODLOCALDEST"));

                listTransf.add(transf);
            }

        } finally {
            JdbcWrapper.closeSession(jdbcWrapper);
        }

        return listTransf;
    }

    public static void marcaTarefasFinalizadas(BigDecimal nutarefa, BigDecimal nunota) throws Exception {

        final EntityFacade entityFacade = EntityFacadeFactory.getDWFFacade();

        try {

            PersistentLocalEntity entityFinVO = entityFacade.findEntityByPrimaryKey(DynamicEntityNames.TAREFA, nutarefa);
            EntityVO voFinanceiro = entityFinVO.getValueObject();
            DynamicVO regFinVO = (DynamicVO) voFinanceiro;

            regFinVO.setProperty("AD_NUNOTATRANSF", nunota);
            entityFinVO.setValueObject((EntityVO) regFinVO);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro em marcaTarefasFinalizadas: " + ex.getMessage());
        }

    }

//        jdbcWrapper.openSession();
//
//        final NativeSql nativeSql = new NativeSql(jdbcWrapper);
//        try {
//            nativeSql.appendSql("SELECT DISTINCT NUTAREFA\n" +
//                                "  FROM VW_WMSTRANSFLOCAUTO_DCCO\n" +
//                                " WHERE NUNOTA = " + nunota.toString());
//
//            final ResultSet resultSet = nativeSql.executeQuery();
//            while (resultSet.next()) {
//
//                final String sql = "" +
//                        "begin " +
//                        "UPDATE TGWTAR SET AD_NUNOTATRANSF = " + nunota.toString() +
//                        " WHERE NUTAREFA = " +resultSet.getBigDecimal("NUTAREFA").toString() + "; commit;" +
//                        "end;";
//                final Connection connection = jdbcWrapper.getConnection();
//
//                try (final CallableStatement callableStatement = connection.prepareCall(sql)) {
//                    callableStatement.execute();
//                }
//
//            }


}
