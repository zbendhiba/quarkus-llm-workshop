package io.quarkiverse.langchain4j.workshop.chat;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.AllMiniLmL6V2EmbeddingModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.retriever.EmbeddingStoreRetriever;
import dev.langchain4j.retriever.Retriever;
import io.quarkiverse.langchain4j.redis.RedisEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.function.Supplier;

@ApplicationScoped
public class DocumentRetriever implements Supplier<RetrievalAugmentor> {

    private final RetrievalAugmentor augmentor;

    DocumentRetriever(RedisEmbeddingStore store, AllMiniLmL6V2EmbeddingModel model) {
        EmbeddingStoreContentRetriever contentRetriever = EmbeddingStoreContentRetriever.builder()
            .embeddingModel(model)
            .embeddingStore(store)
            .maxResults(3)
            .build();

        augmentor = DefaultRetrievalAugmentor
            .builder()
            .contentRetriever(contentRetriever)
            .build();
    }

    @Override
    public RetrievalAugmentor get() {
        return augmentor;
    }

}
