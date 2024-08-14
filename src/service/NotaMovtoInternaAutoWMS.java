package service;

import br.com.sankhya.dwf.services.ServiceUtils;
import br.com.sankhya.mgecomercial.model.centrais.cac.CACSP;
import br.com.sankhya.mgecomercial.model.centrais.cac.CACSPHome;
import br.com.sankhya.modelcore.auth.AuthenticationInfo;
import br.com.sankhya.ws.ServiceContext;
import com.sankhya.util.XMLUtils;
import org.jdom.Element;

import java.math.BigDecimal;

public class NotaMovtoInternaAutoWMS {

    public static void GerarNota() {

        //TWITT, tarefa de armazenamento finalizada.




    }

    public static void confirmaNota(BigDecimal nunota) throws Exception {

        ServiceContext ctx = new ServiceContext(null);
        CACSP cacsp = (CACSP) ServiceUtils.getStatelessFacade(CACSPHome.JNDI_NAME, CACSPHome.class);

        try {

            Element elementParams = new Element("nota");
            XMLUtils.addAttributeElement(elementParams, "confirmacaoCentralNota", "true");
            XMLUtils.addAttributeElement(elementParams, "ehPedidoWeb", "false");
            XMLUtils.addAttributeElement(elementParams, "atualizaPrecoItemPedCompra", "false");
            XMLUtils.addAttributeElement(elementParams, "ownerServiceCall", "CentralNotas");

            XMLUtils.addContentElement(elementParams, "NUNOTA", nunota);

            AuthenticationInfo auth = AuthenticationInfo.getCurrent();
            auth.makeCurrent();

            ctx.setRequestBody(new Element("requestBody"));

            Element requestBody = ctx.getRequestBody();
            requestBody.removeContent();
            requestBody = ctx.getRequestBody();
            requestBody.addContent(elementParams);

            XMLUtils.printFromDebug(requestBody);
            ctx.setRequestBody(requestBody);

            cacsp.confirmarNota(ctx);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
