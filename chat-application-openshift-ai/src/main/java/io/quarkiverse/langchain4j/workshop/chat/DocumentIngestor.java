package io.quarkiverse.langchain4j.workshop.chat;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.qdrant.Qdrant;
import org.apache.camel.component.qdrant.QdrantAction;
import org.apache.camel.spi.DataType;

@ApplicationScoped
public class DocumentIngestor extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:src/main/resources/catalog?noop=true")
            .log("body :: ${body}")
            .convertBodyTo(String.class)
            .to("langchain-embeddings:hello&embedding-model=#embeddingModel")
            .setHeader(Qdrant.Headers.ACTION, constant(QdrantAction.UPSERT))
            .transform(new DataType("qdrant:embeddings"))
            .to("qdrant:camel");

    }

}
