package demo.sprint.repository.walmart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static demo.sprint.repository.walmart.stub.WalmartRepositoryStub.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
class WalmartRepositoryTest {
    @Autowired
    private WalmartRepository walmartRepository;

    @BeforeEach
    void beforeEach() {
        var entity = expectedEntityStub();
        walmartRepository.save(entity);
    }

    @AfterEach
    void tearDown() {
        walmartRepository.deleteAll();
    }

    @Test
    void testingFindById() {
        var expected = expectedRequiredStub();

        var actual = walmartRepository.findById("841765146");

        assertEquals(expected, actual);
    }

    @Test
    void testFindAll() {
        assertThat(walmartRepository.findAll()).isNotEmpty();
    }

    @Test
    @DisplayName("Testing findByNameContains")
    void testFindByNameContains() {
        var expected = expectedResponseFindByNameStub();

        var actual = walmartRepository.findByNameContains("PlayStation");

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing findCustom")
    void testQueryClass() {
        var query = actualQueryStub();
        var listStub = expectedResponseQueryStub();

        var actual = walmartRepository.findCustom(query);

        assertEquals(listStub, actual);
    }
}
