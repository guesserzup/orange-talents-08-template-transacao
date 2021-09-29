package br.com.zupacademy.transacoes.consulta;

import br.com.zupacademy.transacoes.model.Cartao;
import br.com.zupacademy.transacoes.model.Transacao;
import br.com.zupacademy.transacoes.repository.CartaoRepository;
import br.com.zupacademy.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ConsultaController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> busca(@PathVariable Long idCartao) {

        Cartao cartao = cartaoRepository.findById(idCartao).orElse(null);

        List<Transacao> transacoes = transacaoRepository.findAllByCartao(cartao);

        return ResponseEntity.ok().body(transacoes);
    }


}
