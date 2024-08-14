package actions;

import dao.MovInternaAutoDAO;
import model.TransfCabModel;
import org.cuckoo.core.ScheduledAction;
import org.cuckoo.core.ScheduledActionContext;
import service.NotaMovtoInternaAutoWMS;

import java.math.BigDecimal;
import java.util.List;

public class ScheduleConfirmaNotaMovtoInternaAutoWMS implements ScheduledAction {
    @Override
    public void onTime(ScheduledActionContext scheduledActionContext) {

        List<BigDecimal> listCabConfirmar = null;
        try {
            listCabConfirmar = MovInternaAutoDAO.consultaNotasTransConfirmar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (BigDecimal cabConfirmar : listCabConfirmar) {

            try {
                NotaMovtoInternaAutoWMS.confirmaNota(cabConfirmar);

            } catch (Exception exception) {
                System.out.println("Erro em ScheduleConfirmaNotaMovtoInternaAutoWMS: " + exception.getMessage());
                exception.printStackTrace();
            }

        }
    }
}
