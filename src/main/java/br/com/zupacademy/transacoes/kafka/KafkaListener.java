package br.com.zupacademy.transacoes.kafka;

import br.com.zupacademy.transacoes.form.TransacaoForm;
import br.com.zupacademy.transacoes.model.Transacao;
import br.com.zupacademy.transacoes.repository.CartaoRepository;
import br.com.zupacademy.transacoes.repository.EstabelecimentoRepository;
import br.com.zupacademy.transacoes.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaListener.class);

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @org.springframework.kafka.annotation.KafkaListener(topics = "${spring.kafka.topic}")
    public void listen(TransacaoForm transacaoForm) {
        try {

            Transacao transacao = transacaoForm.toModel(cartaoRepository, estabelecimentoRepository);

            transacaoRepository.save(transacao);

            LOGGER.info("Leitura realizada com sucesso - id da mensagem:" + transacaoForm.getId() + ", id da transação: " + transacao.getId() + ", valor da transação: " + transacao.getValor());
        } catch (Exception exception) {

            LOGGER.error("Erro na hora de armazenar leitura: " + transacaoForm.getId() + "Mensagem do erro: " + exception.getMessage());
        }
    }
}
