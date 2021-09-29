package br.com.zupacademy.transacoes.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KafkaErrHandler implements ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaErrHandler.class);

    private void procuraSerializeException(Exception e, Consumer<?, ?> consumer) {
        String pattern = ".*partition (.*) at offset ([0-9]*).*";
        Pattern r = Pattern.compile(pattern);

        Matcher matcher = r.matcher(e.getMessage());

        if (matcher.find()) {
            int idx = matcher.group(1).lastIndexOf("-");
            String topics = matcher.group(1).substring(0, idx);
            int partition = Integer.parseInt(matcher.group(1).substring(idx));
            int offset = Integer.parseInt(matcher.group(2));

            TopicPartition topicPartition = new TopicPartition(topics, partition);

            consumer.seek(topicPartition, (offset + 1));

            LOGGER.info("Pulou mensagem com offset {} da partition {}", offset, partition);
        }
    }

    @Override
    public void handle(Exception e, ConsumerRecord<?, ?> registro, Consumer<?, ?> consumer) {
        LOGGER.error("Erro no processo, exception {}, registro {}", e.getMessage(), registro);

        if (e instanceof SerializationException)
            procuraSerializeException(e, consumer);
    }

    @Override
    public void handle(Exception e, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer,
                       MessageListenerContainer container) {
        LOGGER.error("Erro no processo, exception {}", e.getMessage());

        if (e instanceof SerializationException)
            procuraSerializeException(e, consumer);

    }

    @Override
    public void handle(Exception e, ConsumerRecord<?, ?> record) {
        LOGGER.error("Erro no processo, exception {}", e.getMessage());
    }

}