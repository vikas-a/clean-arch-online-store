package org.learn.store.gateways.cart.nosql;

import org.learn.store.gateways.cart.nosql.exception.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class OrderIdSequenceGateway {
    static final String ORDER_NUMBER_SEQ_KEY = "order_id_key";
    static final String ORDER_ID_SEQUENCE = "orderIdSequence";

    @Autowired
    private MongoTemplate sequenceRepository;

    public long getNextOrderId() {
        Query query = new Query(Criteria.where("_id").is(ORDER_NUMBER_SEQ_KEY));
        Update update = new Update().inc(ORDER_ID_SEQUENCE, 1);
        FindAndModifyOptions ops = new FindAndModifyOptions();
        ops.returnNew(true);

        OrderIdSequence orderIdSeq = sequenceRepository.findAndModify(query, update, ops, OrderIdSequence.class);

        if (orderIdSeq == null) {
            throw new SequenceException("Unable to get next order id from collection : " + ORDER_ID_SEQUENCE);
        }

        return orderIdSeq.getOrderIdSequence();
    }

    @Document(collection = ORDER_ID_SEQUENCE)
    static class OrderIdSequence {
        @Id
        private final String id;
        private final long orderIdSequence;

        public OrderIdSequence(String id, long orderIdSequence) {
            this.id = id;
            this.orderIdSequence = orderIdSequence;
        }

        public long getOrderIdSequence() {
            return orderIdSequence;
        }
    }
}

