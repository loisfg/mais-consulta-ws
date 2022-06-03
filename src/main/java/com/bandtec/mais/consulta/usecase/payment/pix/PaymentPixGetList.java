package com.bandtec.mais.consulta.usecase.payment.pix;

import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;
import com.bandtec.mais.consulta.Credentials;
import com.bandtec.mais.consulta.usecase.payment.IPaymentGet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class
PaymentPixGetList implements IPaymentGet {
    @Override
    public Map<String, Object> execute(Credentials credentials) {
        HashMap<String, Object> options = new HashMap<>();
        options.put("client_id", credentials.getClientId());
        options.put("client_secret", credentials.getClientSecret());
        options.put("pix_cert", credentials.getCertificadoPix());
        options.put("sandbox", credentials.isSandbox());

        HashMap<String, String> params = new HashMap<>();
        params.put("inicio", "2021-04-01T16:01:35Z");
        params.put("fim", "2021-04-21T16:01:35Z");
        try {
            Gerencianet gn = new Gerencianet(options);
            return gn.call("pixListCharges", params, new HashMap<>());
        } catch (GerencianetException e) {
            System.out.println(e.getError());
            System.out.println(e.getErrorDescription());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Map.of();
    }
}
