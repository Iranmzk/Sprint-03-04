package demo.sprint.repository.walmart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static demo.sprint.repository.walmart.stub.WalmartRepositoryStub.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class WalmartRepositoryTest {
    @Autowired
    private WalmartRepository walmartRepository;

    @AfterEach
    void tearDown() {
        walmartRepository.deleteAll();
    }

    @Test
    @DisplayName("Test findById")
    void teste1(){
       var expected = expectedRequiredStub();
       var entity = expectedEntityStub();

       walmartRepository.save(entity);

       var actual = walmartRepository.findById("54457638");

       assertEquals(expected, actual);
    }

    @Test
    @DisplayName("testando se o repositorio está vazio")
    void teste2() {
        assertThat(walmartRepository.findAll()).isEmpty();
    }

    @Test
    @DisplayName("testando se o repositorio está salvando")
    void teste3() {
        var expected = expectedResponseFindByNameStub();
        var entity = expectedEntityStub();
        walmartRepository.save(entity);

        assertThat(walmartRepository.findAll()).isEqualTo(expected);
    }

//    @Test
//    @DisplayName("Testing findByNameContains")
//    void test4() {
//        var expected = expectedResponseFindByNameStub();
//        var entity = expectedEntityStub();
//
//        walmartRepository.save(entity);
//
//        var actual = walmartRepository.findByNameContains("Birthday Walmart Gift Card");
//
//        assertEquals(expected, actual);
//    }

    @Test
    void test5(){

    }
}