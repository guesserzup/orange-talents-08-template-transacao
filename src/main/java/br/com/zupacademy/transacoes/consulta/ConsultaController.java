package br.com.zupacademy.transacoes.consulta;

import br.com.zupacademy.transacoes.cartao.Cartao;
import br.com.zupacademy.transacoes.transacao.Transacao;
import br.com.zupacademy.transacoes.cartao.CartaoRepository;
import br.com.zupacademy.transacoes.transacao.TransacaoDto;
import br.com.zupacademy.transacoes.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/compras")
public class ConsultaController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> busca(@PathVariable Long idCartao) {

        Cartao cartao = cartaoRepository.findById(idCartao).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não existente!"));

        List<Transacao> transacoes = transacaoRepository.findTop10ByCartao(cartao);
        List<TransacaoDto> listaTransacoesDto = transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaTransacoesDto);
    }
}
