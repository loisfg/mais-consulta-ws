package com.bandtec.mais.consulta.usecase.payment.pix;

import br.com.gerencianet.gnsdk.Gerencianet;
import br.com.gerencianet.gnsdk.exceptions.GerencianetException;
import com.bandtec.mais.consulta.Credentials;
import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.models.dto.request.PaymentPostRequestDTO;
import com.bandtec.mais.consulta.usecase.payment.IPaymentPost;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentPixPost implements IPaymentPost {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public Map<String, Object> execute(Credentials credentials, PaymentPostRequestDTO paymentPostRequestDTO) {
        Patient patient = patientRepository.getById(paymentPostRequestDTO.getIdPatient());
        Clinic clinic = clinicRepository.getById(paymentPostRequestDTO.getIdClinic());

        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("client_id", credentials.getClientId());
        options.put("client_secret", credentials.getClientSecret());
        options.put("pix_cert", credentials.getCertificadoPix());
        options.put("sandbox", credentials.isSandbox());

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("txid", " ");

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("calendario", new JSONObject().put("expiracao", 3600));
        body.put("devedor", new JSONObject().put("cpf", "36014447806").put("nome", "Luis Fernando Rocha"));
        body.put("valor", new JSONObject().put("original", "0.01"));
        body.put("chave", "ed35ef49-f33f-4db1-9611-3826a35a6320");
        body.put("solicitacaoPagador", "Serviço realizado.");

        List<Object> infoAdicionais = new ArrayList<Object>();
        infoAdicionais.add(new JSONObject().put("nome", "Campo 1").put("valor", "Informação Adicional1 do PSP-Recebedor"));
        infoAdicionais.add(new JSONObject().put("nome", "Campo 2").put("valor", "Informação Adicional2 do PSP-Recebedor"));
        body.put("infoAdicionais", infoAdicionais);

        try {
            Gerencianet gn = new Gerencianet(options);
            Map<String, Object> response = gn.call("pixCreateImmediateCharge", params, body);
            System.out.println(response);
            return response;
        } catch (GerencianetException e) {
            System.out.println(e.getError());
            System.out.println(e.getErrorDescription());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Map.of();
    }
}
