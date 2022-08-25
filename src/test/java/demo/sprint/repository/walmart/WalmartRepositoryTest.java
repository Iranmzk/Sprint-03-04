package demo.sprint.repository.walmart;

import demo.sprint.repository.WalmartRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;

import static demo.sprint.repository.walmart.stub.WalmartRepositoryStub.expectedEntityStub;
import static demo.sprint.repository.walmart.stub.WalmartRepositoryStub.expectedRequiredStub;
import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class WalmartRepositoryTest {
    @Autowired
    private WalmartRepository walmartRepository;

    @AfterEach
    void tearDown() {
        walmartRepository.deleteAll();
    }

    @Test
    void teste1(@Autowired MongoTemplate template){
       var expected = expectedRequiredStub();
       var entity = expectedEntityStub();

       template.save(entity);

       var actual = walmartRepository.findById("54457638");

       assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testando se está salvando no repositório")
    void teste2(@Autowired MongoTemplate template) {
        var entity = expectedEntityStub();

        template.save(entity);

        var actual = walmartRepository.findByNameContains("Gift Card", Pageable.ofSize(1));

        assertNull(actual);
    }
}