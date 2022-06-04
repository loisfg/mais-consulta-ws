package com.bandtec.mais.consulta.usecase.payment.pix;

import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;
import com.bandtec.mais.consulta.Credentials;
import com.bandtec.mais.consulta.usecase.payment.IPaymentGetQrCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GetQrCodePixIPayment implements IPaymentGetQrCode {
    @Override
    public Map<String, Object> execute(Credentials credentials, String idPixPayment) {
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("client_id", credentials.getClientId());
        options.put("client_secret", credentials.getClientSecret());
        options.put("pix_cert", credentials.getCertificadoPix());
        options.put("sandbox", credentials.isSandbox());

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id", idPixPayment);

        try {
            Gerencianet gn = new Gerencianet(options);

            return gn.call("pixGenerateQRCode", params, new HashMap<String, Object>());

        } catch (GerencianetException e) {
            System.out.println(e.getError());
            System.out.println(e.getErrorDescription());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
